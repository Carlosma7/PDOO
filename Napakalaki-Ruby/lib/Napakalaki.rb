# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  
require "singleton"
require_relative "Player"
require_relative "Card_dealer"
require_relative "Treasure"

class Napakalaki
  
  include Singleton
  
  #Atributos
  attr_accessor :currentPlayer, :players, :dealer, :currentMonster
  
    
    def initPlayers(names)
      @dealer = CardDealer.instance
      
      @players = Array.new # Inicializamos el array
        for n in names
           players << Player.new(n)
        end
    end
    
    def nextPlayer
        
        total_of_players = @players.length

        # Primer jugador de la partida
        if (@currentPlayer == nil) then
            
            
            indice_current = rand(total_of_players)
            
        else

            indice_jugador_actual = @players.index(@currentPlayer)
      
            if indice_jugador_actual == total_of_players-1 then
                #Si es el último seleccionamos el primero
                indice_current = 0

            else
                #Seleccionamos el siguiente
                indice_current = indice_jugador_actual + 1
            end

        end

      
      @currentPlayer = @players[indice_current]

        return @currentPlayer
    end
    
    
    def nextTurnAllowed
      permitido=false
        
      if @current_player == nil then
            permitido = true
        else
            permitido = @currentPlayer.validState
        end
        
      return permitido
    end
    
    def setEnemies
        enemy_set=players[rand(players.size)]
        
        for p in players
            while p==enemy_set
                enemy_set=players[rand(players.size)]
            end
            
            p.enemy=enemy_set;
            
        end
    end
    
    def developCombat
      combat = @currentPlayer.combat(self.currentMonster)
        
       return combat;
    end
    
    def discardVisibleTreasures(treasures)
      for t in treasures
        @currentPlayer.discardVisibleTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end
    
    def discardHiddenTreasures(treasures)
      for t in treasures
        @currentPlayer.discardHiddenTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end
    
    def makeTreasuresVisible(treasures)
      for t in treasures
            @currentPlayer.makeTreasureVisible (t)
      end
    end
    
    def initGame(players)
      self.initPlayers(players);
      self.setEnemies;
      @dealer.initCards;
      self.nextTurn;
    end
    
    def getCurrentPlayer
      return @currentPlayer
    end
    
    def getCurrentMonster
      return @currentMonster
    end
    
    def nextTurn
      stateOK = nextTurnAllowed
      if stateOK then

            @currentMonster = @dealer.nextMonster

            @currentPlayer = nextPlayer

            dead = @currentPlayer.isDead

            if dead then
              
                @currentPlayer.initTreasures

            end
      end
      
      return stateOK
    end
    
    def endOfGame(result)
      end_game=false
        
      if(result==CombatResult.WINGAME)
          end_game=true;
      end
        
      return end_game;
    end
end

end
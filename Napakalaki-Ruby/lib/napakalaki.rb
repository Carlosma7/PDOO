# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"

class Napakalaki
  
  include Singleton
  
  #Atributos
  attr_accessor :current_player, :players, :dealer, :current_monster
  
    
    private def initPlayers(names)
        @players = Array.new# Inicializamos el array
        for n in names
           players << Player.new(n)
        end
    end
    
    private def nextPlayer
        nextPlayer  #Variable a devolver por el metodo
        
        tam=players.size #Guardamos el tamaño del array de jugadores
        turno #Turno del jugador que sea
        
               
        if()  #No iniciada
            turno=rand(tam)
            nextPlayer=players[turno]
        else  #Iniciada
            if(turno==tam-1)
                turno=0
            else
                turno=turno+1
            end
            nextPlayer=players[turno]
        end
        
        return nextPlayer
    end
    
    def nextTurnAllowed
      permitido=false
        
      if(currentPlayer.validState)
          permitido=true
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
      self.iniPlayers(players);
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
      stateOK = next_turn_allowed
      if stateOK then

            @currentMonster = @dealer.nextMonster

            @currentPlayer = nextPlayer

            dead = @currentPlayer.isDead

            if dead then
              
                @current_player.initTreasures

            end
      end
    end
    
    def endOfGame(result)
      end_game=false
        
      if(result==CombatResult.WINGAME)
          end_game=true;
      end
        
      return end_game;
    end
end

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"

class Napakalaki
  
  include Singleton
  
  def initialize(resultado)
    @result=resultado
    @players
  end
    
    def Napakalaki
    
    end
    
    private def initPlayers(names)
        @players = Array.new# Inicializamos el array
        for n in names
           players << Player.new(n)
        end
    end
    
    def nextPlayer
      
    end
    
    def nextTurnAllowed
      
    end
    
    def setEnemies
      
    end
    
    def developCombat
      
    end
    
    def discardVisibleTreasures(treasures)
      
    end
    
    def discardHiddenTreasures(treasures)
      
    end
    
    def makeTreasuresVisible(treasures)
      
    end
    
    def initGame(players)
      
    end
    
    def getCurrentPlayer
      
    end
    
    def getCurrentMonster
      
    end
    
    def nextTurn
      
    end
    
    def endOfGame(result)
      
    end
end

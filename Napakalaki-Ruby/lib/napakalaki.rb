# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require "singleton"

class Napakalaki
  
  include Singleton
  
  def initialize
    
  end
  
  
  @@instance = null
    #private static final Napakalaki instance = new Napakalaki();
    
    def Napakalaki() end
    
    def initPlayers(names) end
    
    def nextPlayer() end
    
    def nextTurnAllowed() end
    
    def setEnemies() end
    
    def getInstance() end #########################
    
    def developCombat() end
    
    def discardVisibleTreasures(treasures) end
    
    def discardHiddenTreasures(treasures) end
    
    def makeTreasuresVisible(treasures) end
    
    def initGame(players) end
    
    def getCurrentPlayer() end
    
    def getCurrentMonster() end
    
    def nextTurn() end
    
    def endOfGame(result) end
end

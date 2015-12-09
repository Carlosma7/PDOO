# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CultistPlayer < Player
  
  #Atributos
  attr_accessor :myCultistCard
  
  @@totalCultistPlayers=0
  
  def initialize(player,c)
    super(player.name)
    
    ConstructorCopia(player)
    
    @myCultistCard = c
    @@total_cultist_players += 1
  end
  
  
  #protected
  def getCombatLevel
      final_level=super.getCombatLevel + ((super.getCombatLevel)*20/100)
      final_level= final_level + (@myCultistCard.getGainedLevels * @@totalCultistPlayers);
        
      return final_level
  end
    
  def getOponentLevel(m)
     return m.getCombatLevelAgainstCultistPlayer
  end
    
  def shouldConvert()
        return false
  end
    
  def Treasure giveMeATreasure
    return @visibleTreasures.get(rand(hiddenTreasures.length));
  end
    
  def canYouGiveMeATreasure
    if(!@visibleTreasures.empty?)
      return true
    else
      return false
    end
  end
    
  def self.getTotalCultistPlayers
    return @@totalCultistPlayers
  end
end

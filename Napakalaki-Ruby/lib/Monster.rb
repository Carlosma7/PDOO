# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  
require_relative "Prize"
require_relative "Bad_consequence"

class Monster
  
  def initialize(name,combatLevel,badConsequence,prize)
    @name=name
    @combatLevel=combatLevel
    @badConsequence=badConsequence
    @price=prize
  end
  
  #Consultores
  attr_reader:name
  attr_reader:combatLevel
  attr_reader:badConsequence
  attr_reader:price
  
  
  # Metodo to_s
  def to_s
  "Nombre monstruo: #{@name} \nNivel de combate: #{@combatLevel}"
  end
  
  # Metodo Consultor nivel de combate superior a 10
  def LevelExceeding10
    if @combatLevel>10
      true
    end
  end
  
  # Metodo Consultor de mal rollo que solo implique perdida de niveles
  def OnlyLevelsBadConsequence
    if (@badConsequence.levels>0) && (@badConsequence.nVisibleTreasures==0) &&
        (@badConsequence.nHiddenTreasures==0)
      true
    end
  end
  
  # Metodo Consultor de buen rollo con nivel superior a 1
  def PrizeLevelsExceeding1
    if @price.level>1
      true
    end
  end
  
  # Metodo Consultor mal rollo que suponga la pérdida de un 
  # determinado tipo de tesoros ya sea visibles y/o ocultos
  def LoseSpecificTreasures
    if (@badConsequence.someVisibleTreasures!=0) || (@badConsequence.someHiddenTreasures!=0)
      true
    end
  end
  
  def getLevelsGained
    @price.level
  end
    
  
  def getTreasuresGained
    @price.treasures
  end
  
end

end
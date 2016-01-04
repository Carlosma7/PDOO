module NapakalakiGame
  class BadConsequence
  
  @@MAXTREASURES=10
  
  
  def initialize(aText, someLevels)
    @text=aText    # Mensaje de mal rollo
    @levels=someLevels  # Level que se pierden
    
   
  end
  
  # Metodo que devuelve MAXTREASURES
  def self.MAXTREASURES
    @@MAXTREASURES=10
    
    return @@MAXTREASURES
  end
  
  def isEmpty
    #Metodo Abstracto, se redefine en cada subclase
  end
  
  def substractVisibleTreasure(treasure)
    #Metodo Abstracto, se redefine en cada subclase
  end
  
  def substractHiddenTreasure(treasure) 
    #Metodo Abstracto, se redefine en cada subclase
  end
  
  def adjustToFitTreasureLists(v,h)
    #Metodo Abstracto, se redefine en cada subclase
  end
  
  
  #Consultores
  attr_reader:text
  attr_reader:levels
  attr_reader:MAXTREASURES
              
  def to_s
  "Texto: #{@text}. Niveles perdidos: #{@levels}"
  end
 
end

end

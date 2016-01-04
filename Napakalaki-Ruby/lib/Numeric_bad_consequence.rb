# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "Bad_consequence"

module NapakalakiGame
class NumericBadConsequence < BadConsequence
  
  
  attr_reader:nVisibleTreasures,:nHiddenTreasures
  
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    super(aText,someLevels)
    
    @nVisibleTreasures=someVisibleTreasures  # Nº tesoros visibles que se pierden
    @nHiddenTreasures=someHiddenTreasures   # Nº tesoros ocultos que se pierden
  end
  
  def isEmpty
    empty=false
    
    if((@nVisibleTreasures==0) && (@nHiddenTreasures==0))
      empty=true
    end
    
  end
  
  def substractVisibleTreasure(treasure) 
    
    @nVisibleTreasures=@nVisibleTreasures-1
  end
  
  def substractHiddenTreasure(treasure) 
    
    @nHiddenTreasures=@nHiddenTreasures-1
  end
  
  def adjustToFitTreasureLists(v,h)
      
      #Ajustamos segun el tamaño de los visibles
      if @nVisibleTreasures>v.length 
        nV=v.length
      else
        nV=@nVisibleTreasures
      end
      
      #Ajustamos segun el tamaño de los ocultos
      if @nHiddenTreasures>h.length 
        nH=h.length
      else
        nH=@nHiddenTreasures
      end
      
      pending=NumericBadConsequence.new(@text,@levels,nV,nH)
  end
end
end

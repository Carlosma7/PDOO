# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "Bad_consequence"

module NapakalakiGame
class SpecificBadConsequence < BadConsequence
  
  attr_reader:someVisibleTreasures,:someHiddenTreasures
  
  def initialize(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    super(aText,someLevels)
    
    @someVisibleTreasures=someSpecificVisibleTreasures #Tesoro especifico visible
    @someHiddenTreasures=someSpecificHiddenTreasures   #Tesoro especifico invisible
  end
  
  def isEmpty
    empty=false
    
    if ((@someVisibleTreasures==0) && (@someHiddenTreasures==0))
      empty=true
    else if((@someVisibleTreasures.empty?) && (@someHiddenTreasures.empty?))
            empty=true
         else
            empty=false
         end
    end
    
    return empty
  end
  
  def substractVisibleTreasure(treasure) 
    
    @someVisibleTreasures.delete(treasure.type)
  end
  
  def substractHiddenTreasure(treasure) 
    
    @someHiddenTreasures.delete(treasure.type)
  end
  
  def adjustToFitTreasureLists(v,h)
      # Arrays para pasar de tesoros a tipos de tesoros
      copy_visibles=Array.new
      copy_hidden=Array.new
      
      # Arrays que se van a añadir a la BadConsequence
      nV=Array.new
      nH=Array.new
      
      # Copiamos los tipos de tesoros de v
      for t in v
        copy_visibles << t.type
      end
      
      # Copiamos los tipos de tesoros de h
      for t in h
        copy_hidden << t.type
      end
      
      # Guardamos los valores comunes
      if @someVisibleTreasures!=0
      for t in copy_visibles
        if @someVisibleTreasures.index(t)!=nil then
          nV << t
          @someVisibleTreasures.delete_at(@someVisibleTreasures.index(t))
        end
      end
      
      end
      
      # Guardamos los valores comunes
      if @someHiddenTreasures!=0
      for t in copy_hidden
        if @someHiddenTreasures.index(t)!=nil then
          nH << t
          @someHiddenTreasures.delete_at(@someHiddenTreasures.index(t))
        end
      end
      
      end
      
      pending=SpecificBadConsequence.new(@text,@levels,nV,nH)
    
    
    return pending
  end
  
end
end

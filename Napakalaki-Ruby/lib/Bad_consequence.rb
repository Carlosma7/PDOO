module NapakalakiGame
  class BadConsequence
  
  private_class_method:new
  
  @@MAXTREASURES=10
  
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,
    someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text=aText    # Mensaje de mal rollo
    @levels=someLevels  # Level que se pierden
    @nVisibleTreasures=someVisibleTreasures  # Nº tesoros visibles que se pierden
    @nHiddenTreasures=someHiddenTreasures   # Nº tesoros ocultos que se pierden
    
    @someVisibleTreasures=someSpecificVisibleTreasures #Tesoro especifico visible
    @someHiddenTreasures=someSpecificHiddenTreasures   #Tesoro especifico invisible
    
    @death=death   # Indica si muere el jugador o no
    
   
  end
  
  #Llama al constructor
  def self.newLevelNumberOfTreasures (aText, someLevels,
    someVisibleTreasures, someHiddenTreasures)
  
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, 0, 0, false)
  end
  
  #Llama al constructor
  def self.newLevelSpecificTreasures (aText, someLevels,
    someSpecificVisibleTreasures, someSpecificHiddenTreasures)
  
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end
  
  #Llama al constructor
  def self.newDeath (aText)
    
    new(aText, 10, @@MAXTREASURES, @@MAXTREASURES, 0, 0, true)
    
  end
  
  # Metodo que devuelve MAXTREASURES
  def self.MAXTREASURES
    @@MAXTREASURES=10
    
    return @@MAXTREASURES
  end
  
  def isEmpty
    empty=false
    
    if((@nVisibleTreasures==0) && (@nHiddenTreasures==0))
      if ((@someVisibleTreasures==0) && (@someHiddenTreasures==0))
        true
      else if((@someVisibleTreasures.empty?) && (@someHiddenTreasures.empty?))
              true
           else
              false
           end
      end
      
    else
      false
    end
    
    if @death==true
      empty=false
    end
    
    return empty
  end
  
  def substractVisibleTreasure(treasure) 
    
    @someVisibleTreasures.delete(treasure.type);
  end
  
  def substractHiddenTreasure(treasure) 
    
    @someVisibleTreasures.delete(treasure.type);
  end
  
  def adjustToFitTreasureLists(v,h)
    if @nVisibleTreasures!=0 || @nHiddenTreasures!=0 then
      
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
      
      pending=BadConsequence.newLevelNumberOfTreasures(@text,@levels,nV,nH)
    
    else
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
      
      pending=BadConsequence.newLevelSpecificTreasures(@text,@levels,nV,nH)
      
    end
    
    
    return pending
  end
  
  
  #Consultores
  attr_reader:text
  attr_reader:levels
  attr_reader:nVisibleTreasures
  attr_reader:nHiddenTreasures
  attr_reader:someVisibleTreasures
  attr_reader:someHiddenTreasures
  attr_reader:death
  attr_reader:MAXTREASURES
              
  def to_s
  "Texto: #{@text} \nNiveles perdidos: #{@levels} \nTesoros visibles: #{@nVisibleTreasures} \nTesoros ocultos: #{@nHiddenTreasures}
Tesoro Especifico visible: #{@someVisibleTreasures} \nTesoro Especifico oculto: #{@someHiddenTreasures} \nMuerte: #{@death}"
  end
 
end

end

# Author: Javier Aranda

module NapakalakiGame
  
require_relative 'Treasure'
require_relative 'Monster'
require_relative 'Treasure_kind'
require_relative 'Combat_result'
require_relative 'Dice'

class Player
  
  #Atributos
    attr_reader :dead, :name, :level, :visibleTreasures, :hiddenTreasures, :pendingBadConsequence, :canISteal, :MAXLEVEL
    attr_accessor :enemy
  
  @@MAXLEVEL = 10
  def initialize(name)
      @name = name
      
      @dead = true
      
      @enemy=nil
      @canISteal=true
      @level = 1
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      
  end
  
  def ConstructorCopia(p)
    @name = p.name
    @level = p.level
    @pendingBadConsequence = p.pendingBadConsequence
    @dead = p.dead
    @hiddenTreasures = p.hiddenTreasures
    @visibleTreasures = p.visibleTreasures
  end
  
  # ------------ Metodos publicos --------------------
  
  # Metodo isDead
  def isDead
    return @dead
  end
  
  
  # Metodo getVisibleTreasures
  def getVisibleTreasures()
    return @visibleTreasures
  end
  
  # Metodo getHiddenTreasures
  def getHiddenTreasures()
    return @hiddenTreasures
  end
  
  # Metodo combat
  def combat (m)
        
    myLevel= self.getCombatLevel
    monsterLevel=self.getOponentLevel(m)
        
    if (myLevel>monsterLevel)
      self.applyPrize(m)
            
      if(self.level >MAXLEVEL)
        result=CombatResult::WINGAME;
      else
        result=CombatResult::WIN;
      end
    else if(shouldConvert)
            result=CombatResult::LOSEANDCONVERT
         else
            applyBadConsequence(m)
            result=CombatResult::LOSE
      end
    end
        
    return result;
  end
  
  # Metodo makeTreasureVisible
  def makeTreasureVisible (t)
    can_i = canMakeTreasureVisible(t)

    if can_i then
      @visibleTreasures << t
      @hiddenTreasures.delete(t)
    end
  end
  
  # Metodo discardVisibleTreasure
  def discardVisibleTreasures(t)
    @visibleTreasures.delete(t)

    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then

      @pendingBadConsequence.substractVisibleTreasure(t)

    end

    self.dieIfNoTreasures
  end
  
  # Metodo discardHiddenTreasure
  def discardHiddenTreasures(t)
    @hiddenTreasures.delete(t)

    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then

      @pendingBadConsequence.substractHiddenTreasure(t)

    end

    dieIfNoTreasures
  end
  
  # Metodo validState

  def validState
    if @pendigBadConsequence.isEmpty && @hiddenTreasures.length<=4
      return true
    else
      return false
    end
  end
  
  # Metodo initTreaures
  def initTreasures
    dealer= CardDealer.instance
    dice = Dice.instance
        
    self.bringToLife
    
    treasure = dealer.nextTreasure
        
    @hiddenTreasures << treasure
    
    number=dice.nextNumber
    
    if number>1 then
        treasure=dealer.nextTreasure
        @hiddenTreasures << treasure
    end
        
    if number==6 then
        treasure=dealer.nextTreasure
        @hiddenTreasures << treasure
    end
  end
  
  # Metodo getLevels
  def getLevels
    return @level
  end
  
  # Metodo stealTreasure
  def stealTreasure
    
    if self.canISteal then
      if @enemy.canYouGiveMeATreasure then
        treasure = @enemy.giveMeATreasure
        @hiddenTreasures << treasure
        self.haveStolen
      end
    end
  end
  
  # Metodo setEnemy
  def setEnemy(enemy)
    @enemy=enemy
    
  end
  
  # Metodo canISteal
  def canISteal
    if @canISteal==true
      return true
    else
      return false
    end
  end
  
  # Metodo discardAllTreasures
  def discardAllTreasures
    for t in visibleTreasures
      self.discardVisibleTreasures(t)
    end
    
    for t in hiddenTreasures
      self.discardHiddenTreasures(t)
    end
  end
  
  # --------------- Metodos Privados ----------
  
  # Motodo bringToLife
  def bringToLife
    @dead = false
  end
  
  # Motodo getCombatLevel
  def getCombatLevel
    nivel=@level
    for t in @visibleTreasures
        nivel=nivel+t.bonus
    end
    
    return nivel
    
  end
  
  # Metodo incrementLevels
  def incrementLevels(l)
    level = level + l
    
  end
  
  # Metodo decrementLevels
  def decrementLevels(l)
    @level = @level-l
    
    if @level < 1 then
      @level=1
    end
  end
  
  # Metodo setPendingBadConsequence
  def setPendingBadConsequence(b)
    @pendingBadConsequence = b
    
  end
  
  # Metodo applyPrize
  def applyPrize(m)
    nLevels=m.getLevelsGained
    
    this.incrementLevels(nLevels)
    
    nTreasures=m.getTreasuresGained
    
    if nTreasures>0 then
      dealer = CardDealer.instance
      
      for i in 1..nTreasures
        t=dealer.nextTreasure
        self.hiddenTreasures << t
      end
    end
  end
  
  # Metodo applyBadConsequence
  def applyBadConsequence(m)
    badConsequence=m.badConsequence
    
    nLevels=badConsequence.levels
    
    self.decrementLevels(nLevels)
    
    pendingBad = badConsequence.adjustToFitTreasureLists(self.visibleTreasures, self.hiddenTreasures)
    
    self.setPendingBadConsequence(pendingBad)
  end
  
  
  # Metodo canMakeTreasureVisible
  def canMakeTreasureVisible(t)

      result = false

      case t.type

      when ONEHAND 
        
        #Si está equipado con dos manos no puede agregar un tesoro de una mano
        if UsingTreasureKind(BOTHHAND) then
          result = false
        else

          #Recorremos los tesoros visibles para ver si ya tiene alguno de una mano (0, 1 o 2)
          i = 0
          for tv in @visibleTreasures
            if tv.type == ONEHAND then
              i += 1
            end
                        
          end

          if i == 2 then
            #Si están las dos manos ocupadas no puede
            result = false
          else
            #En caso contrario si que puede
            result = true
          end
        end

      else  #El resto de casos, si esta en uso false, si no true
        result = !UsingTreasureKind(t.type)

      end

      return result
    end
    
    #Este método lo he hecho personalmente para no duplicar codigo en el método anterior
    def UsingTreasureKind(type) 

      result = false
      for tv in @visibleTreasures
        if type == tv.type then

          result = true
          break

        end

      end
      return result
        
    end
  
  # Metodo howManyVisibleTreasures
  def howManyVisibleTreasures(tKind)
    for t in @visibleTreasures
      if(t.getType == tKind)
        @numeroDeTesoros = @numeroDeTesoros+1
      end
    end
    return numeroDeTesoros
  end
  
  # Metodo dieIfNoTreasures
  def dieIfNoTreasures
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      @dead=true
    end
    
  end
  
  # Metodo giveMeATreasure
  def giveMeATreasure
    n= rand(@hiddenTreasures.length)
    return @hiddenTreasures[n]
  end
  
  # Metodo canYouGiveMeATreasure
  def canYouGiveMeATreasure
    if(@hiddenTreasures.empty?)
      return false
    else 
      return true
    end
  end
  
  # Metodo haveStolen
  def haveStolen
    @canISteal=false
    
  end
  
  def getOponentLevel(m)
    return m.getCombatLevel
  end
    
  def shouldConvert
    should=false
    dice=Dice.instance
        
    resultado=dice.nextNumber
        
    if(resultado==1)
      should=true
    end
        
    return should
  end
  
  def to_s
  "#{@name}. Nivel: #{@level}"
  end
  
end

end
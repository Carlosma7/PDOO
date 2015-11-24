# Author: Javier Aranda
require_relative 'treasure'
require_relative 'monster'
require_relative 'treasure_kind'
require_relative 'combat_result'
require_relative 'dice'

class Player
  
  #Atributos
    attr_reader :dead, :name, :level, :visibleTreasures, :hiddenTreasures, :pendingBadConsequence
  
  @@MAXLEVEL = 10
  def initialize(name)
      @name = name
      
      @dead = false
      
      @level = 1
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      
  end
  
  # ------------ Metodos publicos --------------------
  
  # Metodo isDead
  def isDead
    return @dead
  end
  
  
  # Metodo getVisibleTreasures
  def getVisibleTreasures
    return @visibleTreasures
  end
  
  # Metodo combat
  def combat (m)
    
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
  def discardVisibleTreasure(t)
    @visibleTreasures.delete(t)

    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then

      @pendingBadStuff.substractVisibleTreasure(t)

    end

    dieIfNoTreasures
  end
  
  # Metodo discardHiddenTreasure
  def discardHiddenTreasure(t)
    @hiddenTreasures.delete(t)

    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then

      @pendingBadStuff.substractHiddenTreasure(t)

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
        
    hiddenTreasures << treasure
        
    number=dice.nextNumber
        
    if number>1 then
        treasure=dealer.nextTreasure
        hiddenTreasures << treasure
    end
        
    if number==6 then
        treasure=dealer.nextTreasure
        hiddenTreasures << treasure
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
    if canISteal==true
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
  private def bringToLife
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
  private def incrementLevels(l)
    level = level + l
    
  end
  
  # Metodo decrementLevels
  def decrementLevels(l)
    level = level-l
    
    if @level < 1 then
      @level=1
    end
  end
  
  # Metodo setPendingBadConsequence
  def setPendingBadConsequence(b)
    @pendingBadConsequence = b
    
  end
  
  # Metodo applyPrize
  private def applyPrize(m)
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
  private def applyBadConsequence(m)
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
  private def howManyVisibleTreasures(tKind)
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
  private def canYouGiveMeATreasure
    if(@hiddenTreasures.isEmpty)
      return false
    else 
      return true
    end
  end
  
  # Metodo haveStolen
  private def haveStolen
    @canISteal=false
    
  end
  
end

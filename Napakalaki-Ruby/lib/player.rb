# Author: Javier Aranda

class Player
  
  @@MAXLEVEL = 10
  def initialize(name,level, dead=true, canISteal=true, enemy, visibleTreasures, 
    hiddenTreasures,pendingBadConsequence)
    @level=level
    @name=name
    @dead=dead
    @canISteal=canISteal
 
    # Atributos de referencia
    @enemy=enemy
    @visibleTreasure=visibleTreasures
    @hiddenTreasures=hiddenTreasures # array.new
    @pendingBadConsequence=pendingBadConsequence
  end
  
  # Consultores
  attr_reader :name # Metodo getName()
  attr_reader :level # Metodo getLevel()
  attr_reader :canIsteal #Merodo canISteal()
  
  
  # Constructor con el parametro nombre
  def self.player (name)
    new(name,0,false,false, enemy, )
  end
  
  # ------------ Metodos publicos --------------------
  
  # Metodo isDead
  def isDead
    @dead
  end
  
  
  # Metodo getVisibleTreasures
  def getVisibleTreasures
    
  end
  
  # Metodo combat
  def combat (m)
    
  end
  
  # Metodo makeTreasureVisible
  def makeTreasureVisible (t)
    
  end
  
  # Metodo discardVisibleTreasure
  def discardVisibleTreasure(t)
    
  end
  
  # Metodo discardHiddenTreasure
  def discardHiddenTreasure(t)
    
  end
  
  # Metodo validState

  def validState()
    @pendigBadConsequence.isEmpty && @hiddenTreasures.length<=4
  end
  
  # Metodo initTreaures
  def initTreasures
    
  end
  
  # Metodo getLevels
  def getLevels
    
  end
  
  # Metodo stealTreasure
  def steadTreasure
    
  end
  
  # Metodo setEnemy
  def setEnemy(enemy)
    @enemy=enemy
    
  end
  
  # Metodo canISteal
  def canISteal
    
  end
  
  # Metodo discardAllTreasures
  def discardAllTreasures
    
  end
  
  # --------------- Metodos Privados ----------
  
  # Motodo bringToLife
  private def bringToLife
    @dead = false
  end
  
  # Motodo getCombatLevel
  private def getCombatLevel
    nivel=level
    for t in visibleTreasures
        nivel=nivel+t.bonus
    end
    
    return nivel
    
  end
  
  # Metodo incrementLevels
  private def incrementLevels(l)
    level = level + l
    
  end
  
  # Metodo decrementLevels
  private def decrementLevels(l)
    level = level-l
  end
  
  # Metodo setPendingBadConsequence
  private def setPendingBadConsequence(b)
    @pendinBadConsequence = b
    
  end
  
  # Metodo applyPrize
  private def applyPrize(m)
    
  end
  
  # Metodo applyBadConsequence
  private def applyBadConsequence(m)
    
  end
  
  # Metodo canMakeTreasureVisible
  private def canMakeTreasureVisible(t)
    
  end
  
  # Metodo howManyVisibleTreasures
  private def howManyVisibleTreasures(tKind)
    for t in visibleTreasures
      if(t.getType == tKind)
        @numeroDeTesoros = @numeroDeTesoros+1
      end
    end
    return numeroDeTesoros
  end
  
  # Metodo dieIfNoTreasures
  private def dieIfNoTreasures
    if(visibleTreasure.isEmpty)
      @dead=true
    end
    
  end
  
  # Metodo gifMeATreasure
  private def gifMeATreasure
    
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

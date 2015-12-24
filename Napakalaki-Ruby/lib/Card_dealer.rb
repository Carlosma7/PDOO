#!/usr/bin/env ruby
# encoding: utf-8
# # Autor Javier Aranda
module NapakalakiGame

require 'singleton'
require_relative "Bad_consequence"
require_relative "Numeric_bad_consequence"
require_relative "Specific_bad_consequence"
require_relative "Death_bad_consequence"
require_relative "Treasure"

class CardDealer
  
  include Singleton
  
  #Atributos
  attr_accessor :usedMonsters, :unusedMonsters, :usedTreasures, :unusedTreasures
  
  # ----------------- Metodos Publicos --------------------
  # Metodo initTreasureCardDeck
  def initTreasureCardDeck
    @unusedTreasures=Array.new
    @usedTreasures=Array.new
    
    #Creacion de Tesoro ¡Sí mi amo!
    @unusedTreasures << Treasure.new("¡Si mi amo!", 4,TreasureKind::HELMET)
    #Creacion de Tesoro Capucha de Cthulhu
    @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3,TreasureKind::HELMET)

    #Creacion de Tesoro Botas de lluvia acida
    @unusedTreasures << Treasure.new("Botas de lluvia acida", 1,TreasureKind::BOTHHANDS)

    #Creacion de Tesoro Ametralladora Thompson
    @unusedTreasures << Treasure.new("Ametralladora Thompson", 4,TreasureKind::BOTHHANDS)

    #Creacion de Tesoro Clavo de rail ferroviario
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3,TreasureKind::ONEHAND)

    #Creacion de Tesoro Fez alopodo
    @unusedTreasures << Treasure.new("Fez alopodo", 3,TreasureKind::HELMET)    

    #Creacion de Tesoro El aparato del Pr. Tesla
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4,TreasureKind::ARMOR)

    #Creacion de Tesoro Insecticida
    @unusedTreasures << Treasure.new("Insecticida", 2,TreasureKind::ONEHAND)   

    #Creacion de Garabato mistico
    @unusedTreasures << Treasure.new("Insecticida", 2,TreasureKind::ONEHAND)

    #Creacion de Lanzallamas
    @unusedTreasures << Treasure.new("Lanzallamas", 4,TreasureKind::BOTHHANDS)

    #Creacion de Necronomicon
    @unusedTreasures << Treasure.new("Necronomicon", 5,TreasureKind::BOTHHANDS)

    #Creacion de Necro-gnomicon
    @unusedTreasures << Treasure.new("Necro-gnomicon", 2,TreasureKind::ONEHAND)

    #Creacion de Mazo de los antiguos
    @unusedTreasures << Treasure.new("Mazo de los antiguos", 3,TreasureKind::ONEHAND)

    #Creacion de Porra preternatural
    @unusedTreasures << Treasure.new("Porra preternatural", 2,TreasureKind::ONEHAND)

    #Creacion de Varita de atizamiento
    @unusedTreasures << Treasure.new("Varita de atizamiento", 3,TreasureKind::ONEHAND)

    #Creacion de Zapato deja-amigos
    @unusedTreasures << Treasure.new("Zapato deja-amigos", 1,TreasureKind::SHOES)

    #Creacion de Botas de investigacion
    @unusedTreasures << Treasure.new("Botas de investigacion", 3,TreasureKind::SHOES)

    #Creacion de A prueba de babas
    @unusedTreasures << Treasure.new("A prueba de babas", 2,TreasureKind::ARMOR)

    #Creacion de Casco minero
    @unusedTreasures << Treasure.new("Casco minero", 2,TreasureKind::HELMET)

    #Creacion de Camiseta de la UGR
    @unusedTreasures << Treasure.new("Camiseta de la UGR", 1,TreasureKind::ARMOR)

    #Creacion de Cuchillo de sushi arcano
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2,TreasureKind::ONEHAND)

    #Creacion de Hacha prehistorica
    @unusedTreasures << Treasure.new("Hacha prehistorica", 2,TreasureKind::ONEHAND)

    #Creacion de Gaita
    @unusedTreasures << Treasure.new("Gaita", 4,TreasureKind::BOTHHANDS)

    #Creacion de Escopeta de 3 caniones
    @unusedTreasures << Treasure.new("Escopeta de 3 caniones", 4,TreasureKind::BOTHHANDS)

    #Creacion de La rebeca metalica
    @unusedTreasures << Treasure.new("La rebeca metalica", 2,TreasureKind::ARMOR)

    #Creacion de Necro-comicon
    @unusedTreasures << Treasure.new("Necro-comicon", 1,TreasureKind::ONEHAND)

    #Creacion de Linterna a 2 manos
    @unusedTreasures << Treasure.new("Linterna a 2 manos", 3,TreasureKind::BOTHHANDS)

    #Creacion de Necrotelecom
    @unusedTreasures << Treasure.new("Necrotelecom", 2,TreasureKind::HELMET)

    #Creacion de Necro-playboycon
    @unusedTreasures << Treasure.new("Necro-playboycon", 3,TreasureKind::ONEHAND)

    #Creacion de Shogulador
    @unusedTreasures << Treasure.new("Shogulador", 1,TreasureKind::BOTHHANDS)

    #Creacion de Tentaculo de pega
    @unusedTreasures << Treasure.new("Tentaculo de pega", 2,TreasureKind::HELMET)
  end
  
  # Metodo initMonsterCardDeck
  def initMonsterCardDeck
    @unusedMonsters=Array.new
    @usedMonsters=Array.new
    
    # El gorron en el umbral
    prize = Prize.new(3,1)
    badConsequence = NumericBadConsequence.new("Pierdes todos tus tesoros visibles",BadConsequence.MAXTREASURES, 0, 0)
    @unusedMonsters << Monster.new("El gorron en el umbral",10,badConsequence,prize)

    # 3 Byakhees de bonanza
    prize = Prize.new(2,1)
    badConsequence = SpecificBadConsequence.new("Pierdes tu armadura
    visible y otra oculta",0 , [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @unusedMonsters << Monster.new("3 Byakhees de bonanza",8,badConsequence,prize)
    
    # El sopor de Dunwich
    prize = Prize.new(1,1)
    badConsequence = SpecificBadConsequence.new("El primordial bostezo
    contagioso. Pierdes el calzado visible",0 , [TreasureKind::SHOES], 0)
    @unusedMonsters << Monster.new("El sopor de Dunwich",2,badConsequence,prize)
    
    # H.P. Munchcraft
    prize = Prize.new(2,1)
    badConsequence = SpecificBadConsequence.new("Pierdes la armadura
    visible",0 , [TreasureKind::ARMOR], 0)
    @unusedMonsters << Monster.new("H.P. Munchcraft",6,badConsequence,prize)

    # La que redacta en las tinieblas
    prize = Prize.new(1,1)
    badConsequence = NumericBadConsequence.new("Toses los pulmones y
    pierdes 2 niveles.",2 , 0, 0)
    @unusedMonsters << Monster.new("La que redacta en las tinieblas",2,badConsequence,prize)

    # Semillas Cthulhu
    prize = Prize.new(2,1)
    badConsequence = NumericBadConsequence.new("Pierdes 2 niveles y 2
    tesoros ocultos.",2 , 0, 2)
    @unusedMonsters << Monster.new("Semillas Cthulhu",4,badConsequence,prize)

    # Yskhtihyssg-Goth
    prize = Prize.new(3,1)
    badConsequence = DeathBadConsequence.new("No le hace gracia que
    pronuncien mal su nombre. Estas muerto")
    @unusedMonsters << Monster.new("Yskhtihyssg-Goth",12,badConsequence,prize)

    # El espia
    prize = Prize.new(1,1)
    badConsequence = SpecificBadConsequence.new("Te asusta en la noche.
    Pierdes un casco visible.", 0, [TreasureKind::HELMET],0)
    @unusedMonsters << Monster.new("El espia",5,badConsequence,prize)

    # El Lenguas
    prize = Prize.new(1,1)
    badConsequence = NumericBadConsequence.new("Menudo susto te llevas.
    Pierdes 2 niveles y 5 tesoros visibles.", 2, 5,0)
    @unusedMonsters << Monster.new("El Lenguas",20,badConsequence,prize)

    # Dameargo
    prize = Prize.new(1,1)
    badConsequence = SpecificBadConsequence.new("Te intentas escaquear.
    Pierdes una mano visible.", 0, [TreasureKind::ONEHAND],0)
    @unusedMonsters << Monster.new("Dameargo",20,badConsequence,prize)

    # El rey de rosa
    prize= Prize.new(4,2)
    badConsequence= NumericBadConsequence.new("Pierdes 5 niveles y 3
    tesoros visibles ", 5, 3, 0)
    @unusedMonsters << Monster.new("El rey de Rosa", 13, badConsequence, prize)

    # Chibithulhu
    prize= Prize.new(1,1)
    badConsequence= SpecificBadConsequence.new("Embobados con el lindo
    primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET],0)
    @unusedMonsters << Monster.new("Chibithulhu", 2, badConsequence, prize)

    # Pollipolipo volante
    prize= Prize.new(1,1)
    badConsequence= NumericBadConsequence.new("Da mucho asquito.
    Pierde 3 niveles", 3, 0, 0)
    @unusedMonsters << Monster.new("Pollipolipo volante", 3, badConsequence, prize)

    # Bichgooth
    prize= Prize.new(1,1)
    badConsequence= SpecificBadConsequence.new("Sientes bichos bajo la
    ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR],0)
    @unusedMonsters << Monster.new("Bichgooth", 2, badConsequence, prize)

    # Angeles de la noche ibicenca
    prize= Prize.new(4,1)
    badConsequence= SpecificBadConsequence.new("Te atrapan para llevarte
    de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano
    oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    @unusedMonsters << Monster.new("Angeles de la noche ibicenca",14, badConsequence, prize)

    # Familia Feliz
    prize= Prize.new(4, 1)
    badConsequence= DeathBadConsequence.new("La familia te atrapa. Estas muerto")
    @unusedMonsters << Monster.new("Familia Feliz", 1, badConsequence, prize)

    # Los Hondos
    prize= Prize.new(2,1)
    badConsequence= DeathBadConsequence.new("Estos monstruos resultan bastante
    superficiales y te aburren mortalmente. Estas muerto")
    @unusedMonsters << Monster.new("Los hondos", 8, badConsequence, prize)

    # Roboggoth
    prize= Prize.new(2,1)
    badConsequence= SpecificBadConsequence.new("La quinta directiva 
    primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
    2, [TreasureKind::BOTHHANDS], 0)
    @unusedMonsters << Monster.new("Roboggoth", 8, badConsequence, prize)

    # Bicefalo
    prize= Prize.new(1,1)
    badConsequence= SpecificBadConsequence.new("Te faltan manos para 
    tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
      3, [TreasureKind::SHOES,TreasureKind::ONEHAND,TreasureKind::HELMET,TreasureKind::BOTHHANDS,TreasureKind::ARMOR], 0)
    @unusedMonsters << Monster.new("Bicefalo", 20 , badConsequence, prize)
  end
  
  def initCultistCardDeck
    @unusedCultists=Array.new
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 1)
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 2)
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 1)
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 2)
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 1)
        
    # Creacion de Sectario
    @unusedCultists << Cultist.new("Sectario", 1)
  end
  
  # Metodo nextTreasure
  def nextTreasure
      if @unusedTreasures.empty?
        for t in @usedTreasures 
          @unusedTreasures << t
        end
            
        self.shuffleTreasures
            
        @usedTreasures.clear
        
      end
      
      t = @unusedTreasures.at(0)
        
      @usedTreasures<<t
        
      @unusedTreasures.delete(t);
      
      return t
  end
  
  # Metodo nextMonster
  def nextMonster
    if @unusedMonsters.empty?
            
        for t in @usedMonsters
          @unusedMonsters << t
        end
           
        shuffleMonsters
            
        @usedMonsters.clear
        
      end
        
      m = @unusedMonsters.at(0)
        
      @usedMonsters << m
      
      @unusedMonsters.delete(m);
        
      return m
  end
  
  def nextCultist
    # Comprobamos si tenemos cartas en el mazo
    if (@unusedCultists.empty?)
            
      # Recorremos las cartas descartadas
      initCultistCardDeck
            
      # Las barajamos
      shuffleCultists
            
    end
        
    # Obtengo la primera carta del mazo
    m = @unusedCultists.at(0)
        
        
    # La eliminamos del mazo
    @unusedCultists.delete(m)
        
    # Devolvemos la carta
    return m
  end
  
  # Metodo giveTreasureBack
  def giveTreasureBack(t)
    @usedTreasures.push(t)
  end
  
  # Metodo giveMonsterBack
  def giveMonsterBack(m)
    @usedMonsters.push(m)
  end
  
  # Metodo 
  def initCards
    initTreasureCardDeck
    shuffleTreasures
        
    initMonsterCardDeck
    shuffleMonsters
  end

  # Metodo shuffleTreasures
  def shuffleTreasures()
    @unusedTreasures = @unusedTreasures.shuffle
  end
  
  # Metodo shuffleMonsters
  def shuffleMonsters()
    @unusedMonsters = @unusedMonsters.shuffle
  end
  
  def shuffleCultists
    @unusedCultists = @unusedCultists.shuffle
  end
end

end
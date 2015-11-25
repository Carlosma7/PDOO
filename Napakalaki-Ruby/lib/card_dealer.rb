# Autor Javier Aranda

require Singleton

class CardDealer
  def initialize (unusedMonsters, usedMonsters, unusedTreasures, usedTreasures)
    @intance=CardDealer.new
    @unusedMonsters=unusedMonsters
    @usedMonster=usedMonsters
    @unusedTreasures=unusedTreasures
    @usedTreasures=usedTreasures
    
  end
  
  # ----------------- Metodos Publicos --------------------
  
  # Metodo getInstance
  def getInstance
    
  end
  
  # Metodo nextTreasure
  def nextTreasure
    
  end
  
  # Metodo nextMonster
  def nextMonster
    
  end
  
  # Metodo giveTreasureBack
  def giveTreasureBack(t)
    usedTreasures.push(t)
  end
  
  # Metodo giveMonsterBack
  def giveMonsterBack(m)
    usedMonsters.push(m)
  end
  
  # Metodo 
  def initCards()
    
  end
  
  # ------------------ Metodos privados -----------------
  # Constructor
  private def CardDelaer()
    
  end
  
  # Metodo initTreasureCardDeck
  private def initTreasureCardDeck()
    #Creacion de Tesoro ¡Sí mi amo!
    unusedTreasures << Treasure.new("¡Si mi amo!", 0, 4,TreasureKind.HELMET)

    #Creacion de Tesoro Capucha de Cthulhu
    unusedTreasures << Treasure.new("Capucha de Cthulhu", 0, 3,TreasureKind.HELMET)

    #Creacion de Tesoro Botas de lluvia acida
    unusedTreasures << Treasure.new("Botas de lluvia acida", 0, 1,TreasureKind.BOTHHANDS)

    #Creacion de Tesoro Ametralladora Thompson
    unusedTreasures << Treasure.new("Ametralladora Thompson", 0, 4,TreasureKind.BOTHHANDS)

    #Creacion de Tesoro Clavo de rail ferroviario
    unusedTreasures << Treasure.new("Clavo de rail ferroviario", 0, 3,TreasureKind.ONEHAND)

    #Creacion de Tesoro Fez alopodo
    unusedTreasures << Treasure.new("Fez alopodo", 0, 3,TreasureKind.HELMET)    

    #Creacion de Tesoro El aparato del Pr. Tesla
    unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 0, 4,TreasureKind.ARMOR)

    #Creacion de Tesoro Insecticida
    unusedTreasures << Treasure.new("Insecticida", 0, 2,TreasureKind.ONEHAND)   

    #Creacion de Garabato mistico
    unusedTreasures << Treasure.new("Insecticida", 0, 2,TreasureKind.ONEHAND)

    #Creacion de Lanzallamas
    unusedTreasures << Treasure.new("Lanzallamas", 0, 4,TreasureKind.BOTHHANDS)

    #Creacion de Necronomicon
    unusedTreasures << Treasure.new("Necronomicon", 0, 5,TreasureKind.BOTHHANDS)

    #Creacion de Necro-gnomicon
    unusedTreasures << Treasure.new("Necro-gnomicon", 0, 2,TreasureKind.ONEHAND)

    #Creacion de Mazo de los antiguos
    unusedTreasures << Treasure.new("Mazo de los antiguos", 0, 3,TreasureKind.ONEHAND)

    #Creacion de Porra preternatural
    unusedTreasures << Treasure.new("Porra preternatural", 0, 2,TreasureKind.ONEHAND)

    #Creacion de Varita de atizamiento
    unusedTreasures << Treasure.new("Varita de atizamiento", 0, 3,TreasureKind.ONEHAND)

    #Creacion de Zapato deja-amigos
    unusedTreasures << Treasure.new("Zapato deja-amigos", 0, 1,TreasureKind.SHOES)

    #Creacion de Botas de investigacion
    unusedTreasures << Treasure.new("Botas de investigacion", 0, 3,TreasureKind.SHOES)

    #Creacion de A prueba de babas
    unusedTreasures << Treasure.new("A prueba de babas", 0, 2,TreasureKind.ARMOR)

    #Creacion de Casco minero
    unusedTreasures << Treasure.new("Casco minero", 0, 2,TreasureKind.HELMET)

    #Creacion de Camiseta de la UGR
    unusedTreasures << Treasure.new("Camiseta de la UGR", 0, 1,TreasureKind.ARMOR)

    #Creacion de Cuchillo de sushi arcano
    unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 0, 2,TreasureKind.ONEHAND)

    #Creacion de Hacha prehistorica
    unusedTreasures << Treasure.new("Hacha prehistorica", 0, 2,TreasureKind.ONEHAND)

    #Creacion de Gaita
    unusedTreasures << Treasure.new("Gaita", 0, 4,TreasureKind.BOTHHANDS)

    #Creacion de Escopeta de 3 caniones
    unusedTreasures << Treasure.new("Escopeta de 3 caniones", 0, 4,TreasureKind.BOTHHANDS)

    #Creacion de La rebeca metalica
    unusedTreasures << Treasure.new("La rebeca metalica", 0, 2,TreasureKind.ARMOR)

    #Creacion de Necro-comicon
    unusedTreasures << Treasure.new("Necro-comicon", 0, 1,TreasureKind.ONEHAND)

    #Creacion de Linterna a 2 manos
    unusedTreasures << Treasure.new("Linterna a 2 manos", 0, 3,TreasureKind.BOTHHANDS)

    #Creacion de Necrotelecom
    unusedTreasures << Treasure.new("Necrotelecom", 0, 2,TreasureKind.HELMET)

    #Creacion de Necro-playboycon
    unusedTreasures << Treasure.new("Necro-playboycon", 0, 3,TreasureKind.ONEHAND)

    #Creacion de Shogulador
    unusedTreasures << Treasure.new("Shogulador", 0, 1,TreasureKind.BOTHHANDS)

    #Creacion de Tentaculo de pega
    unusedTreasures << Treasure.new("Tentaculo de pega", 0, 2,TreasureKind.HELMET)
    
  end
  
  # Metodo initMonsterCardDeck
  private def initMonsterCardDeck()
    # El gorron en el umbral
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros
  visibles",BadConsequence.MAXTREASURES, 0, 0)
  unusedMonsters << Monster.new("El gorron en el umbral",10,badConsequence,prize)

  # 3 Byakhees de bonanza
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura
  visible y otra oculta",0 , [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  unusedMonsters << Monster.new("3 Byakhees de bonanza",8,badConsequence,prize)

  # El sopor de Dunwich
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo
  contagioso. Pierdes el calzado visible",0 , [TreasureKind::SHOES], 0)
  unusedMonsters << Monster.new("El sopor de Dunwich",2,badConsequence,prize)

  # H.P. Munchcraft
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura
  visible",0 , [TreasureKind::ARMOR], 0)
  unusedMonsters << Monster.new("H.P. Munchcraft",6,badConsequence,prize)

  # La que redacta en las tinieblas
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y
  pierdes 2 niveles.",2 , 0, 0)
  unusedMonsters << Monster.new("La que redacta en las tinieblas",2,badConsequence,prize)

  # Semillas Cthulhu
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2
  tesoros ocultos.",2 , 0, 2)
  unusedMonsters << Monster.new("Semillas Cthulhu",4,badConsequence,prize)

  # Semillas Cthulhu
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2
  tesoros ocultos.",2 , 0, 2)
  unusedMonsters << Monster.new("Semillas Cthulhu",4,badConsequence,prize)

  # Yskhtihyssg-Goth
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newDeath("No le hace gracia que
  pronuncien mal su nombre. Estas muerto")
  monsters << Monster.new("Yskhtihyssg-Goth",12,badConsequence,prize)

  # El espia
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche.
  Pierdes un casco visible.", 0, [TreasureKind::HELMET],0)
  unusedMonsters << Monster.new("El espia",5,badConsequence,prize)

  # El Lenguas
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas.
  Pierdes 2 niveles y 5 tesoros visibles.", 2, 5,0)
  unusedMonsters << Monster.new("El Lenguas",20,badConsequence,prize)

  # Dameargo
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear.
  Pierdes una mano visible.", 0, [TreasureKind::ONEHAND],0)
  unusedMonsters << Monster.new("Dameargo",20,badConsequence,prize)

  # El rey de rosa
  prize= Prize.new(4,2)
  badConsequence= BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3
   tesoros visibles ", 5, 3, 0)
  unusedMonsters << Monster.new("El rey de Rosa", 13, badConsequence, prize)

  # Chibithulhu
  prize= Prize.new(1,1)
  badConsequence= BadConsequence.newLevelSpecificTreasures("Embobados con el lindo
   primigenio te descartas de tu casco visible", 0, [TreasureKind::HELMET],0)
  unusedMonsters << Monster.new("Chibithulhu", 2, badConsequence, prize)

  # Pollipolipo volante
  prize= Prize.new(1,1)
  badConsequence= BadConsequence.newLevelNumberOfTreasures("Da mucho asquito.
    Pierde 3 niveles", 3, 0, 0)
  unusedMonsters << Monster.new("Pillipolipo volante", 3, badConsequence, prize)

  # Bichgooth
  prize= Prize.new(1,1)
  badConsequence= BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la
   ropa. Descarta la armadura visible", 0, [TreasureKind::ARMOR],0)
  unusedMonsters << Monster.new("Bichgooth", 2, badConsequence, prize)

  # Angeles de la noche ibicenca
  prize= Prize.new(4,1)
  badConsequence= BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte
   de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano
   oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  unusedMonsters << Monster.new("Angeles de la noche ibicenca",14, badConsequence, prize)

  # Familia Feliz
  prize= Prize.new(4, 1)
  badConsequence= BadConsequence.newDeath("La familia te atrapa. Estas muerto")
  unusedMonsters << Monster.new("Familia Feliz", 1, badConsequence, prize)

  # Los Hondos
  prize= Prize.new(2,1)
  badConsequence= BadConsequence.newDeath("Estos monstruos resultan bastante
   superficiales y te aburren mortalmente. Estas muerto")
  unusedMonsters << Monster.new("Los hondos", 8, badConsequence, prize)

  # Roboggoth
  prize= Prize.new(2,1)
  badConsequence= BadConsequence.newLevelSpecificTreasures("La quinta directiva 
  primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
    2, [TreasureKind::BOTHHANDS], 0)
  unusedMonsters << Monster.new("Roboggoth", 8, badConsequence, prize)

  # Bicefalo
  prize= Prize.new(1,1)
  badConsequence= BadConsequence.newLevelSpecificTreasures("Te faltan manos para 
  tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
    3, handTreasures, 0)
  unusedMonsters << Monster.new("Bicefalo", 20 , badConsequence, prize)
  end
  
  # Metodo shuffleTreasures
  private def shuffleTreasures()
    @unusedTreasures = @unusedTreasures.shuffle
  end
  
  # Metodo shuffleMonsters
  def shuffleMonsters()
    @unusedMonsters = @unusedMonster.shuffle
  end
end

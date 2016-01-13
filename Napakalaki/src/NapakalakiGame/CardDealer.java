package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author JaviAir
 */
public class CardDealer {
    private static final CardDealer instance= new CardDealer();
    
    // Atributos de otras clases
    private ArrayList <Monster> usedMonster;
    private ArrayList <Monster> unusedMonster;
    private ArrayList <Treasure> usedTreasures;
    private ArrayList <Treasure> unusedTreasures;
    
    private ArrayList <Cultist> unusedCultists;
    
    // Constructor de la clase
    private CardDealer(){
    
    }
    /*
    Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las 
    cartas de tesoros proporcionadas en el documento de cartas de tesoros.
    */
    private void initTreasureCardDeck(){
        unusedTreasures = new ArrayList();// Inicializamos el array
        usedTreasures = new ArrayList();
        
        //Creamos los tesoros
        //Creacion de Tesoro ¡Sí mi amo!
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4,TreasureKind.HELMET));
        
        //Creacion de Tesoro Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3,TreasureKind.HELMET));
        
        //Creacion de Tesoro Botas de lluvia acida
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1,TreasureKind.BOTHHANDS));
        
        //Creacion de Tesoro Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4,TreasureKind.BOTHHANDS));
        
        //Creacion de Tesoro Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3,TreasureKind.ONEHAND));
        
        //Creacion de Tesoro Fez alopodo
        unusedTreasures.add(new Treasure("Fez alopodo", 3,TreasureKind.HELMET));        
        
        //Creacion de Tesoro El aparato del Pr. Tesla
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4,TreasureKind.ARMOR));
        
        //Creacion de Tesoro Insecticida
        unusedTreasures.add(new Treasure("Insecticida", 2,TreasureKind.ONEHAND));        
        
        //Creacion de Garabato mistico
        unusedTreasures.add(new Treasure("Insecticida", 2,TreasureKind.ONEHAND));
        
        //Creacion de Lanzallamas
        unusedTreasures.add(new Treasure("Lanzallamas", 4,TreasureKind.BOTHHANDS));
        
        //Creacion de Necronomicon
        unusedTreasures.add(new Treasure("Necronomicon", 5,TreasureKind.BOTHHANDS));
        
        //Creacion de Necro-gnomicon
        unusedTreasures.add(new Treasure("Necro-gnomicon", 2,TreasureKind.ONEHAND));
        
        //Creacion de Mazo de los antiguos
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3,TreasureKind.ONEHAND));
        
        //Creacion de Porra preternatural
        unusedTreasures.add(new Treasure("Porra preternatural", 2,TreasureKind.ONEHAND));
        
        //Creacion de Varita de atizamiento
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3,TreasureKind.ONEHAND));
        
        //Creacion de Zapato deja-amigos
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1,TreasureKind.SHOES));
        
        //Creacion de Botas de investigacion
        unusedTreasures.add(new Treasure("Botas de investigacion", 3,TreasureKind.HELMET));
        
        //Creacion de A prueba de babas
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        
        //Creacion de Casco minero
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        
        //Creacion de Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        
        //Creacion de Cuchillo de sushi arcano
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        
        //Creacion de Hacha prehistorica
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        
        //Creacion de Gaita
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        
        //Creacion de Escopeta de 3 caniones
        unusedTreasures.add(new Treasure("Escopeta de 3 caniones", 4, TreasureKind.BOTHHANDS));
        
        //Creacion de La rebeca metalica
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        
        //Creacion de Necro-comicon
        unusedTreasures.add(new Treasure("Necro-comicon", 1, TreasureKind.ONEHAND));
        
        //Creacion de Linterna a 2 manos
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        
        //Creacion de Necrotelecom
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        
        //Creacion de Necro-playboycon
        unusedTreasures.add(new Treasure("Necro-playboycon", 2, TreasureKind.ONEHAND));
        
        //Creacion de Shogulador
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        
        //Creacion de Tentaculo de pega
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
    }
    
    private void initMonsterCardDeck(){
        unusedMonster = new ArrayList();// Inicializamos el array de monstruos
        usedMonster = new ArrayList();
        
        // Inicializamos las variables
        BadConsequence badConsequence;
        Prize prize;
        
        // Insercion de los monstruos
        // Creación Monstruo "La que redacta en las tinieblas"
        badConsequence= new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles.",
        2, 0, 0);
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        // Creación Monstruo "El gorrón en el umbral"
        badConsequence= new NumericBadConsequence("Pierdes todos tus tesoros visibles",
        0, BadConsequence.MAXTREASURES, 0);
        prize= new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        // Creación Monstruo "3 Byakhees de bonanza"
        badConsequence= new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("3 Byakhees de bonanza", 10, badConsequence, prize));
        
        // Creación Monstruo "Semillas Cthulhu"
        badConsequence= new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        // Creación Monstruo "Yskhtihyssg-Goth"
        badConsequence= new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.");
        prize= new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        // Creación Monstruo "El Lenguas"
        badConsequence= new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        // Creación Monstruo "El sopor de Dunwich"
        badConsequence= new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Creación Monstruo "H.P. Munchcraft"
        badConsequence= new SpecificBadConsequence("Pierdes la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Creación Monstruo "Dameargo"
        badConsequence= new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        // Creación Monstruo "El espia"
        badConsequence= new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El espia", 5, badConsequence, prize));
        
        // Creacion Monstruo "El rey de rosa"         
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y tres tesoros visibles",5,3,0);
        prize= new Prize (4,2);
        unusedMonster.add(new Monster("El rey de rosa",13,badConsequence,prize));
        
        //Creacion Monstruo "Angeles de la noche ibicenca"
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta una "
                + "mano visible y una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonster.add(new Monster("Angel de la noche ibicenca",14,badConsequence,prize));
        
        //Creacion Monstruo "Los hondos"
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Creacion Monstruo "Pollipolipo volante"
        badConsequence = new NumericBadConsequence("Da mucho asquito", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
        
        //Creacion Monstruo "Familia Feliz"
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto");
        prize = new Prize(4, 1);
        unusedMonster. add(new Monster("Familia Feliz", 1, badConsequence, prize));
        
        // Creacion Monstruo "Chibithulhu"
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        // Creacion Monstruo "Bicigooth"
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicigooth", 2, badConsequence, prize));
        
        //Creacion Monstruo "Roboggoth"
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //Creacion Monstruo "Bicefalo"
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierde 3 niveles y tus tesoros visibles de las manos",
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND,TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicefalo", 20, badConsequence, prize));
        
        //Creacion Monstruo "El mal indecible impronunciable"
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible",
                0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
        prize = new Prize(3,1);
        unusedMonster.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        //Creacion Monstruo "Testigos oculares"
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",
                0, BadConsequence.MAXTREASURES,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Testigos oculares", 6, badConsequence, prize, 2));
        
        //Creacion Monstruo "El gran cthulhu"
        badConsequence = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres");
        prize = new Prize(2,5);
        unusedMonster.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        //Creacion Monstruo "Serpiente Politico"
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",
                2, 0,0);
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Serpiente Politico", 8, badConsequence, prize, -2));
        
        //Creacion Monstruo "Felpuggoth"
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
        
        //Creacion Monstruo "Shoggoth"
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles",
                2, 0,0);
        prize = new Prize(4,2);
        unusedMonster.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        //Creacion Monstruo "Lolitagooth"
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles",
                2, 0,0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
    }
    
    private void initCultistCardDeck(){
        unusedCultists=new ArrayList();
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 1));
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 2));
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 1));
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 2));
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 1));
        
        // Creacion de Sectario
        unusedCultists.add(new Cultist("Sectario", 1));
    }
    /*
    Baraja el mazo de cartas de teseros unusedTreasures
    */
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
        
    }
    
    /*
    Baraja el mazo de cartas de monstruos unusedMonster
    */
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonster);
    }
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    public static CardDealer getInstance(){
    
        return instance;
    }
    
    public Treasure nextTreasure(){
        Treasure treasure_get;
        if(!unusedTreasures.isEmpty()){
            treasure_get=unusedTreasures.get(0);
            usedTreasures.add(treasure_get);
            unusedTreasures.remove(treasure_get);
        }else{
            for(Treasure t:usedTreasures){
                unusedTreasures.add(t);
                usedTreasures.remove(t);
            }
            
            shuffleMonsters();
            
            //Cogemos el monstruo del nuevo mazo
            treasure_get=unusedTreasures.get(0);
            usedTreasures.add(treasure_get);
            unusedTreasures.remove(treasure_get);
        }
            
        return treasure_get;
    }
    
    public Monster nextMonster(){
        Monster monster_get;
        if(!unusedMonster.isEmpty()){
            monster_get=unusedMonster.get(0);
            usedMonster.add(monster_get);
            unusedMonster.remove(monster_get);
        }else{
            for(Monster m:usedMonster){
                unusedMonster.add(m);
            }
            
            usedMonster.clear();
            
            shuffleMonsters();
            
            //Cogemos el monstruo del nuevo mazo
            monster_get=unusedMonster.get(0);
            usedMonster.add(monster_get);
            unusedMonster.remove(monster_get);
        }
            
        return monster_get;
    }
    
    public Cultist nextCultist(){
        //Comprobamos si tenemos cartas en el mazo
        if (this.unusedCultists.isEmpty()) {
            
            //Recorremos las cartas descartadas
            this.initCultistCardDeck();
            
            //Las barajamos
            this.shuffleCultists();
            
        }
        
        //Obtengo la primera carta del mazo
        Cultist m = this.unusedCultists.get(0);
        
        
        //La eliminamos del mazo
        this.unusedCultists.remove(m);
        
        //Devolvemos la carta
        return m;
    }
    
    /*
    Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    */
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    /*
    Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    */
    public void giveMonsterBack(Monster m){
        usedMonster.add(m);
    }
    
    public void initCards(){
        this.initTreasureCardDeck();
        this.shuffleTreasures();
        
        this.initMonsterCardDeck();
        this.shuffleMonsters();
        
        this.initCultistCardDeck();
        this.shuffleCultists();
    }
    
}

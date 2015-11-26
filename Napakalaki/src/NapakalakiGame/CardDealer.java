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
    
    // Constructor de la clase
    private CardDealer(){
    
    }
    /*
    Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las 
    cartas de tesoros proporcionadas en el documento de cartas de tesoros.
    */
    private void initTreasureCardDeck(){
        unusedTreasures = new ArrayList();// Inicializamos el array
        
        //Creamos los tesoros
        //Creacion de Tesoro ¡Sí mi amo!
        unusedTreasures.add(new Treasure("¡Si mi amo!", 0, 4,TreasureKind.HELMET));
        
        //Creacion de Tesoro Capucha de Cthulhu
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 0, 3,TreasureKind.HELMET));
        
        //Creacion de Tesoro Botas de lluvia acida
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 0, 1,TreasureKind.BOTHHANDS));
        
        //Creacion de Tesoro Ametralladora Thompson
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 0, 4,TreasureKind.BOTHHANDS));
        
        //Creacion de Tesoro Clavo de rail ferroviario
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 0, 3,TreasureKind.ONEHAND));
        
        //Creacion de Tesoro Fez alopodo
        unusedTreasures.add(new Treasure("Fez alopodo", 0, 3,TreasureKind.HELMET));        
        
        //Creacion de Tesoro El aparato del Pr. Tesla
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 0, 4,TreasureKind.ARMOR));
        
        //Creacion de Tesoro Insecticida
        unusedTreasures.add(new Treasure("Insecticida", 0, 2,TreasureKind.ONEHAND));        
        
        //Creacion de Garabato mistico
        unusedTreasures.add(new Treasure("Insecticida", 0, 2,TreasureKind.ONEHAND));
        
        //Creacion de Lanzallamas
        unusedTreasures.add(new Treasure("Lanzallamas", 0, 4,TreasureKind.BOTHHANDS));
        
        //Creacion de Necronomicon
        unusedTreasures.add(new Treasure("Necronomicon", 0, 5,TreasureKind.BOTHHANDS));
        
        //Creacion de Necro-gnomicon
        unusedTreasures.add(new Treasure("Necro-gnomicon", 0, 2,TreasureKind.ONEHAND));
        
        //Creacion de Mazo de los antiguos
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 0, 3,TreasureKind.ONEHAND));
        
        //Creacion de Porra preternatural
        unusedTreasures.add(new Treasure("Porra preternatural", 0, 2,TreasureKind.ONEHAND));
        
        //Creacion de Varita de atizamiento
        unusedTreasures.add(new Treasure("Varita de atizamiento", 0, 3,TreasureKind.ONEHAND));
        
        //Creacion de Zapato deja-amigos
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 0, 1,TreasureKind.SHOES));
        
        //Creacion de Botas de investigacion
        unusedTreasures.add(new Treasure("Botas de investigacion", 0, 3,TreasureKind.HELMET));
        
        //Creacion de A prueba de babas
        unusedTreasures.add(new Treasure("A prueba de babas", 0, 2, TreasureKind.ARMOR));
        
        //Creacion de Casco minero
        unusedTreasures.add(new Treasure("Casco minero", 0, 2, TreasureKind.HELMET));
        
        //Creacion de Camiseta de la UGR
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 0, 1, TreasureKind.ARMOR));
        
        //Creacion de Cuchillo de sushi arcano
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 0, 2, TreasureKind.ONEHAND));
        
        //Creacion de Hacha prehistorica
        unusedTreasures.add(new Treasure("Hacha prehistorica", 0, 2, TreasureKind.ONEHAND));
        
        //Creacion de Gaita
        unusedTreasures.add(new Treasure("Gaita", 0, 4, TreasureKind.BOTHHANDS));
        
        //Creacion de Escopeta de 3 caniones
        unusedTreasures.add(new Treasure("Escopeta de 3 caniones", 0, 4, TreasureKind.BOTHHANDS));
        
        //Creacion de La rebeca metalica
        unusedTreasures.add(new Treasure("La rebeca metalica", 0, 2, TreasureKind.ARMOR));
        
        //Creacion de Necro-comicon
        unusedTreasures.add(new Treasure("Necro-comicon", 0, 1, TreasureKind.ONEHAND));
        
        //Creacion de Linterna a 2 manos
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 0, 3, TreasureKind.BOTHHANDS));
        
        //Creacion de Necrotelecom
        unusedTreasures.add(new Treasure("Necrotelecom", 0, 2, TreasureKind.HELMET));
        
        //Creacion de Necro-playboycon
        unusedTreasures.add(new Treasure("Necro-playboycon", 0, 2, TreasureKind.ONEHAND));
        
        //Creacion de Shogulador
        unusedTreasures.add(new Treasure("Shogulador", 0, 1, TreasureKind.BOTHHANDS));
        
        //Creacion de Tentaculo de pega
        unusedTreasures.add(new Treasure("Tentaculo de pega", 0, 2, TreasureKind.HELMET));
    }
    
    private void initMonsterCardDeck(){
        unusedMonster = new ArrayList();// Inicializamos el array de monstruos
        
        // Inicializamos las variables
        BadConsequence badConsequence;
        Prize prize;
        
        // Inseccion de los monstruos
        // Creación Monstruo "La que redacta en las tinieblas"
        badConsequence= new BadConsequence("Toses los pulmones y pierdes 2 niveles.",
        2, 0, 0);
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("La que redacta en las tinieblas", 2, badConsequence, prize));
        
        // Creación Monstruo "El gorrón en el umbral"
        badConsequence= new BadConsequence("Pierdes todos tus tesoros visibles",
        0, BadConsequence.MAXTREASURES, 0);
        prize= new Prize(3,1);
        unusedMonster.add(new Monster("El gorrón en el umbral", 10, badConsequence, prize));
        
        // Creación Monstruo "3 Byakhees de bonanza"
        badConsequence= new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("3 Byakhees de bonanza", 10, badConsequence, prize));
        
        // Creación Monstruo "Semillas Cthulhu"
        badConsequence= new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        // Creación Monstruo "Yskhtihyssg-Goth"
        badConsequence= new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize= new Prize(3,1);
        unusedMonster.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        // Creación Monstruo "El Lenguas"
        badConsequence= new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        // Creación Monstruo "El sopor de Dunwich"
        badConsequence= new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList(Arrays.asList()));
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Creación Monstruo "H.P. Munchcraft"
        badConsequence= new BadConsequence("Pierdes la armadura visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Creación Monstruo "Dameargo"
        badConsequence= new BadConsequence("Te intentas escaquear. Pierdes una mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize= new Prize(2,1);
        unusedMonster.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        // Creación Monstruo "El espia"
        badConsequence= new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize= new Prize(1,1);
        unusedMonster.add(new Monster("El espia", 5, badConsequence, prize));
        
        // Creacion Monstruo "El rey de rosa"         
        badConsequence = new BadConsequence ("Pierder 5 niveles y tres tesoros visibles",5,3,0);
        prize= new Prize (4,2);
        unusedMonster.add(new Monster("El rey de rosa",13,badConsequence,prize));
        
        //Creacion Monstruo "Angeles de la noche ibicenca"
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta una "
                + "mano visible y una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonster.add(new Monster("Angel de la noche ibicenca",14,badConsequence,prize));
        
        //Creacion Monstruo "Los hondos"
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2, 1);
        unusedMonster.add(new Monster("Los hondos", 8, badConsequence, prize));
        
        //Creacion Monstruo "Pollipolipo volante"
        badConsequence = new BadConsequence("Da mucho asquito", 3, 0, 0);
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
        
        //Creacion Monstruo "Familia Feliz"
        badConsequence = new BadConsequence("La familia te atrapa. Estas muerto", true);
        prize = new Prize(4, 1);
        unusedMonster. add(new Monster("Familia Feliz", 1, badConsequence, prize));
        
        // Creacion Monstruo "Chibithulhu"
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        // Creacion Monstruo "Bicigooth"
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicigooth", 2, badConsequence, prize));
        
        //Creacion Monstruo "Roboggoth"
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
                2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        unusedMonster.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        //Creacion Monstruo "Bicefalo"
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierde 3 niveles y tus tesoros visibles de las manos",
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.ONEHAND,TreasureKind.ONEHAND)),new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonster.add(new Monster("Bicefalo", 20, badConsequence, prize));
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
                usedMonster.remove(m);
            }
            
            shuffleMonsters();
            
            //Cogemos el monstruo del nuevo mazo
            monster_get=unusedMonster.get(0);
            usedMonster.add(monster_get);
            unusedMonster.remove(monster_get);
        }
            
        return monster_get;
    }
    
    /*
    Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    */
    public void giveTreasureBack(Treasure t){
        usedTreasures = new ArrayList();
        usedTreasures.add(t);
    }
    
    /*
    Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    */
    public void giveMonsterBack(Monster m){
        usedMonster = new ArrayList();
        usedMonster.add(m);
    }
    
    public void initCards(){
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
    }
    
    
    
}

package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Javier
 */
public class Player {
    static final int MAXLEVEL=10;
    private String name;
    private int level;
    private boolean dead=true;
    private boolean canISteal=true;
    
    // Atributos obtenidos de otras clases
    private BadConsequence pendingBadConsequence;
    private ArrayList <Treasure> hiddenTreasures = new ArrayList();
    private ArrayList <Treasure> visibleTreasures = new ArrayList();
    public Player enemy;
    


    public Player (String name){
    
        this.name= name;
    }
    
    /*
    Devuelve el nombre del jugador.
    */
    public String getName(){
        return this.name;
    }
    
    /*
    Devuelve la vida al jugador, modificando el atributo correspondiente.
    */
    private void bringToLife(){
        this.dead=false;
    }
    
    /*
    Devuelve el nivel de combate del jugador, que viene dado por su nivel más
    los bonus que le proporcionan los tesoros que tenga equipados, según las 
    reglas del juego.
    */
    private int getCombatLevel(){
        int nivel = level;
        for (Treasure t: visibleTreasures)
            nivel = nivel + t.getBonus();
        
        return nivel;
    }
    
    /*
    Incrementa el nivel del jugador en i niveles, teniendo en cuenta 
    las reglas del juego.
    */
    private void incrementLevels(int l){
        level = level + l;
    }
    
    /*
    Decrementa el nivel del jugador en i niveles, teniendo en cuenta
    las reglas del juego.
    */
    private void decrementLevels(int l){
        level = level - l;
    }
    
    /*
    Asigna el mal rollo al jugador, dándole valor a 
    su atributo pendingBadConsequence.
    */
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence=b;
    }
    
    private void applyPrize(Monster m){
        int nLevels=m.getLevelsGained();
        
        this.incrementLevels(nLevels);
        
        int nTreasures=m.getTreasuresGained();
        
        if(nTreasures>0){
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i=1;i<=nTreasures;i++){
                Treasure t = dealer.nextTreasure();
                this.hiddenTreasures.add(t);
            }   
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        
        int nLevels=badConsequence.getLevels();
        
        this.decrementLevels(nLevels);
        
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(this.visibleTreasures, this.hiddenTreasures);

        this.setPendingBadConsequence(pendingBad);
    }
    
    //Comprueba si el tesoro (t) se puede pasar de oculto a visible, 
    //según las reglas del juego
    public boolean canMakeTreasureVisible(Treasure t) {

        boolean result = false;

        //Comprobamos que no tenga ya 4 tesoros visibles
        if (this.visibleTreasures.size() < 4) {
            TreasureKind type = t.getType();
            
            if(type==TreasureKind.ONEHAND){
                
                    //Si está equipado con dos manos no puede agregar un tesoro de una mano
                    if (UsingTreasureKind(TreasureKind.BOTHHANDS)) {
                        result = false;
                    } else {

                        //Recorremos los tesoros visibles para ver si ya tiene alguno de una mano (0, 1 o 2)
                        int i = 0;
                        for (Treasure tv : this.visibleTreasures) {
                            if (tv.getType().equals(TreasureKind.ONEHAND)) {
                                i++;
                            }
                        }

                        if (i == 2) {
                            //Si están las dos manos ocupadas no puede
                            result = false;
                        } else {
                            //En caso contrario si que puede
                            result = true;
                        }
                    }
            }else{
                    result = !UsingTreasureKind(type);
                }
        }

        return result;
    }
    
    
    //Metodo que comprueba si un Tipo de Tesoro está en uso
    private boolean UsingTreasureKind(TreasureKind type) {
        boolean result = false;
        for (Treasure tv : this.visibleTreasures) {

            if (type.equals(tv.getType())) {

                result = true;
                break;

            }

        }
        return result;
    }
    /*
    
    Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.
    */
    private int howManyVisibleTreasures(TreasureKind tKind){
        int numeroDeTesoros=0;// Variable para guardar el numero de tesoros 
        
        // Recorremos los tesoros visibles con un for
        for(Treasure t: visibleTreasures){
            if(t.getType() == tKind)// Si los tesoros son del tipo tKind
                numeroDeTesoros++;// Añadimos un tesoro
        }
            
        return numeroDeTesoros;
    }
    
    /*
    Cambia el estado de jugador a muerto,modificando el correspondiente atributo.
    Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.
    */
    private void dieIfNoTreasures(){
    
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    /*
    Devuelve true si el jugador está muerto, false en caso contrario.
    */
    public boolean isDead(){
    
        return this.dead;
    }
    
    public Treasure getHiddenTreasures(){
        return null;
    
    }
    
    public Treasure getVisibleTreasure(){
    
        return null;
    }
    
    public CombatResult combat(Monster m){
        CombatResult result;
        
        int myLevel= this.getCombatLevel();
        int monsterLevel=m.getCombatLevel();
        
        if(myLevel>monsterLevel){
            this.applyPrize(m);
            
            if(this.level >MAXLEVEL)
                result=CombatResult.WINGAME;
            else
                result=CombatResult.WIN;
            
        }else{
            this.applyBadConsequence(m);
            result=CombatResult.LOSE;
        }
        
        return result;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI=this.canMakeTreasureVisible(t);
        
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        this.visibleTreasures.remove(t);
        
        if(pendingBadConsequence!=null && pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        this.dieIfNoTreasures();
    }
    
    public void discarHiddenTreasure(Treasure t){
        this.hiddenTreasures.remove(t);
        
        if(pendingBadConsequence!=null && pendingBadConsequence.isEmpty()){
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        this.dieIfNoTreasures();
    }
    /*
    Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y 
    no tiene más de 4 tesoros ocultos, y false en caso contrario. 
    Para comprobar que el jugador no tenga mal rollo que cumplir,
    utiliza el método isEmpty de la clase BadConsequence.
    */
    public boolean validState(){
        if (pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 4)
            return true;
        else
            return false;
    }
    
    public void initTreasures(){
        CardDealer dealer= CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        this.bringToLife();
        
        Treasure treasure = dealer.nextTreasure();
        
        hiddenTreasures.add(treasure);
        
        int number=dice.nextNumber();
        
        if(number>1){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number==6){
            treasure=dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
            
    }
    
    public int getLevels(){
    
        return level;
    }
    
    public Treasure stealTreasure(){
        
        Treasure treasure =null;
        
        if(this.canISteal){
            if(enemy.canYouGiveMeATreasure()){
                treasure= enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
        return treasure;
    
    }
    /*
    Asigna valor al atributo que referencia al enemigo del jugador.
    */
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    
    }
    
    private Treasure giveMeATreasure(){
        Random r = new Random();
        return hiddenTreasures.get(r.nextInt(hiddenTreasures.size()));
    }
    /*
    Devuelve true si el jugador no ha robado ningún tesoro a su enemigo y false en
    caso contrario.
    */
    public boolean canISteal(){
    
        if(canISteal==true)
            return true;
        else
            return false;
    }
    /*
    Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
    en caso contrario.
    */
    private boolean canYouGiveMeATreasure(){
        if(!hiddenTreasures.isEmpty())
            return true;
        else
            return false;
    }
    /*
    Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    */
    private void haveStolen(){
        
        this.canISteal=false;   
    }
    
    public void discardAllTreasures(){
        for(Treasure t:visibleTreasures)
            this.discardVisibleTreasure(t);
        
        for(Treasure t:hiddenTreasures)
            this.discarHiddenTreasure(t);
    }
        
    
}

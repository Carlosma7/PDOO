package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public abstract class BadConsequence {
    static final int MAXTREASURES=10;
    
    // Atributos privados
    protected String text;    // Mensaje de mal rollo
    protected int levels;     // Level que se pierden
    private boolean death;     // Indica si muere el jugador o no
    private Player player;  //Jugador
    
    
    //Constructor para mal rollo que especifica cuantos tesoros visibles y ocultos pierdes
    public BadConsequence(String text, int levels){
        this.text=text;
        this.levels=levels;
    }
    
    // Constructor del mal rollo si mueres
    public BadConsequence(String text, boolean death){
        
    }
    
    //Constructor para mal rollo que te quita los tipos de tesoros
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        
        
    }
   
    
    // Consultores
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    // Metodo que comprueba si una BadConsequence esta vacia
    public abstract boolean isEmpty();
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    public abstract void substractVisibleTreasure(Treasure t);
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    public abstract void substractHiddenTreasure(Treasure t);
    
    // Metodo que ajusta
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);
    
    // Método toString
    @Override   //Estamos sobreescibribiendo un método padre de Java
    public String toString(){
        return " Text = " + text + ". Levels = " + Integer.toString(levels);
    }
}

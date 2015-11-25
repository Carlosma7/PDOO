package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class BadConsequence {
    static final int MAXTREASURES=10;
    
    // Atributos privados
    private String text;    // Mensaje de mal rollo
    private int levels;     // Level que se pierden
    private int nVisibleTreasures;  // Nº tesoros visibles que se pierden
    private int nHiddenTreasures;   // Nº tesoros ocultos que se pierden
    private boolean death;     // Indica si muere el jugador o no
    private Player player;  //Jugador
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    
    //Constructores de mal rollo
    
    //Constructor para mal rollo que especifica cuantos tesoros visibles y ocultos pierdes
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        setText(text);
        setLevels(levels);
        setNVisibleTreasures(nVisible);
        setNHiddenTreasures(nHidden);
    }
    
    // Constructor del mal rollo si mueres
    public BadConsequence(String text, boolean death){
        setText(text);
        setDeath(death);
    }
    
    //Constructor para mal rollo que te quita los tipos de tesoros
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        setText(text);
        setLevels(levels);
        setSpecificVisibleTreasures(tVisible);
        setSpecificHiddenTreasures(tHidden);
        
    }
    
    // Modificadores
    private void setText(String txt){
        text = txt;
    }
    
    private void setLevels(int lv){
        levels = lv;
    }
    
    private void setNVisibleTreasures(int nvt){
        nVisibleTreasures = nvt;
    }
    
    private void setNHiddenTreasures(int nht){
        nHiddenTreasures = nht;
    }
    
    private void setDeath(boolean dth){
        death = dth;
    }
    
    private void setSpecificHiddenTreasures(ArrayList<TreasureKind> tHidden){
        specificHiddenTreasures = tHidden;
    }
    
    private void setSpecificVisibleTreasures(ArrayList<TreasureKind> tVisible){
        specificVisibleTreasures = tVisible;
    }
    
    // Consultores
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    // Metodo que comprueba si un monstruo tiene tesoros
    public boolean TieneTesoros(){        
        if((!specificVisibleTreasures.isEmpty()) || (!specificVisibleTreasures.isEmpty()))
            return true;
        else
            return false;
    }
    
    // Metodo que comprueba si una BadConsequence esta vacia
    public boolean isEmpty(){
        boolean vacio=false;
        if((nHiddenTreasures==0) && (nVisibleTreasures==0)&& (death==false)
                && (specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
            vacio=true;
        
        return vacio;
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures!=0)
            nVisibleTreasures=nVisibleTreasures+1;
        else
            specificVisibleTreasures.remove(t);
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures!=0)
            nHiddenTreasures=nHiddenTreasures+1;
        else
            if(!specificHiddenTreasures.isEmpty())
                specificHiddenTreasures.remove(t);
    }
    
    // Metodo que ajusta
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        BadConsequence pendingBad;
                
        if(nVisibleTreasures!=0 || nHiddenTreasures!=0){    // Caso de que quiten nº de tesoros
            int nV;
            int nH;
            
            
            //Ajustamos segun el tamaño de los visibles
            if(nVisibleTreasures>v.size())
                nV=v.size();
            else
                nV=nVisibleTreasures;
            
            //Ajustamos segun el tamaño de los no visibles
            if(nHiddenTreasures>h.size())
                nH=h.size();
            else
                nH=nHiddenTreasures;
            
            
            pendingBad=new BadConsequence(this.text, 0, nV, nH);
            
        }else{  //Caso de que quiten tesoros especificos
                ArrayList<TreasureKind> arr_nV= new ArrayList();
                ArrayList<TreasureKind> arr_nH= new ArrayList();
                
                for(Treasure t: v){
                    arr_nV.add(t.getType());   
                }
                
                for(Treasure t: h){
                    arr_nH.add(t.getType());
                }
                
                arr_nV.retainAll(specificVisibleTreasures);
                    
                arr_nH.retainAll(specificHiddenTreasures);
                
                
                pendingBad=new BadConsequence(this.text, 0, arr_nV, arr_nH);
            }
    
        return pendingBad;
    }
    
    // Método toString
    @Override   //Estamos sobreescibribiendo un método padre de Java
    public String toString(){
        return " Text = " + text + ". Levels = " + Integer.toString(levels)
                + ". NVisibleTreasures = " + Integer.toString(nVisibleTreasures)
                + ". NHiddenTreasures = " + Integer.toString(nHiddenTreasures)
                + ". Death = " + death;
    }
}

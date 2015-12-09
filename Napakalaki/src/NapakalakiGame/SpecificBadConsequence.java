/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class SpecificBadConsequence extends BadConsequence{
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden){
        super(text,levels);
        this.specificVisibleTreasures=tVisible;
        this.specificHiddenTreasures=tHidden;
        
    }
    
    // Metodo que comprueba si una BadConsequence esta vacia
    @Override
    public boolean isEmpty(){
        boolean vacio=false;
        if((specificHiddenTreasures.isEmpty()) && (specificVisibleTreasures.isEmpty()))
            vacio=true;
        
        return vacio;
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    @Override
    public void substractVisibleTreasure(Treasure t){
        specificVisibleTreasures.remove(t);
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    @Override
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t);
    }
    
    // Metodo que ajusta
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        BadConsequence pendingBad;
                
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
                
                
                pendingBad=new SpecificBadConsequence(this.text, 0, arr_nV, arr_nH);
    
        return pendingBad;
    }
}

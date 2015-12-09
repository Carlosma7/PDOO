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
public class NumericBadConsequence extends BadConsequence{
    
    private int nVisibleTreasures;  // Nº tesoros visibles que se pierden
    private int nHiddenTreasures;   // Nº tesoros ocultos que se pierden
    
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text,levels);
        this.nVisibleTreasures=nVisible;
        this.nHiddenTreasures=nHidden;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    // Metodo que comprueba si una BadConsequence esta vacia
    @Override
    public boolean isEmpty(){
        boolean vacio=false;
        if((nHiddenTreasures==0) && (nVisibleTreasures==0))
            vacio=true;
        
        return vacio;
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures>0)
            nVisibleTreasures=nVisibleTreasures-1;
    }
    
    // Metodo que substrae un tesoro de los tesoros visibles de BadConsequence
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures>0)
            nHiddenTreasures=nHiddenTreasures-1;
    }
    
    // Metodo que ajusta
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        BadConsequence pendingBad;
                
        int nV;
        int nH;
            
        //Ajustamos segun el tamaño de los visibles
        if(nVisibleTreasures>v.size())
            nV=v.size();
        else
            nV=nVisibleTreasures;
            
        //Ajustamos segun el tamaño de los ocultos
        if(nHiddenTreasures>h.size())
            nH=h.size();
        else
            nH=nHiddenTreasures;
            
            
        pendingBad=new NumericBadConsequence(this.text, 0, nV, nH);
    
        return pendingBad;
    }
}

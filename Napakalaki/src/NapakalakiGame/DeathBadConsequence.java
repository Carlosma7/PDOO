/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author carlos
 */
public class DeathBadConsequence extends NumericBadConsequence{
    // Constructor del mal rollo si mueres
    public DeathBadConsequence(String text){
        super(text,0, MAXTREASURES, MAXTREASURES);
    }
}

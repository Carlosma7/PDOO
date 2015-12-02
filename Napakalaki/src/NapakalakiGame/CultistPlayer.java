/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.Random;

/**
 *
 * @author carlos
 */
public class CultistPlayer extends Player{
    private static int totalCultistPlayers=0;
    
    Cultist myCultistCard;
    
    CultistPlayer(Player p, Cultist c){
        super(p);
        
        totalCultistPlayers++;
        this.myCultistCard=c;
    }
    
    @Override
    protected int getCombatLevel(){
        int final_level=super.getCombatLevel()+ ((super.getCombatLevel())*20/100);
        final_level= final_level + (this.myCultistCard.getGainedLevels() * totalCultistPlayers);
        
        return final_level;
    }
    
    protected int getOponentLevel(Monster m){
       return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    
    private Treasure giveMeATreasure(){
        Random r = new Random();
        return visibleTreasures.get(r.nextInt(hiddenTreasures.size()));
    }
    
    private boolean canYouGiveMeATreasure(){
        if(!visibleTreasures.isEmpty())
            return true;
        else
            return false;
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}

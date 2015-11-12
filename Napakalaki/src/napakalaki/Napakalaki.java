/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Napakalaki {
    private static final Napakalaki instance = new Napakalaki();
    private CombatResult result;
    
    //Variables de otras clases
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList <Player> players;
    
    private Napakalaki(){
        
    }
    
    private void initPlayers(ArrayList<String> names){
        players = new ArrayList();// Inicializamos el array
        for(String n:names){
           players.add(new Player(n));
        }
    }
    
    private Player nextPlayer(){
        
        return null;
    }
    
    private boolean nextTurnAllowed(){
    
        return false;
    }
    
    private void setEnemies(){
    
    }
    
    public static Napakalaki getInstance(){
        
        return null;
    }
    
    public CombatResult developCombat(){
        return null;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure>treasures){
    
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure>treasures){
    
    }
    
    public void makeTreasureVisible(ArrayList<Treasure>treasure){
    
    }
    
    public void initGame(ArrayList<String>players){
    
    }
    

    public Player getCurrentPlayer(){
    
        return null;
    }
     public Monster getCurrentMonster(){
     
         return null;
    }
    
    public boolean nextTurn(){
    
        return false;
    } 
    
    public boolean endOfGame(CombatResult result){
    
        return false;
    }
}
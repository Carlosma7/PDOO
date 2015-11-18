/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

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
    private CardDealer dealer=null;
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
        Player nextPlayer;  //Variable a devolver por el metodo
        
        int tam=players.size();//Guardamos el tamaño del array de jugadores
        int turno;//Turno del jugador que sea
        
        Random r = new Random(); //Variable de clase Random para el aleatorio
        
        if(currentPlayer==null){    //No iniciada
            turno=r.nextInt(tam);
        }else{  //Iniciada
            turno=0;
            for(int i=0;i<players.size();i++){
                if(currentPlayer==players.get(i))   //Buscamos el currentPlayer para pasar al siguiente
                    turno=i;
            }
            
            if(turno==tam-1){
                turno=0;
            }else{
                turno=turno++;
            }
        }
            
        nextPlayer=players.get(turno);
        
        currentPlayer=nextPlayer; //¿CUAL DE LAS DOS?
        return nextPlayer;
    }
    
    private boolean nextTurnAllowed(){
        boolean permitido=false;
        
        if(currentPlayer.validState())
            permitido=true;
        
        return permitido;
    }
    
    private void setEnemies(){
        Random r=new Random();
        Player enemy_set=players.get(r.nextInt(players.size()));
        
        for(Player p:players){
            while(p==enemy_set){
                enemy_set=players.get(r.nextInt(players.size()));
            }
            
            p.enemy=enemy_set;
            
        }
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
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
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
        boolean end=false;
        
        if(result==CombatResult.WINGAME)
            end=true;
        
        return end;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carlos
 */
public class Napakalaki {
    private static Napakalaki instance = null;
    private CombatResult result;
    
    //Variables de otras clases
    private Monster currentMonster;
    private Player currentPlayer;
    private CardDealer dealer = CardDealer.getInstance();
    private ArrayList <Player> players;

    private Napakalaki() {
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
        
        if (this.currentPlayer == null) {
            permitido = true; //La primera vez currentPlayer está sin asignar
        } else {
            permitido = this.currentPlayer.validState();
        }
        
        return permitido;
    }
    
    private void setEnemies(){
        Random r=new Random();
        Player enemy_set=players.get(r.nextInt(players.size()));
        
        for(Player p:players){
            while(p==enemy_set){
                enemy_set=players.get(r.nextInt(players.size()));
            }
            
            p.setEnemy(enemy_set);
            
        }
    }
    
    public static Napakalaki getInstance() {
        if (instance == null) {
            instance = new Napakalaki();
        }
        return instance;
    }
    
    public CombatResult developCombat(){
        CombatResult combat = this.currentPlayer.combat(this.currentMonster);
        
       if(combat==CombatResult.LOSEANDCONVERT){
           Cultist carta=dealer.nextCultist();
           CultistPlayer nuevo_jugador= new CultistPlayer(currentPlayer, carta);
           
           //Obrenemos el indice del currentplayer por sustituirlo por el cultista
            int indice = players.indexOf(currentPlayer);

            //Sustituimos el cultista
            this.players.set(indice, nuevo_jugador);

            this.currentPlayer = nuevo_jugador;
       }
       return combat;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure>treasures){
        for (Treasure t:treasures) {

            this.currentPlayer.discardVisibleTreasure(t);
            this.dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure>treasures){
        for (Treasure t:treasures) {

            this.currentPlayer.discarHiddenTreasure(t);
            this.dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasureVisible(ArrayList<Treasure>treasure){
        for(Treasure t:treasure)
            this.currentPlayer.makeTreasureVisible(t);
    }
    
    public void initGame(ArrayList<String>players){
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    

    public Player getCurrentPlayer(){
    
        return currentPlayer;
    }
     public Monster getCurrentMonster(){
     
         return currentMonster;
    }
    
    public boolean nextTurn(){
    
        boolean stateOK=this.nextTurnAllowed();
        if(stateOK){
            this.currentMonster = dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            boolean dead=this.currentPlayer.isDead();
            
            if(dead){
                this.currentPlayer.initTreasures();
            }
        }
        
        return stateOK;
    } 
    
    public boolean endOfGame(CombatResult result){
        boolean end=false;
        
        if(result==CombatResult.WINGAME)
            end=true;
        
        return end;
    }
}
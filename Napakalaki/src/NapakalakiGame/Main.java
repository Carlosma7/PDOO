/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame; // Paquete al que pertenece

// Paquetes que se importan desde otros paquetes
import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Main {
    
    public static void main(String[] args) {
        Napakalaki game=Napakalaki.getInstance();   // Crear la instancia del juego
      
        NapakalakiView napakalakiView=new NapakalakiView(); // Creación Ventana del juego
        
        ArrayList<String> names;    // Para los nombres de los jugadores
        PlayerNamesCapture namesCapture= new PlayerNamesCapture(napakalakiView, true);
        
        names = namesCapture.getNames();    // Obtenemos los nombres
        
        Dice.createInstance (napakalakiView);   // Dado para el juego
        
        napakalakiView.setNapakalaki(game); // Obtenemos los nombres de los jugadores
        
        game.initGame(names); // SE INICIA EL JUEGO
        
        
        
        napakalakiView.setVisible (true);   // Apertura ventana del juego
    }
    
}

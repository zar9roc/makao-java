/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gra 
 * @author adam
 */
public class inputOutput {
    //input
    
    //ilu graczy?
    //po ile kart rozdać?
    //zagraj karte lub dobierz
    public static int inSelectCard() {
        int index = 0;
        //dodać skaner
        return index;
    }
    
    //dobierz x kart albo podbij
    //stoisz x kolejek, podbij
    //gracz x żąda karty **
    //czego żądasz?
    //na co zmieniasz?
    //dodać następną kartę?
    //**makao?
    
    
    //output
    
    //w twojej ręce są następujące karty:
    public static void outPlayerHand(int player) {
        System.out.println("Gracz " + player + " posiada następujące karty:");
        int handSize = game.gracze[player].hand.size();
        for(int i = 0; i < handSize; i++) {
            System.out.print(i + "-" + game.gracze[player].hand.get(i) + "  ");
        }
        System.out.println();
    }
    
    //podaj indeks karty (a-z)
    public static void outCardRequest() {
        System.out.println("Wybierz karte (0-" + (game.gracze[game.turnOfPlayer].hand.size() - 1) + ")");
        
    }
    
    //gracz 1 ma x kart, gracz 2 ma x kart ,...
    //na stole leży [karta]
    //niepasująca karta
    //gracz x wygrał
    //gracz x przegrał
    //gracz x zmienia kolor na
    
    
   
}

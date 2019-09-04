/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;


import java.util.Scanner;

/**
 * Gra 
 * @author adam
 */
public class inputOutput {
    public static String toColor(int colNum) {
        String col;
        switch(colNum) {
            case 0:
                col = "serca";
                break;
            case 1:
                col = "poduszki";
                break;
            case 2:
                col = "trefle";
                break;
            case 3:
                col = "wina";
                break;
            default: col = "err";
        }
        
        return col;
    }
    
    public static char toFigure(int figNum) {
        char fig;
        
        switch(figNum) {
            case 0:
                fig = 'A';
                break;
            case 1:
                fig = '2';
                break;
            case 2:
                fig = '3';
                break;
            case 3:
                fig = '4';
                break;
            case 4:
                fig = '5';
                break;
            case 5:
                fig = '6';
                break;
            case 6:
                fig = '7';
                break;
            case 7:
                fig = '8';
                break;
            case 8:
                fig = '9';
                break;
            case 9:
                fig = 'D';
                break;
            case 10:
                fig = 'J';
                break;
            case 11:
                fig = 'Q';
                break;
            case 12:
                fig = 'K';
                break;
            default: 
                fig = 'E';
        }
        return fig;
    }
    
    
    //input
    
    //ilu graczy?
    //po ile kart rozdać?
    //zagraj karte lub dobierz
    public static int inSelectCard() {
        int index = 0;
        //TODO: dodać skaner
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
    public static void outErrIncompatibile(int was) {
        
        System.out.println("Mozesz polozyc albo " + toColor(was / 13) + " albo " + toFigure(was % 13) + "!");
    }
    
    //gracz x wygrał
    //gracz x przegrał
    //gracz x zmienia kolor na
    
    
   
}

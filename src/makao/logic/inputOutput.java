/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao.logic;


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
    
    //*ilu graczy?
    
    //*po ile kart rozdać?
    
    //zagraj karte lub dobierz
    public static int inSelectCard() {
        int index = -2;
        
        Scanner sc = new Scanner(System.in); //heeej, przekazywanie wartości ułatwi znacznie testowanie jednostkowe!!!
        while(index >= game.gracze[game.turnOfPlayer].hand.size() || index < -1)
            index = sc.nextInt();
        sc.close();
        return index;
    }
    
    //dobierz x kart albo podbij
    //stoisz x kolejek, podbij
    //gracz x żąda karty **
    //czego żądasz?
    public static int inFigChangeInput() {
        int figure = -1;
        Scanner sc = new Scanner(System.in);
        while(figure < 0 || figure >= 13) {
            figure = sc.nextInt();
            
            if(figure < 0 || figure >= 13 ) {
                System.out.println("Jeszcze raz!");
                outChangeFigRequest();
            }
        }
        sc.close();
        return figure;
    }
    
    //na co zmieniasz?
    
    public static int inColorChangeInput() {
        int index = -1;
        
        Scanner sc = new Scanner(System.in);
        while(index < 0 || index >= 4) {
            index = sc.nextInt();
        
            if (index < 0 || index >= 4) {
                System.out.println("Powtorz!");
                outChangeColorRequest();
            }
        }
        sc.close();
        return index;
    }
    
    
    //dodać następną kartę?
    
    //**makao?
    
    
    //output
    
    //w twojej ręce są następujące karty:
    public static void outPlayerHand(int player) {
        System.out.println("Gracz " + player + " posiada następujące karty:");
        int handSize = game.gracze[player].hand.size();
        for(int i = 0; i < handSize; i++) {
            int printedCard = game.gracze[player].hand.get(i);
            
            System.out.print(i + "-" + toColor(printedCard / 13) + toFigure(printedCard % 13) + "; ");
        }
        System.out.println();
    }
    
    //podaj indeks karty (a-z)
    public static void outCardRequest() {
        System.out.println("Wybierz karte (0-" + (game.gracze[game.turnOfPlayer].hand.size() - 1) + ")");
        System.out.println("Wpisz -1 aby pobrac karte lub zakonczyc wybor.");
        
    }
    
    //gracz 1 ma x kart, gracz 2 ma x kart ,...
    public static void outPlayersCardsAmount() {
        int playerCount = game.gracze.length;
        for(int i = 0; i < playerCount; i++) {
            if(game.gracze[i].won) System.out.println("Gracz " + i + " juz wygral.");
            else {
                System.out.print("Gracz " + i + " ma " + game.gracze[i].hand.size() + " kart");
                if (game.gracze[i].tury > 0) System.out.println(" i stoi jeszcze " + game.gracze[i].tury + " kolejek.");
                else System.out.println('.');
            }   
        }
    }
    
    //na stole leży [karta]
    public static void outCurrentCard(int id) {
        System.out.println("Na stole lezy " + toFigure(id % 13) + toColor(id / 13));
    }
    
    //niepasująca karta
    public static void outErrIncompatibile(int was) {
        System.out.println("Mozesz polozyc albo " + toColor(was / 13) + " albo " + toFigure(was % 13) + "!");
    }
    
    //gracz x traci turę, zostało mu x kolejek/wchodzi do gry
    public static void outStunned(int times) {
        System.out.println("Gracz " + game.turnOfPlayer + " pominiety.");
        System.out.println("Zostalo mu jeszcze " + times + " kolejek.");
    }
    
    //gracz x wygrał
    public static void outPlayerWon(int id) {
        System.out.println("Gracz " + id + " pozbyl sie swojej ostatniej karty i wygral.");
    }
    
    //gracz x przegrał
    public static void outPlayerLose(int id) {
        System.out.println("Gracz " + id + " przegral!");
    }
    
    //wybierz kolor na ktory zmieniasz
    public static void outChangeColorRequest() {
        System.out.println("Podaj nr koloru, na ktory zmieniasz \n0 - serce, 1 - dzwonek, 2 - zoladz, 3 - wino");
    }
    
    //gracz x zmienia kolor na
    public static void outChangeColor(int player, int color) {
        System.out.println("Gracz " + player + " zmienia kolor na " + toColor(color));
    }
    
    //wybierz żądaną figurę
    public static void outChangeFigRequest() {
        System.out.println("Podaj nr figury: 1 - AS, 13 - Krol");
    }
    
    //gracz x żąda figury
    public static void outChangeFig(int player, int fig) {
        System.out.println("Gracz " + player + " zada " + toFigure(fig));
    }
    
    
   
}

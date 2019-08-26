/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;
import java.util.ArrayList;
import java.util.Random;



public class Main {
    
    
    
    //static public int[][] card = new int[3][12];
    //static public boolean[][] cardDeck = new boolean[3][12];
    
    //liczbaGraczy
    static public int playersNum;
    static public int startingHand = 5;
    static public int table;
    static public int turnPlayer;
    
    static public class Player {

        ArrayList<Integer> hand;
        boolean makao;
        boolean stoi;
        int tury;
    }
    
    static public void Kolejka(Player gracze[], int turn) {
        System.out.println("kolejka gracza: ");
        
        //ruch gracza
        
        
        turn++;
        
        for(int i = playersNum; --i >= 0;) {
            if (gracze[i].hand.isEmpty()) {
                playersNum--;
            }
        }
    }
    
    public void AccumulateCharge(int val) {
        //accumulate 5 cards
    }
    
    public void RestrictNextCard(int card) {
        //figures or colors
    }
    
    public void WarnFreeze() {
        
    }
    
    public void WarnStack() {
        
    }
    
    public void RequestFig() {
        
    }
    
    public void RequestColor() {
        
    }
    
    public void Used(int card) {
        if(card == 11) {
          //queenHeart();
        } else {
            int figure = card % 13;
            switch (figure) {
                case 12: //king
                    AccumulateCharge(5);
                    WarnStack();
                    break;
                case 10: //jopek
                    RequestFig();
                    break;
                case 3: //4
                    AccumulateCharge(1);
                    WarnFreeze();
                    break;
                case 2: //3
                    AccumulateCharge(3);
                    WarnStack();
                    break;
                case 1: //2
                    AccumulateCharge(2);
                    WarnStack();
                    break;
                case 0: //Ace
                    RequestColor();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        playersNum = Integer.parseInt(args[1]);
        
//        int colorRandom;
//        int figureRandom;
        
        
        
        //populate cards matrix 
        
//        int k = 0;
//        for (int i = 3 ; i >= 0; i--) {
//            for (int j = 12; j>= 0; j--) {
//                card[i][j] = k++;
//                //cardDeck[i][j] = true;
//            }
//        }
        
        //Utworzenie wektora graczy
            //utworzenie wektora ręki każdego gracza
        
        Player gracze[] = new Player[playersNum];
        
        
        //Rozdanie kart
        for(int i = playersNum; i >= 0; i--) {
            gracze[i] = new Player();
            for (int j = 5; --j>=0; ) {
                
//                while(!cardDeck[colorRandom][figureRandom]) {
//                    colorRandom = random.nextInt() % 4;
//                    figureRandom = random.nextInt() % 13;
//                }
                
                gracze[i].hand.add(random.nextInt() % 52);
            }
        }
        
        //Wybór startowej karty
        table = random.nextInt() % 52;
        while (table % 13 <= 3 || table % 13 >= 10) {
            table = random.nextInt() % 52;
        }
        
        
        //cykl gry
        while(playersNum >= 2) {
            Kolejka(gracze, turnPlayer);
        }
        
    }
}

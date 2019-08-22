/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;
import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author adam
 */



public class Main {
    
    Random random = new Random();
    
    static public int[][] card = new int[3][12];
    
    //liczbaGraczy
    static public int playersNum;
    static public int startingHand = 5;
    
    public class Player {
        int id;
        ArrayList<Integer> hand;
        boolean makao;
        boolean stoi;
        int kolejki;
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
        playersNum = Integer.parseInt(args[1]);
        
        //populate cards matrix 
        
        int k = 0;
        for (int i = 3 ; i >= 0; i--) {
            for (int j = 12; j>= 0; j--) {
                card[i][j] = k++;
            }
        }
        
        //Utworzenie wektora graczy
            //utworzenie wektora ręki każdego gracza
        
        ArrayList<Player> gracze;
        
        //Rozdanie kart
        for(int i = playersNum; i >= 0; i--) {
            
            //t0d0 zrobić metodę przekazywującą dane do klasy
        }
        
        
    }
}

/*
TODO:

Zaprogramować ruch gracza
    
    użyć biblioteki wejścia, 
    zinterpretować parametry wejścia
Zaprogramować prawo kładzenia kart
    Rzucanie wielu kart
    Opcja Makao
    Opcja PobórKarty
    Naliczanie kary
        Masowy pobór kart
    Uniewinnienie/DamaNaWszystko
    !Walet
    AS
    Card interpretation, basic turn logic

Napisać działanie kart

Gra hotseat
    dać imiona graczom
Licznik tur

*Gra sieciowa
**AI

*/
package makao;
import java.util.ArrayList;
import java.util.Random;




public class Main {
    
    //liczbaGraczy
    static public int playersNum;
    static public int startingHand = 5;
    static public int table;
    static public int turnPlayer = 0;
    
    static public class Player {

        ArrayList<Integer> hand;
        boolean makao = false;
        boolean stoi = false;
        int tury = 0;
        boolean won = false;
    }
    
    static public void Ruch(Player gracz) {
        //wydrukuj rękę
        System.out.println("Dostepne nastepujace karty:");
        
        for(int i = gracz.hand.size(); --i >= 0; ) {
            System.out.println(gracz.hand.get(i) + " ");
        }
        if(gracz.stoi) {
            gracz.tury--;
            if(gracz.tury == 0) 
                gracz.stoi = false;
        } else {
            int wybor;
            //czekaj na wybor
            wybor = 1;
            Used(wybor);
        }
            
        
        //czy gracz ma kolejki: nie
            //posłuchaj wyboru
                //karta
                    //(makao)
                //pobór
                    //+karta!
                        //(makao)
        //czy gracz ma kolejki: tak
            //kolejka--
    }
    
    static public void Kolejka(Player gracze[], int turn) {
        System.out.println("kolejka gracza: " + turnPlayer);
        
        //ruch gracza
        Ruch(gracze[turnPlayer]);
        
        turn++;
        
        for(int i = playersNum; --i >= 0;) {
            if (gracze[i].hand.isEmpty()) {
                gracze[i].won = true;
                
                System.out.println("Gracz " + i + " pozbył się kart!");
            }
        }
    }
    
    static public void AccumulateCharge(int val) {
        //accumulate 5 cards
    }
    
    static public void RestrictNextCard(int card) {
        //figures or colors
    }
    
    static public void WarnFreeze() {
        
    }
    
    static public void WarnStack() {
        
    }
    
    static public void RequestFig() {
        
    }
    
    static public void RequestColor() {
        
    }
    
    static public void Used(int card) {
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
        int inGame = playersNum;
        
        //Utworzenie wektora graczy
            //utworzenie wektora ręki każdego gracza
        
        Player gracze[] = new Player[playersNum];
        
        
        //Rozdanie kart
        for(int i = playersNum; i >= 0; i--) {
            gracze[i] = new Player();
            for (int j = 5; --j>=0; ) {
                
                gracze[i].hand.add(random.nextInt() % 52);
            }
        }
        
        //Wybór startowej karty
        table = random.nextInt() % 52;
        while (table % 13 <= 3 || table % 13 >= 10) {
            table = random.nextInt() % 52;
        }
        
        
        //cykl gry
        
        while(inGame >= 2) {
            Kolejka(gracze, turnPlayer);
            
            for(int i = playersNum; --i >= 0;) {
                if(!gracze[i].won && gracze[i].hand.isEmpty()) {
                    inGame--;
                    gracze[i].won = true;
                    System.out.println("Gracz " + i + " pozbył się kart!");
                }
            }
        }
        for(int i = gracze.length; --i>=0; ) {
            if(!gracze[i].won) {
                System.out.println("Gracz " + i + " przegrał!");
            }
        }
    }
}

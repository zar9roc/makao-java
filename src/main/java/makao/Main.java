/*
TODO:

Tłumaczenie cyfr na wartości kart

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
//import java.io.IOException;
import java.util.Scanner;





public class Main {
    
    //liczbaGraczy
    static public int playersNum;
    static public int startingHand = 5;
    static public int table;
    static public int turnPlayer = 0;
    static public Random random = new Random();
    static public Scanner sc = new Scanner(System.in); //przerzucić do funkcji
    
    
    static public class Player {

        ArrayList<Integer> hand;
        boolean makao = false;
        int tury = 0;
        boolean won = false;
    }
    

    
    static public int Interpretuj(String in) {
        int out = 0;
        //todo: interpretacja wybranej karty, oraz ew makała lub poboru karty
            //np 10 karta z makaem to "10m"
            //zwraca wartosc -10 (generalnie ujemną za makao)
            //lub
            //pobor karty to "p"
            //zwraca wartosc 0
            
        
        return out;
    }
    
    static public void Ruch(Player gracz) {
        //wydrukuj rękę
        System.out.println("Dostepne nastepujace karty:");
        
        for(int i = gracz.hand.size(); --i >= 0; ) {
            System.out.print(card.cardName(i) + " ");
        }
        
        System.out.println();
        
        if(gracz.tury > 0) {
            gracz.tury--;

        } else {
            int wybor = 0;
            //wybor = System.in.read();
            //czekaj na wybor
            System.out.println("");
            
            String userInput =  sc.nextLine();
            
            wybor = Interpretuj(userInput);
            
            Used(wybor);
            
        }
            
        
        //czy gracz ma kolejki: nie
            //posłuchaj wyboru
                //karta
                    //(makao)
                //pobór
                    //+karta!
                        //(makao)
    }
    
    static public void Kolejka(Player gracze[]) {
        System.out.println("kolejka gracza: " + turnPlayer);
        
        //ruch gracza
        Ruch(gracze[turnPlayer]);

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
        
        int inGame = playersNum = 4;
        
        //Utworzenie wektora graczy
            //utworzenie wektora ręki każdego gracza
        
        Player gracze[] = new Player[playersNum];
        
        
        //Rozdanie kart
        for(int i = playersNum; --i >= 0; ) {
            gracze[i] = new Player();
            gracze[i].hand = new ArrayList<>();
            
            for (int j = 5; --j>=0; ) {
                gracze[i].hand.add(random.nextInt() % 52);
            }
        }
        
        //Wybór startowej karty
        table = random.nextInt() % 52;
        while (table % 13 <= 3 || table % 13 >= 10) {
            table = random.nextInt() % 52;
            System.out.println("Na stoliku stoi " + card.cardName(table));
        }
        
        
        //cykl gry
        
        while(inGame >= 2) {
            Kolejka(gracze);
            
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
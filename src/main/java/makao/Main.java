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
    static public int stack;
    static public int turnPlayer = 0;
    static public Random random = new Random();
    static public Scanner sc = new Scanner(System.in); //przerzucić do funkcji

    public static void main(String[] args) {
        
        player.setStartingHand(5);
        player.setPlayersNum(4);
        
        //Wybór startowej karty
        stack = random.nextInt() % 52;
        while (stack % 13 <= 3 || stack % 13 >= 10) {
            stack = random.nextInt() % 52;
            System.out.println("Na stoliku stoi " + card.getCardName(stack));
        }
        
        game.playGame();

    }
}
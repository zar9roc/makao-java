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

import java.util.Random;

public class Main {
   
    static public Random random = new Random(); //potencjalny kandydat do przeprowadzki
    
    public static void main(String[] args) {
        
        player.setStartingHand(5);
        player.setPlayersNum(4);
        game.playGame();

    }
}
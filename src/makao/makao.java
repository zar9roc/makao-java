package makao;
/*
TODO:

Rozwinąć skutek player.playCard
    (zaprogramować funkcje w card.java)

~Zaprogramować prawo kładzenia kart
+    Rzucanie wielu kart       
    Opcja Makao
+    Opcja PobórKarty
    Naliczanie kary       
+        Masowy pobór kart
    Uniewinnienie/DamaNaWszystko
    !Walet       
    AS
~    Card interpretation, basic turn logic

Napisać działanie kart

Gra hotseat
    dać imiona graczom
Licznik tur
       
*Gra sieciowa
**AI

*/

import java.util.Random;

import makao.logic.game;

public class makao {
   
    static public Random random = new Random(); //potencjalny kandydat do przeprowadzki
        
    public static void main(String[] args) {
        int numberOfPlayers = 4;
        int numberOfPlayedCards = 5;
        game.init(numberOfPlayers, numberOfPlayedCards); //dla 4 graczy rozdaj po 5 kart
        game.playGame();
        
    }
}
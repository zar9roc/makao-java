package makao_ant;
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

public class Makao_ant {
   
    static public Random random = new Random(); //potencjalny kandydat do przeprowadzki
    int a = 0;
    
    public static void main(String[] args) {
        
        game.init(4, 5); //dla 4 graczy rozdaj po 5 kart
        game.playGame();
    }
}
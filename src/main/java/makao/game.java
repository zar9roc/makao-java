/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;

/**
 *
 * @author adam
 */
public class game {
    private static int turnPlayer;
    
    private static int getPlayersInGame() {
        return player.getPlayersInGame();
    }
    
    static public void kolejka(player.PlayerC gracze[]) { //tutaj chyba jest bug
        System.out.println("kolejka gracza: " + turnPlayer);
        
        //ruch gracza
        table.ruch(gracze[turnPlayer]);

    }
    
    public static void checkWinCondition() {
        for(int i = player.getPlayersNum(); --i >= 0; ) {
                if(player.gracze[i].hand.isEmpty() && !player.gracze[i].won) {
                    player.gracze[i].won = true;
                    player.decreasePlayersInGameValue();
                    
                    System.out.println("Gracz " + i + " pozbył się kart!");
                }
            }
    }
    
    public static void printLooser() {
            for(int i = player.gracze.length; --i>=0; ) {
                if(!player.gracze[i].won) {
                    System.out.println("Gracz " + i + " przegrał!");
            }
        }

    }
    
    public static void playGame() {
        table.setStackCard(); //no parameters means random

        while (getPlayersInGame() >= 2) {
            
            kolejka(player.gracze);
            
            checkWinCondition();
        }
    }
}

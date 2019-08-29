/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;

import java.util.ArrayList;


public class player {
    
    static private int playersNum;
    static private int playersInGame;
    static private int startingHand;
    static public PlayerC[] gracze;
    
    public static class PlayerC {
        ArrayList<Integer> hand;
        boolean makao = false;
        int tury = 0;
        boolean won = false;
    }
    
    static public void setStartingHand(int val) {
        startingHand = val;
    }
    
    static public int getStartingHand() {
        return startingHand;
    }
    
    static private void setPlayersInGame(int val) {
        playersInGame = val;
    }
    
    static public int getPlayersInGame() {
        return playersInGame;
    }
    
    static public void decreasePlayersInGameValue() {
        playersInGame--;
    }
    
    static public void setPlayersNum(int val) {
        playersNum = val;
        setPlayersInGame(val);
        
        gracze = new PlayerC[val];
        
        for(int i = val; --i >= 0 ;) {
            gracze[i] = new PlayerC();
            gracze[i].hand = new ArrayList<>();
            
            card.givePlayersCards(i, startingHand);
        }
    }
    
    static public int getPlayersNum() {
        return playersNum;
    }
}

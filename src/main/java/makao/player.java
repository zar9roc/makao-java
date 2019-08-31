/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;

import java.util.ArrayList;


public class player {
    
    static private int playersNum = 0;
    static private int playersInGame = 0;
    
    //public String name;
    public ArrayList<Integer> hand; //52,21,37,12
    //public boolean makao = false;
    public int tury = 0;
    public boolean won = false;

    static private void setPlayersInGame(int val) {
        playersInGame = val;
    }
    
    static public int getPlayersInGame() {
        return playersInGame;
    }
    
    static public void decreasePlayersInGameValue() {
        playersInGame--;
    }
    
    static public int getPlayersNum() {
        return playersNum;
    }
    
    public int[] playCard (int[] indexes) {
    	int[] playedCards = new int[indexes.length];
    	
    	for (int i=indexes.length ; --i>=0 ; ){
    		playedCards[i] = hand.get(indexes[i]);
    	}
    	for (int i=indexes.length ; --i>=0 ; ){
    		hand.remove(indexes[i]);
    	}
    	return playedCards;
    }
    
    public void drawCard(int amount) {
    	for (int i = amount ; --i >= 0 ;) {
    		hand.add(table.giveCard());
    	}

    }
}

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
    	int[] sortedIndexes = new int[indexes.length];
        
        //indeks -> karta
    	for (int i=indexes.length ; --i>=0 ; ){
    		playedCards[i] = hand.get(indexes[i]);
    	}
        
        //sortowanie indeksów malejąco
        for (int i = indexes.length; --i >= 0; ) {
            
            int highestIndex = -1;
            
            for (int j = indexes.length; --j >=0 ; ) {
                if (highestIndex < indexes[j]) 
                    highestIndex = indexes[j];
            }
            for (int j = indexes.length; --j >= 0 ;) {
                if (highestIndex == indexes[j]) {
                    indexes[j] = -1;
                    break;
                }
            }
            
            sortedIndexes[i] = highestIndex;
        }
        
        //usuwanie kart z ręki po indeksach
    	for (int i=sortedIndexes.length ; --i>=0 ; ) {hand.remove(sortedIndexes[i]); }
    	
    	return playedCards;
    }
    
    public void drawCard(int amount) {
    	for (int i = amount ; --i >= 0 ;) {
    		hand.add(table.giveCard());
    	}

    }
}

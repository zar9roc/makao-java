/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao_ant;

import java.util.ArrayList;
/*
Gracze mają podzbiór graczy grających (reszta już wygrała)
Gdy zostanie jeden gracz grający, gra się kończy
Gracz ma ruch
    Rzucić kartę
    Pobrać kartę
Po każdej akcji przychodzi kolej na na stępnego gracza
    Jeżeli gra nakazuje graczowi pobrać karty, ten może się bronić
        (czyli podbijanie kart)
    Jeżeli gracz nie może podbić karty, może rzucić damę kier. 
    Jeżeli gracz nie może lub nie chce podbijać karty, 
        pobiera ustaloną ilość kart (albo stoi ustaloną ilość kolejek)

 */
public class player {
    
    static private int playersNum;
    static private int playersInGame;
    
    //public String name;
    public ArrayList<Integer> hand;
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
    
    static public void setPlayersNum(int playersNumber) {
        playersNum = playersNumber;
        setPlayersInGame(playersNumber);
    }
    
    static public int getPlayersNum() {
        return playersNum;
    }
    
    
    
    public int[] playCard (Integer[] indexes) {
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
    	
    	return playedCards; //WTF Co ona zwraca
    }
    
    public void drawCard(int amount) {
    	for (int i = amount ; --i >= 0 ;) {
    		hand.add(table.giveCard());
    	}

    }
}

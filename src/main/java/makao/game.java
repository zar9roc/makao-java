/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao;

import java.util.ArrayList;

import java.util.Scanner;

//ciekawostka
//import static makao.table.Interpretuj;

/**
 * Na początku należy zainicjować grę, a potem ją uruchomić
 * w skład gry wchodzą
 *      gracze
 *      stos kart zakrytych (nieskończony v1.0)
 *      karta odkryta
 *  
 * każdy gracz ma ruch, w którym wybiera karty do zagrania
 *      gracz może zagrać jedynie karty kompatybilne z kartą już zagraną
 *      gracz może użyć więcej niż jedną kartę za jednym razem
 * po ruchu gracza następuje kolej na nastepnego
 * 
 * gdy gracz odda ostatnią kartę, wygrywa
 * gdy zostanie jeden gracz, gra się kończy
 * 
 * 
 * @author adam
 */
public class game {
    
    
    public static player[] gracze;
    public static int turnOfPlayer;
    public static int topCard;
    
    //*instancja talii kart
    

    static public void ruch(player gracz) {


        if(gracz.tury > 0) {
            gracz.tury--;

        } else {
            int wybor;
            //wybor = System.in.read();
            //czekaj na wybor
            
            Scanner sc = new Scanner(System.in);
            
            String userInput =  sc.nextLine();
            
            wybor = table.Interpretuj(userInput);
            
            card.used(wybor);
            
        }
            
        
        //czy gracz ma kolejki: nie
            //posłuchaj wyboru
                //karta
                    //(makao)
                //pobór
                    //+karta!
                        //(makao)
    }
    
    
    
    
    private static int getPlayersInGame() {
        return player.getPlayersInGame();
    }
    
    
    
    public static void checkWinCondition() {
        for(int i = player.getPlayersNum(); --i >= 0; ) {
            if(gracze[i].hand.isEmpty() && !gracze[i].won) {
                gracze[i].won = true;
                player.decreasePlayersInGameValue();
                inputOutput.outPlayerWon(i);
            }
        }
    }
    
    public static void nextPlayer() {
        while(turnOfPlayer == player.getPlayersNum() || gracze[turnOfPlayer].won) {
            turnOfPlayer++;
        }
    }
    public static boolean possibleToPut(int askCard, int cardBefore) {
        boolean q;

        q = cardBefore % 13 == gracze[turnOfPlayer].hand.get(askCard) % 13 
            || cardBefore / 13 == gracze[turnOfPlayer].hand.get(askCard) / 13;
        
        return q;
    }

    public static ArrayList<Integer> playerSelection() {
        ArrayList<Integer> selection = new ArrayList<>();
        int input = -2;
        int cardBefore = topCard;
        boolean complete = false;
        
        inputOutput.outCardRequest();
        
        while(!complete) {
            while(input >= gracze[turnOfPlayer].hand.size() || input < -1) input = inputOutput.inSelectCard();
            if (input == -1) complete = true;
            else if (possibleToPut(input,cardBefore)) {
                selection.add(input);
                cardBefore = input;
            }
            else inputOutput.outErrIncompatibile(cardBefore);
            input = -2;
        }
        
        return selection;
    }
    
    public static Integer[] getPlayerSelection() {
        
        
        
        inputOutput.outPlayerHand(turnOfPlayer);
        
        //game.gracze[turnOfPlayer]
        
        
        ArrayList<Integer>  selection = playerSelection();
        
        
        Integer[] selectionArray = new Integer[selection.size()];
        selectionArray = selection.toArray(selectionArray);
        
        return selectionArray;
    }
    
    public static void playGame() {
        while (getPlayersInGame() >= 2) {
            if (gracze[turnOfPlayer].tury > 0){
                gracze[turnOfPlayer].tury--; //zrobić z tego metodę?
                inputOutput.outStunned(gracze[turnOfPlayer].tury);
            }
            else gracze[turnOfPlayer].playCard(getPlayerSelection());
            checkWinCondition();
            nextPlayer();
        }
    }
    
    static public void init(int numberOfPlayers, int numberOfStartingHand) {
        
        gracze = new player[numberOfPlayers];
        for(int i = numberOfPlayers; --i >= 0; ) {
            gracze[i] = new player();
            gracze[i].hand = new ArrayList<>();
            
            gracze[i].drawCard(numberOfStartingHand);
        }
        
        player.setPlayersNum(numberOfPlayers);
        
        topCard = table.giveCard();

        //select first player
        turnOfPlayer = Main.random.nextInt() %  player.getPlayersNum();
        
    }
}

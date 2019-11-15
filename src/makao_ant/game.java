/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//TOPCARD SIĘ NIE ZMIENIA
package makao_ant;

import java.util.ArrayList;

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
    public static int turnOfPlayer = 0;
    public static int topCard;
    public static int charge = 0;
    public static int jopekHandling = -1;
    
    //*instancja talii kart
    
    //metoda wyciągająca aktualny kolor
    static int getCurrentColor() {
        return topCard / 4;
    }
    
    //metoda wyciągajaca aktualną figurę
    public static int getCurrentFigure() {
        return topCard % 13;
    }
    
    public static int getPlayersInGame() {
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
        turnOfPlayer++;
        while(turnOfPlayer == player.getPlayersNum() || gracze[turnOfPlayer].won) {
            turnOfPlayer++;
        }
    }
    public static boolean possibleToPut(int askCard, int cardBefore, boolean isItFirstCard) {
        boolean q;
        
        if(gracze[turnOfPlayer].hand.get(askCard) == 11 || cardBefore == 11) {
            q = true;
            charge = 0;
        } //dama na wszystko, wszystko na damę, zdjęte "charge"
        else if(charge > 0) {
            q = (cardBefore / 13 == gracze[turnOfPlayer].hand.get(askCard) / 13 //taki sam kolor co karta poprzednia
                    && 
                        (
                            gracze[turnOfPlayer].hand.get(askCard) % 13 != 3 //nierówna 4
                            || gracze[turnOfPlayer].hand.get(askCard) % 13 == 1 //ale równa 2
                            || gracze[turnOfPlayer].hand.get(askCard) % 13 == 2 //lub 3
                            || gracze[turnOfPlayer].hand.get(askCard) % 13 == 12 //lub K
                        ) 
                    || gracze[turnOfPlayer].hand.get(askCard) % 13 == cardBefore % 13); //lub taka sama karta, co ostatnia położona - dowolny kolor
        }
        else if(isItFirstCard)
            q = cardBefore % 13 == gracze[turnOfPlayer].hand.get(askCard) % 13 
                || cardBefore / 13 == gracze[turnOfPlayer].hand.get(askCard) / 13;
        
        else q = cardBefore % 13 == gracze[turnOfPlayer].hand.get(askCard) % 13;
        
        return q;        
    }

    
    public static ArrayList<Integer> playerSelection() {
        ArrayList<Integer> selection = new ArrayList<>();
        int input;
        
        int cardBefore;
        
        if(game.jopekHandling > 0) 
            cardBefore = game.jopekHandling;
        else
            cardBefore = topCard;
        
        boolean complete = false;
        
        inputOutput.outCardRequest();
        
        while(!complete) {
            
            input = inputOutput.inSelectCard();
            
            if (input == -1) complete = true;
            else if (possibleToPut(input,cardBefore,selection.isEmpty())) {
                selection.add(input);
                cardBefore = input;
            }
            else inputOutput.outErrIncompatibile(cardBefore);
            //input = -2;
        }
        
        return selection;
    }
    
    public static ArrayList<Integer> getPlayerSelection() {

        inputOutput.outPlayerHand(turnOfPlayer);
        
        //game.gracze[turnOfPlayer]

        ArrayList<Integer>  selection = playerSelection();

        return selection;
    }
    
    public static void playGame() {
        while (getPlayersInGame() >= 2) { //gracz odbębnia swoje kolejki
            //tryb jopkowy gry
            inputOutput.outCurrentCard(topCard);
            if (jopekHandling > 0) {
                int playerForNextMove = turnOfPlayer;
                ArrayList<Boolean> chargedPlayer = new ArrayList();
                for(int i = player.getPlayersNum(); --i >= 0;) {
                    chargedPlayer.add(Boolean.TRUE);
                }
                
                for(int i = player.getPlayersNum(); --i >= 0;) {
                    ArrayList<Integer> selection = getPlayerSelection(); //TODO: należy tutaj pozwolić na przebicie jopkiem
                    if(selection.isEmpty()) 
                        nextPlayer();
                    else {
                        Integer[] selectionArray = new Integer[selection.size()];
                        selectionArray = selection.toArray(selectionArray);
        
                        gracze[turnOfPlayer].playCard(selectionArray);
                        
                        chargedPlayer.set(turnOfPlayer, true);
                        i = player.getPlayersInGame();
                        nextPlayer();
                    }
                }
                for(int i = player.getPlayersNum(); --i >= 0;) {
                    if(!gracze[i].won && chargedPlayer.get(i))
                        gracze[i].drawCard(2);
                }
            }
            if (gracze[turnOfPlayer].tury > 0) {
                gracze[turnOfPlayer].tury--; //zrobić z tego metodę?
                inputOutput.outStunned(gracze[turnOfPlayer].tury);
            }
            else {
                //PRZENIEŚ MNIE DO FUNKCJI PLEASE
                ArrayList<Integer> selection = getPlayerSelection();
                
                if(selection.isEmpty()) {
                    if(charge > 0) {
                        if (topCard % 13 != 3) gracze[turnOfPlayer].drawCard(charge); //jeżeli jest obciążenie oraz karta na wierzchu nie jest 4
                        else gracze[turnOfPlayer].tury = charge;
                    }
                    else gracze[turnOfPlayer].drawCard(1);
                }
                
                else {
                    Integer[] selectionArray = new Integer[selection.size()];
                    selectionArray = selection.toArray(selectionArray);
        
                    gracze[turnOfPlayer].playCard(selectionArray);
                }
            }
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
            gracze[i].tury = 0;
        }
        
        player.setPlayersNum(numberOfPlayers);
        
        topCard = table.giveCard();

        //select first player
        turnOfPlayer = Makao_ant.random.nextInt() %  player.getPlayersNum();
        
    }
}

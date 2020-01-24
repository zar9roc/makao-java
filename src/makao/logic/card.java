/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO: DZIAŁANIE ASA, DZIAŁANIE JOPKA

package makao.logic;

/**
 *
 * @author adam
 */
public class card {

    static public void AccumulateCharge(int val) {
        //accumulate 5 cards
        game.charge += val;
    }
    

    static public void RequestFig() {
        //zostalo tylko to!
        
        //opcje są dwie:
            //gracze w kolejności kładą żądaną kartę, żądanie nie kończy się, 
            //dopóki ktoś ma karty w ręce, po jednym kółku bez zmian osoby, 
            //które nie żuciły żądania biorą 2 karty, następnie rusza się następna osoba po żądającym
        //druga "sieciowa" w czasie rzeczywistym, którą wolę zostawić po wprowadzeniu interface, że można się licytować,
            //wszystko dzieje się w czasie rzeczywistym :P
            
            inputOutput.outChangeFigRequest();
            
            int fig = inputOutput.inFigChangeInput();
            
            game.topCard = game.getCurrentColor() + fig;//Jopek zmienia się na żądaną figurę
            
            inputOutput.outChangeFig(game.turnOfPlayer, fig); //todo: nakazać reszcie w następnej kolejce kłaść konkretną figurę. tzn włączyć stan specjalny
    }
    
    static public void RequestColor() {
        inputOutput.outChangeColorRequest();
        int color = inputOutput.inColorChangeInput();
        game.topCard = color * 13; //kolor asa zmienia się w kolor żądany, może trochę powodować zamieszanie
        inputOutput.outChangeColor(game.turnOfPlayer ,color);
    }
    
    static public void used(int card) {
        int figure = card % 13;
        switch (figure) {
            case 12: //king
                AccumulateCharge(5);
                break;
            case 10: //jopek
                RequestFig();
                break;
            case 3: //4
                AccumulateCharge(1);
                break;
            case 2: //3
                AccumulateCharge(3);
                break;
            case 1: //2
                AccumulateCharge(2);
                break;
            case 0: //Ace
                RequestColor();
                break;
        }
    }
}

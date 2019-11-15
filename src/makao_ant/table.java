/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makao_ant;



/**
 *  Na stole jest talia kart zakrytych, oraz (jedna) aktualnie zagrana karta
 *  gracze biorą karty ze stosu, oraz rzucają karty z ręki, 
 *  zmieniając w ten sposób aktualnie zagraną kartę
 *  w pierwszej wersji gry stos kart jest zawsze nieskończony
 * @author adam
 */
public class table {
    
    
    static public int Interpretuj(String in) {
        int out = 0;
        //todo: interpretacja wybranej karty, oraz ew makała lub poboru karty
            //np 10 karta z makaem to "10m"
            //zwraca wartosc -10 (generalnie ujemną za makao)
            //lub
            //pobor karty to "p"
            //zwraca wartosc 0
            
        
        return out;
    }
    
    static public int giveCard() {
        int returnValue = -1;
        while(returnValue < 0) returnValue = Makao_ant.random.nextInt();
        
    	return returnValue % 52; //xDDD, losowało ujemne wartości czasem
    }
}

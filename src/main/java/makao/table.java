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
public class table {
    private static int stack;
    
    public static void setStackCard() {
        stack = Main.random.nextInt() % 52;
        System.out.println("Na startowa karte wylosowano: " + card.getCardName(stack));
    }
    
    public static void setStackCard(int playerCard) {
        stack = playerCard;
    }
    
    public static int getStackCard() {
        return stack;
    }
    
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
    
    static public void Ruch(player.PlayerC gracz) {
        //wydrukuj rękę
        System.out.println("Dostepne nastepujace karty:");
        
        for(int i = gracz.hand.size(); --i >= 0; ) {
            System.out.print(card.getCardName(i) + " ");
        }
        
        System.out.println();
        
        if(gracz.tury > 0) {
            gracz.tury--;

        } else {
            int wybor = 0;
            //wybor = System.in.read();
            //czekaj na wybor
            System.out.println("");
            
            String userInput =  Main.sc.nextLine();
            
            wybor = Interpretuj(userInput);
            
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
    
    static public void ruch(player.PlayerC gracz) {
        //wydrukuj rękę
        System.out.println("Dostepne nastepujace karty:");
        
        for(int i = gracz.hand.size(); --i >= 0; ) {
            System.out.print(card.getCardName(i) + " ");
        }
        System.out.println();
        
        if(gracz.tury > 0) {
            gracz.tury--;

        } else {
            int wybor = 0;
            //wybor = System.in.read();
            //czekaj na wybor
            System.out.println("");
            
            String userInput =  Main.sc.nextLine();
            
            wybor = Interpretuj(userInput);
            
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
}

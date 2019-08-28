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
public class card {
    int color;
    int figure;
    
    static public String cardName(int id) {
        String name = "xD";
        
        int color = id / 13;
        int fig = id % 13;
        
        switch(fig) {
            case 0:
                name = "A";
                break;
            case 1:
                name = "2";
                break;
            case 2:
                name = "3";
                break;
            case 3:
                name = "4";
                break;
            case 4:
                name = "5";
                break;
            case 5:
                name = "6";
                break;
            case 6:    
                name = "7";
                break;
            case 7:
                name = "8";
                break;
            case 8:
                name = "9";
                break;
            case 9:
                name = "10";
                break;
            case 10:
                name = "J";
                break;
            case 11:
                name = "Q";
                break;
            case 12:
                name = "K";
                break;
        }
        
        switch(color) {
            case 0:
                name = name.concat("heart");
                break;
            case 1:
                name = name.concat("pillow");
                break;
            case 2: 
                name = name.concat("trefl");
                break;
            case 3: 
                name = name.concat("spade");
                break;
        }
        
        return name;
    }
}

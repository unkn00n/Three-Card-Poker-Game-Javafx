
import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {

    ThreeCardLogic(){
        
    }
    
    public static int evalHand(ArrayList<Card> hand){
        Collections.sort(hand);
        if(straightFlush(hand)){
            return 1;
        }
        else if(threeOfAKind(hand)){
            return 2;
        }
        else if(straight(hand)){
            return 3;
        }
        else if(flush(hand)){
            return 4;
        }
        else if(pair(hand)){
            return 5;
        }
        else{
            return 0;
        }
    }

    public static int evalPPWinnings(ArrayList<Card> hand, int bet){
        int evaluate = evalHand(hand);
        if(evaluate == 1){  //40 to 1 (Straight Flush)
            int win = bet*40;
            return win;
        }
        else if(evaluate == 2){  //30 to 1 (Three of a Kind)
            int win = bet*30;
            return win;
        }
        else if(evaluate == 3){  //6 to 1 (Straight)
            int win = bet*6;
            return win;
        }
        else if(evaluate == 4){  //3 to 1 (Straight)
            int win = bet*3;
            return win;
        }
        else if(evaluate == 5){   //1 to 1 (Pair)
            return bet; 
        }
        else{
            return 0;   //pair plus got nothing
        }
    }

    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player){
        if(evalHand(dealer) > evalHand(player)){
            return 2;
        }
        else if(evalHand(dealer) < evalHand(player)){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    private static boolean flush(ArrayList<Card> hand) {
        char suit = hand.get(0).getSuit();
        for (int a = 0; a < hand.size(); a++) {
            if (suit != hand.get(a).getSuit()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean straight(ArrayList<Card> hand) {
        int value = hand.get(0).getValue();
        for (int a = 0; a < hand.size()-1; a++) {
            if(value+1 == hand.get(a+1).getValue()){
                value = hand.get(a+1).getValue();
            }
            else{
                return false;
            }
            
        }
        return true;
    }
    
    private static boolean straightFlush(ArrayList<Card> hand) {
        return straight(hand) && flush(hand);
    }
    
    private static boolean threeOfAKind(ArrayList<Card> hand) {
        int value = hand.get(0).getValue();
        for (int a = 0; a < hand.size(); a++) {
            if(value != hand.get(a).getValue()){
                return false;
            }
        }
        return true;
    }

    private static boolean pair(ArrayList<Card> hand) {
        if(hand.get(0).getValue() == hand.get(1).getValue() || 
                hand.get(1).getValue() == hand.get(2).getValue() ||
                hand.get(2).getValue() == hand.get(0).getValue()){
            return true;
        }
        return false;
    }
    
    
}

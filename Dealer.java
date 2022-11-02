
import java.util.ArrayList;

public class Dealer{
    
    Deck theDeck;
    ArrayList<Card> dealersHand;
    
    public Dealer(){
        theDeck = new Deck();
        dealersHand = dealHand();
    }
    
    public ArrayList<Card> dealHand(){
        if(theDeck.size() <= 34){
            theDeck.newDeck();
        }
        ArrayList<Card> hand = new ArrayList<>();
        for (int a = 0; a < 3; a++) {
            int random = (int) (Math.random() * theDeck.size());
            hand.add(theDeck.remove(random));
        }
        return hand;
    }
    
    public boolean hasQueenHigh() {
        for (int a = 0; a < dealersHand.size(); a++) {
            if(dealersHand.get(a).getValue() >= 12 && dealersHand.get(a).getValue() <= 14){
                return true;
            }
        }
        return false;
    }
    
    public int getHighValue() {
        int max = 0;
        for (Card card : dealersHand) {
            if(max < card.getValue()){
                max = card.getValue();
            }
        }
        return max;
    }
    
}
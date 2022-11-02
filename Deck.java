
import java.util.ArrayList;

public class Deck extends ArrayList<Card> {
    
    public Deck(){
        char[] suits = new char[]{'C', 'D', 'S', 'H'};
        for (int a = 0; a < suits.length; a++) {
            for (int b = 2; b <= 14; b++) {
                super.add(new Card(suits[a], b));
            }
        }
    }
    
    public void newDeck(){
        super.clear();
        char[] suits = new char[]{'C', 'D', 'S', 'H'};
        for (int a = 0; a < suits.length; a++) {
            for (int b = 2; b <= 14; b++) {
                super.add(new Card(suits[a], b));
            }
        }
    }

}

import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    
    /**
     * Test constructor method, of class Deck.
     */
    @Test
    public void testDeck() {
        System.out.println("Deck");
        Deck deck = new Deck();
        int expResult = 52;
        int result = deck.size();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of newDeck method, of class Deck.
     */
    @Test
    public void testNewDeck() {
        System.out.println("newDeck");
        Deck deck = new Deck();
        for (int i = 0; i < 10; i++) {
            deck.remove(i);
        }
        int expResult = 42;
        int result = deck.size();
        assertEquals(expResult, result);
        deck.newDeck();
        expResult = 52;
        result = deck.size();
        assertEquals(expResult, result);
        deck.newDeck();
    }
    
}

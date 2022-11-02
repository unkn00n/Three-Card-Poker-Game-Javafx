

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class DealerTest {
    
    /**
     * Test of dealHand method, of class Dealer.
     */
    @Test
    public void testDealHand() {
        System.out.println("dealHand");
        Dealer dealer = new Dealer();
        int expResult = 3;
        ArrayList<Card> result = dealer.dealHand();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of hasQueenHigh method, of class Dealer.
     */
    @Test
    public void testHasQueenHigh() {
        System.out.println("hasQueenHigh");
        Dealer dealer = new Dealer();
        int expResult = 3;
        int result = dealer.dealersHand.size();
        assertEquals(expResult, result);
        boolean expected = false;
        for (Card card : dealer.dealersHand) {
            if(card.getValue() >= 12 && card.getValue() <= 14){
                expected = true;
            }
        }
        boolean result2 = dealer.hasQueenHigh();
        assertEquals(expected, result2);
    }

    /**
     * Test of getHighValue method, of class Dealer.
     */
    @Test
    public void testGetHighValue() {
        System.out.println("getHighValue");
        Dealer dealer = new Dealer();
        int expResult = 3;
        int result = dealer.dealersHand.size();
        assertEquals(expResult, result);
        Card expectedHigh = dealer.dealersHand.get(0);
        for (Card card : dealer.dealersHand) {
            if(expectedHigh.getValue() < card.getValue()){
                expectedHigh = card;
            }
        }
        int result2 = dealer.getHighValue();
        assertEquals(expectedHigh.getValue(), result2);
        
    }
    
}

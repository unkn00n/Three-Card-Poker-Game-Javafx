
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class ThreeCardLogicTest {
    
    /**
     * Test of evalHand method, of class ThreeCardLogic.
     */
    @Test
    public void testEvalHand() {
        System.out.println("evalHand");
        //test straight flush (1)
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card('S', 2));
        hand1.add(new Card('S', 4));
        hand1.add(new Card('S', 3));
        int expResult = 1;
        int result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test straight flush (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('H', 6));
        hand1.add(new Card('H', 5));
        hand1.add(new Card('H', 7));
        expResult = 1;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test three of a kind (1)
        hand1 = new ArrayList<>();
        hand1.add(new Card('S', 2));
        hand1.add(new Card('D', 2));
        hand1.add(new Card('H', 2));
        expResult = 2;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test three of a kind (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('S', 10));
        hand1.add(new Card('D', 10));
        hand1.add(new Card('H', 10));
        expResult = 2;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test straight (1)
        hand1 = new ArrayList<>();
        hand1.add(new Card('S', 10));
        hand1.add(new Card('D', 12));
        hand1.add(new Card('H', 11));
        expResult = 3;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test straight (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('H', 3));
        hand1.add(new Card('C', 2));
        hand1.add(new Card('C', 4));
        expResult = 3;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test flush (1)
        hand1 = new ArrayList<>();
        hand1.add(new Card('H', 10));
        hand1.add(new Card('H', 14));
        hand1.add(new Card('H', 11));
        expResult = 4;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test flush (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('C', 2));
        hand1.add(new Card('C', 10));
        hand1.add(new Card('C', 9));
        expResult = 4;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test pair (1)
        hand1 = new ArrayList<>();
        hand1.add(new Card('H', 10));
        hand1.add(new Card('D', 10));
        hand1.add(new Card('H', 11));
        expResult = 5;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test pair (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('S', 12));
        hand1.add(new Card('S', 14));
        hand1.add(new Card('D', 12));
        expResult = 5;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test not anything (1)
        hand1 = new ArrayList<>();
        hand1.add(new Card('H', 8));
        hand1.add(new Card('D', 10));
        hand1.add(new Card('H', 11));
        expResult = 0;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
        //test not anything (2)
        hand1 = new ArrayList<>();
        hand1.add(new Card('S', 3));
        hand1.add(new Card('S', 14));
        hand1.add(new Card('C', 2));
        expResult = 0;
        result = ThreeCardLogic.evalHand(hand1);
        assertEquals(expResult, result);
    }

    /**
     * Test of evalPPWinnings method, of class ThreeCardLogic.
     */
    @Test
    public void testEvalPPWinnings() {
        System.out.println("evalPPWinnings");
        //test 1
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card('S', 2));
        hand.add(new Card('S', 4));
        hand.add(new Card('S', 3));
        int bet = 10;
        int expResult = 400;
        int result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
        //test 2
        hand = new ArrayList<>();
        hand.add(new Card('S', 10));
        hand.add(new Card('D', 10));
        hand.add(new Card('H', 10));
        bet = 5;
        expResult = 150;
        result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
        //test 3
        hand = new ArrayList<>();
        hand.add(new Card('S', 10));
        hand.add(new Card('D', 12));
        hand.add(new Card('H', 11));
        bet = 25;
        expResult = 150;
        result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
        //test 4
        hand = new ArrayList<>();
        hand.add(new Card('C', 2));
        hand.add(new Card('C', 10));
        hand.add(new Card('C', 9));
        bet = 10;
        expResult = 30;
        result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
        //test 5
        hand = new ArrayList<>();
        hand.add(new Card('S', 12));
        hand.add(new Card('S', 14));
        hand.add(new Card('D', 12));
        bet = 15;
        expResult = 15;
        result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
        //test 6
        hand = new ArrayList<>();
        hand.add(new Card('S', 12));
        hand.add(new Card('H', 10));
        hand.add(new Card('D', 4));
        bet = 0;
        expResult = 0;
        result = ThreeCardLogic.evalPPWinnings(hand, bet);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareHands method, of class ThreeCardLogic.
     */
    @Test
    public void testCompareHands() {
        System.out.println("compareHands");
        //test 1
        ArrayList<Card> dealer = new ArrayList<>();
        dealer.add(new Card('S', 12));
        dealer.add(new Card('S', 14));
        dealer.add(new Card('D', 12));
        ArrayList<Card> player = new ArrayList<>();
        player.add(new Card('C', 2));
        player.add(new Card('C', 10));
        player.add(new Card('C', 9));
        int expResult = 2;
        int result = ThreeCardLogic.compareHands(dealer, player);
        assertEquals(expResult, result);
        //test 2
        dealer = new ArrayList<>();
        dealer.add(new Card('S', 2));
        dealer.add(new Card('S', 4));
        dealer.add(new Card('S', 3));
        player = new ArrayList<>();
        player.add(new Card('C', 2));
        player.add(new Card('C', 10));
        player.add(new Card('C', 9));
        expResult = 1;
        result = ThreeCardLogic.compareHands(dealer, player);
        assertEquals(expResult, result);
        //test 3
        dealer = new ArrayList<>();
        dealer.add(new Card('S', 2));
        dealer.add(new Card('S', 4));
        dealer.add(new Card('S', 3));
        player = new ArrayList<>();
        player.add(new Card('C', 8));
        player.add(new Card('C', 7));
        player.add(new Card('C', 9));
        expResult = 0;
        result = ThreeCardLogic.compareHands(dealer, player);
        assertEquals(expResult, result);
        
    }
    
}

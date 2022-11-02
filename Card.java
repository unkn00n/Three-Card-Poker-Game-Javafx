
public class Card implements Comparable<Card>{
    char suit;
    int value;

    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public int compareTo(Card c){
        if(this.value < c.value){
            return -1;
        }
        else if(this.value > c.value){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s = "";
        if(suit == 'D'){
            s = "♦";
        }
        else if(suit == 'S'){
            s = "♠";
        }
        else if(suit == 'H'){
            s = "♥";
        }
        else if(suit == 'C'){
            s = "♣";
        }
        String v = "";
        if(value == 11){
            v = "J";
        }
        else if(value == 12){
            v = "Q";
        }
        else if(value == 13){
            v = "K";
        }
        else if(value == 14){
            v = "A";
        }
        else{
            v = value+"";
        }
        return v+""+s;
    }

}


import java.util.Comparator;


public class Card implements Comparable<Card> {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Card value must be in range 2...14.");
        }

        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String cardValue = "" + value;
        switch (value) {
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            case 14:
                cardValue = "A";
                break;
            default:
                break;
        }

        return suit + " " + cardValue;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        Comparator<Card> byValue = Comparator.comparingInt(Card::getValue);//sort by value
        Comparator<Card> bySuit = Comparator.comparing(Card::getSuit, (suit1, suit2) -> {//sort by suit
            
            // assign rank to each suit
            int rank1 = getSuitRank(suit1);
            int rank2 = getSuitRank(suit2);
            
            return Integer.compare(rank1, rank2);
        });
        return byValue.thenComparing(bySuit).compare(this, o);
    }

    private static int getSuitRank(Suit suit) {
        int suitRank;

        switch (suit) {
            case CLUB:
                suitRank = 1;
                break;
            case DIAMOND:
                suitRank = 2;
                break;
            case HEART:
                suitRank = 3;
                break;
            case SPADE:
                suitRank = 4;
                break;
            default:
                suitRank = 5;
                break;
        }

        return suitRank;
    }
}

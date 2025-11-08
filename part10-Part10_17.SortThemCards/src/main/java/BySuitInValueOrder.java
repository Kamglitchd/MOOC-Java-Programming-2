
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class BySuitInValueOrder implements Comparator<Card> {
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

    @Override
    public int compare(Card c1, Card c2) {
        Comparator<Card> bySuit = Comparator.comparing(//sort by suit
            Card::getSuit,  //get the suit 
            (suit1, suit2) -> Integer.compare(getSuitRank(suit1), getSuitRank(suit2))//compare ranks
        );
        return bySuit.thenComparingInt(Card::getValue)
                     .compare(c1, c2); 
    }
}

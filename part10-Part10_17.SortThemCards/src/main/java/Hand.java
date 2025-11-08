
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victo
 */
public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        hand.stream()
                .forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(hand);
    }

    @Override
    public int compareTo(Hand o) {
        int otherSum = o.getSum();
        //(this < other) returns < 0
        return Integer.compare(this.getSum(), otherSum);
    }

    private int getSum() {
        return hand.stream()
                .mapToInt(Card::getValue)
                .sum();
    }
    
    public void sortBySuit() {
        Collections.sort(hand, new BySuitInValueOrder());
    }
}

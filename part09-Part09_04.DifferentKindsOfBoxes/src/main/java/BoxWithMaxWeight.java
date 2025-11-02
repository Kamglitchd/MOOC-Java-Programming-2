
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class BoxWithMaxWeight extends Box{
    private int maxWeight;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        maxWeight = capacity;
        items = new ArrayList<>();
    }
    
     private int getBoxWeight() {
        int boxWeight = 0;
        for (Item item : items) {
            boxWeight += item.getWeight();
        }
        return boxWeight;
    }

    @Override
    public void add(Item item) {
        if (item.getWeight() + this.getBoxWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if (this.items.contains(item)) {
            return true;
        }
        return false;
    }
}

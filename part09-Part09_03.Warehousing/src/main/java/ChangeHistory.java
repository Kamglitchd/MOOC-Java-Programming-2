
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
public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status){
        history.add(status);
    }
    
    public void clear(){
        history.clear();
    }

    public double maxValue(){
        return history.size() > 0? Collections.max(history): 0;
    }
    
    public double minValue(){
        return history.size() > 0? Collections.min(history): 0;
    }
    
    public double average(){
        double sum = 0;
        for (Double change : history) {
            sum += change;
        }
        return history.size() > 0? sum/history.size(): 0;
    }
    @Override
    public String toString() {
        return history.toString();
    }
    
    
}

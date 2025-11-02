/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class Container {
    private int amount;
    private final int MAX_LIQUID = 100;

    public Container() {
        amount = 0;
    }
    
    public int contains(){
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMAX_LIQUID() {
        return MAX_LIQUID;
    }
    
    public void add(int amount){
        if(this.contains() < MAX_LIQUID){
            this.amount += amount;
        }
        if (this.amount > MAX_LIQUID) {
            this.amount = MAX_LIQUID;
        }
    }
    
     public void remove(int amount){
       this.amount -= amount;
         if (this.amount < 0) {
             this.amount = 0 ;
         }
     }

    @Override
    public String toString() {
        return amount + "/" + MAX_LIQUID;
    }
     
}

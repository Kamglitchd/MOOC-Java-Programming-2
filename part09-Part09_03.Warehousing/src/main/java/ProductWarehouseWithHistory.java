/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory ch;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.ch = new ChangeHistory();
        ch.add(initialBalance);
    }
    
    public String history(){
        return ch.toString();
    }
    
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        ch.add(this.getBalance());
    }
    
    public double takeFromWarehouse(double amount){
        amount = super.takeFromWarehouse(amount);
        ch.add(this.getBalance());
        return amount;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + ch.maxValue());
        System.out.println("Smallest amount of product: " + ch.minValue());
        System.out.println("Average: " + ch.average());
    }
}

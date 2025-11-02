
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class Warehouse {
    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }
    
    
    public void addProduct(String product, int price, int stock){
        prices.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product){
        if (prices.containsKey(product)) {
            return prices.get(product);
        }else{
            return -99;
        }
    }
    
    public int stock(String product){
        if (stocks.containsKey(product)) {
            return stocks.get(product);
        }else{
            return 0;
        }
    }
    
    public boolean take(String product){
        boolean inStock = false;
        if (stocks.containsKey(product)) {
            int stock = stocks.get(product);
            inStock = stock > 0;
            if (inStock) {
                //stock--;
                stocks.put(product, --stock);
            }
        }
        return inStock;
    }
    
    public Set<String> products(){
        return prices.keySet();
    }
}

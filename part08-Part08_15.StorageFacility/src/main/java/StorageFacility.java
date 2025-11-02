
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class StorageFacility {
    HashMap<String, ArrayList<String>> units;
    
    public StorageFacility(){
        units = new HashMap<>();
    }
    
    public void add(String unit, String item){
        units.putIfAbsent(unit, new ArrayList<>());
        units.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String storageUnit){
        return units.getOrDefault(storageUnit, new ArrayList<>());
    }
    
    public void remove(String storageUnit, String item){
        
        if (units.get(storageUnit).isEmpty()) {
            this.units.remove(storageUnit);
        }
        units.get(storageUnit).remove(item);
        
    }
    
     public ArrayList<String> storageUnits() {
        ArrayList<String> storage = new ArrayList<>();

        for (String unit : units.keySet()) {
            if (!units.get(unit).isEmpty()) {
                storage.add(unit);
            }
        }
        return storage;
    }
}

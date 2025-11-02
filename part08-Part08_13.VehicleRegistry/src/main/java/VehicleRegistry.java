
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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    //String name;

    public VehicleRegistry() {
        this.registry = new HashMap<LicensePlate, String>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
         if (!this.registry.containsKey(licensePlate)) {
            this.registry.put(licensePlate, owner);
            return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate){
        return registry.get(licensePlate);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if (this.registry.containsKey(licensePlate)) {
            this.registry.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate plate : this.registry.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for (String owner : this.registry.values()) {
            if (owners.contains(owner)){
                continue;
            }
            System.out.println(owner);
            owners.add(owner);
        }
    }
}

/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: Airplane — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package FlightControl.domain;

public class Airplane {
    private String id;
    private int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getID() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return this.id + " (" + this.capacity + " capacity)";
    }
}

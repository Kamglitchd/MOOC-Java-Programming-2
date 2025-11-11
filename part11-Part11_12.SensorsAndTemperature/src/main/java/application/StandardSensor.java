/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: StandardSensor — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package application;

public class StandardSensor implements Sensor{

    private int num;

    public StandardSensor(int num) {
        this.num = num;
    }
    
    
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        
    }

    @Override
    public void setOff() {
     
    }

    @Override
    public int read() {
        return num;
    }
    
}

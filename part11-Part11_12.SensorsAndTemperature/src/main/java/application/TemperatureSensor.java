/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: TemperatureSensor — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean on;

    public TemperatureSensor() {
        this.on = false;
    }
    
    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setOn() {
        if (!on) {
            on = true;
        }
    }

    @Override
    public void setOff() {
        if (on) {
            on = false;
        }
    }

    @Override
    public int read() throws IllegalStateException {
        if (!on) {
            throw new IllegalStateException();
        }
        //int r = 61;
        int rand = new Random().nextInt(61);
        return rand - 30;
//        return new Random().nextInt(r + (-30));
//        return (int)(Math.random() * ((61) + (-30)));
    }

}

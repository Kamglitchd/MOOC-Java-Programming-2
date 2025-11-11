/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 11, 2025
 * 
 *   Description: AverageSensor — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */
package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> averages;

    public AverageSensor() {
        sensors = new ArrayList<>();
        averages = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean on = false;

        for (Sensor sensor : sensors) {
            if (sensor.isOn() == true) {
                on = true;
            } else {
                on = false;
                break;
            }
        }
        return on;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (!isOn() || sensors.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int average = (int) sensors.stream()
                .mapToInt(e -> e.read()) //map sensor to reading
                .average()
                .orElseThrow(() -> new IllegalStateException());

        averages.add(average);
        return average;
    }

    public List<Integer> readings(){
        return averages;
    }
}

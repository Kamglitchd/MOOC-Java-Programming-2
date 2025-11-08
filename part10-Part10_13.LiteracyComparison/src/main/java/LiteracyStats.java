
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class LiteracyStats {
    String sex;
    String country;
    int year;
    double rate;
    //ArrayList<String> stats;

    public LiteracyStats(String sex, String country, int year, double percent) {
        this.sex = sex;
        this.country = country;
        this.year = year;
        this.rate = percent;
        //this.stats = new ArrayList<>();
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return country + " (" + year + "), " + sex +", " + rate;
    }
    
    
    
}

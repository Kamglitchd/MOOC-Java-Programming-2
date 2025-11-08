/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class Books {
    String name;
    int ageRec;

    public Books(String name, int ageRec) {
        this.name = name;
        this.ageRec = ageRec;
    }

    public String getName() {
        return name;
    }

    public int getAgeRec() {
        return ageRec;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + ageRec + " year-olds or older)";
    }
    
    
}

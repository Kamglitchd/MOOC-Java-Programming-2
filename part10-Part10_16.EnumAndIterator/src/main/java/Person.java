/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victo
 */
public class Person {
    private String name;
    private Education ed;

    public Person(String name, Education ed) {
        this.name = name;
        this.ed = ed;
    }
    
    public Education getEducation(){
        return this.ed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(", ").append(ed);
        return sb.toString();
    }
    
    
}


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
public class TodoList {
    private ArrayList<String> list;
    
    public TodoList(){
        list = new ArrayList<>();
    }
    
    public void add(String task){
        list.add(task);
    }
    
    public void print(){
        int i = 1;
        for (String string : list) {
            System.out.println(i + ": " + string);
            i++;
        }
    }
    
    public void remove(int number){
        list.remove(number - 1);
    }
}

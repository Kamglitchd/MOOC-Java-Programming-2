
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victo
 */
public class Employees {

    ArrayList<Person> emp;

    public Employees() {
        emp = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        emp.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(person -> {
            emp.add(person);
        });
    }

    public void print() {
        // iterator for arraylist
        Iterator<Person> iterator = emp.iterator();

        //loop as long as there are elements left
        while (iterator.hasNext()) {
            Person person = iterator.next();//gets next person
            System.out.println(person);//prints person
        }
    }

    public void print(Education education) {
        // iterator for arraylist
        Iterator<Person> iterator = emp.iterator();

        while (iterator.hasNext()) {//loop
            Person person = iterator.next();

            if (person.getEducation() == education) {// check equality
                System.out.println(person);//print
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = emp.iterator();// iterator for arraylist
        while(iterator.hasNext()){
            Person person = iterator.next();
            if (person.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books> books = new ArrayList<>();
        
        while(true){
            System.out.println("Input the name of the book, empty stops: "); //asks for name
            String name = scanner.nextLine();//stores name in variable
            
            if (name.isBlank()) {//checks if there's anymore input and ends
                break;
            }
            System.out.println("Input the age recommendation: ");//asks for and stores age
            int age = Integer.valueOf(scanner.nextLine());
            System.out.println();
            
            books.add(new Books(name, age));//adds Books objet to collection
        }
        System.out.println(books.size() + " books in total.");
        System.out.println();
        
        System.out.println("Books:");
        
        Comparator<Books> comparator = Comparator
              .comparing(Books::getAgeRec)//compares by age then name
                .thenComparing(Books::getName);
        
        Collections.sort(books, comparator); //sorts
        books.stream().forEach(b -> System.out.println(b));
    }

}

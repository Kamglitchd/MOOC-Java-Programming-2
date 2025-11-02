
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList list = new TodoList();
        list.add("one");
        list.add("two");
        list.add("three");
        UserInterface ui = new UserInterface(list, scanner);
        ui.start();
        list.print();
    }
}

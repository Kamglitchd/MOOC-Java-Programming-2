
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victo
 */
public class UserInterface {

    private TodoList td;
    private Scanner scan;

    public UserInterface(TodoList td, Scanner scan) {
        this.td = td;
        this.scan = scan;
    }

    public void start() {

        while (true) {
            System.out.print("Command: ");
            System.out.flush();
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            if (input.equals("add")) {
                System.out.print("To add: ");
                System.out.flush();
                String add = scan.nextLine();
                td.add(add);
                continue;
            }
            if (input.equals("list")) {
                td.print();
                continue;
            }
            if (input.equals("remove")) {
                System.out.print("Which one is removed? ");
                System.out.flush();
                int rem = Integer.valueOf(scan.nextLine());
                td.remove(rem);
                continue;
            }
        }
    }
}

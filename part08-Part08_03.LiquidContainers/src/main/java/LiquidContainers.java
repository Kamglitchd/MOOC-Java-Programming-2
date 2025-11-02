
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;
        final int MAX_LIQUID = 100;

        while (true) {
            System.out.println("First: " + first + "/" + MAX_LIQUID);
            System.out.println("Second: " + second + "/" + MAX_LIQUID);
            System.out.flush();
            String input = scan.nextLine();
            System.out.println();
            if (input.equals("quit")) {
                break;
            }
             String[] parts = input.split(" ");
             String command = parts[0];
             int amount = Integer.valueOf(parts[1]);
            if (amount < 0) {
                continue;
            }
 
             if (command.equals("add")) {
                first += amount;
                 if (first > MAX_LIQUID) {
                     first = MAX_LIQUID;
                 }
            }else if (command.equals("move")) {
                 if (first < amount) {
                     amount = first;
                 }
                 second += amount;
                 first -= amount ;
                 if (second > MAX_LIQUID) {
                     second = MAX_LIQUID;
                 }
            }else if (command.equals("remove")) {
                second -= amount;
                 if (second < 0) {
                     second = 0;
                 }
            }
        }
    }

}

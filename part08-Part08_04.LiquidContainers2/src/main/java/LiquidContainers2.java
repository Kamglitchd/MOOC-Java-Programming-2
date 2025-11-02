
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container one = new Container();
        Container two = new Container();

        while (true) {
            System.out.println("First: " + one.contains() + "/"
                    + one.getMAX_LIQUID());
            System.out.println("Second: " + two.contains() + "/"
                    + two.getMAX_LIQUID());
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
                one.add(amount);
            } else if (command.equals("move")) {
                int move = Math.min(one.contains(), amount);
                one.remove(move);
                two.add(move);
            } else if (command.equals("remove")) {
                two.remove(amount);
            }
        }
    }

}

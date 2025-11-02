
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String posNum = "Cannot calculate the average";
        int sum = 0;
        double i = 0;
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            if (input > 0) {
                sum += input;
                i++;
            }
            double avg = sum / i;
            posNum = i > 0 ? String.valueOf(avg) : "Cannot calculate the average";

        }
        System.out.println(posNum);
    }
}

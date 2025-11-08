
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numList = new ArrayList<>();
        
        while(true){
            int input = scanner.nextInt();
            if (input < 0) {
                break;
            }
            numList.add(input);
        }
        numList.stream()
                .filter(n -> n <= 5 && n>= 1)
                .forEach(number -> System.out.println(number));
    }
}

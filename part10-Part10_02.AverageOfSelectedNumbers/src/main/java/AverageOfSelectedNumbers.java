
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>(); //Create collection for stream to work on

        System.out.println("Input numbers, type \"end\" to stop.");
        while(true){
            String input = scanner.nextLine();//reads numbers
            //Stops reading inputs and ends loop
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);//adds numbers to the list
        }
        System.out.println("Print the average of the negative numbers or "
                + "the positive numbers? (n/p)");
        //Saved answer as a char to make comparing slightly easier
        //Doesn't account for non-char inputs
        char ans = scanner.next().charAt(0);//saves answer as a char
        
        //filters positive numbers with stream and averages
        double aPos = inputs.stream()
                .mapToInt(p -> Integer.valueOf(p))
                .filter(num -> num > 0)
                .average()
                .getAsDouble();
        
        //filters negative numbers with stream and averages
        double aNeg = inputs.stream()
                .mapToInt(n -> Integer.valueOf(n))
                .filter(num -> num < 0)
                .average()
                .getAsDouble();
        
        //Doesn't account for answers that may not be n or p
        String output = (ans == 'p') 
                  ? "Average of the positive numbers: " + aPos 
                  : "Average of the negative numbers: " + aNeg;
        
        System.out.println(output);
    }
}

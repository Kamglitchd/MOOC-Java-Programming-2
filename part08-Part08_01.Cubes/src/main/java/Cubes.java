
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            String cube = scanner.nextLine();
            if (cube.equals("end")) {
                break;
            }
            int c = Integer.valueOf(cube);
            System.out.println(c * c * c);
        }
    }
}

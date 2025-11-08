
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<LiteracyStats> literacy = new ArrayList<>();
        String file = "literacy.csv";
        try{
            Files.lines(Paths.get(file))//reads file
                    .map(row -> row.split(",")) //splits by comma
                    .filter(parts -> parts.length >= 6)//makes sure there's enough data
                    .map(parts -> new LiteracyStats(parts[2].replace(" (%)", "").trim(),//remove percent
                            parts[3].trim(), Integer.valueOf(parts[4].trim()), 
                            Double.valueOf(parts[5].trim())))
                    .forEach(stat -> literacy.add(stat));//adds to list
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        literacy.stream().sorted((l1, l2) -> {
        return Double.compare(l1.getRate(), l2.getRate()) ;//compares double values
        }).forEach(l -> System.out.println(l));//prints each stat
    }
}

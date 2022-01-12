package AOCutil;
import java.io.BufferedReader;
import java.io.FileReader;

public class AOCutil {
    
    public static BufferedReader readFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            System.out.println("Error reading file " + fileName);
        }
        return br;
    }

}

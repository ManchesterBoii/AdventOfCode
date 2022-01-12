import java.io.BufferedReader;
import AOCutil.AOCutil;


public class day2 {

    public static void main(String[] args) {

        BufferedReader br = AOCutil.readFile("input2.txt");
        Integer Xpos = 0;
        Integer Depth = 0;
        Integer aim = 0;

        for (String line: br.lines().toArray(String[]::new)) {

            String command = line.split(" ")[0];
            int val = Integer.parseInt(line.split(" ")[1]);
            if (command.equals("up")) {
                aim -= val;
            }
            else if (command.equals("down")) {
                aim += val;
            }
            else if (command.equals("forward")) {
                Xpos += val;
                Depth += aim * val;
            }
            
        };
        int prod = Xpos * Depth;
        System.out.println(prod);
        

    }

  

    
    
}



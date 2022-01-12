import java.io.BufferedReader;
import java.io.FileReader;

public class day1{


    public static void main(String[] args){
        
        //input file
        String fileName = "input1.txt";
        String line = null;
        int next,  mid, increased = 0;
        int increased_sum = 0;
        int Windowsum = 0;
        int nextWindowsum =0;
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            int prev = Integer.parseInt(line);
            line = bufferedReader.readLine();
            mid = Integer.parseInt(line);
            if (mid > prev){
                increased++;
            }
            line = bufferedReader.readLine();
            next = Integer.parseInt(line);
            if(next > mid){
                increased++;
            }
            Windowsum = prev + mid + next;

            while((line = bufferedReader.readLine()) != null){
                prev = mid;
                mid = next;
                next = Integer.parseInt(line);
                if(next > mid){
                    increased++;
                }
                
                nextWindowsum = prev + mid + next;
                if(nextWindowsum > Windowsum){
                    increased_sum++;
                } 
                Windowsum = nextWindowsum;


            }
            bufferedReader.close();
        }
        catch(Exception e){
            System.out.println("Error reading file");
        }
        System.out.println("Part 1: Increased:" + increased );
        System.out.println("Part 2: Increased_Window:" + increased_sum );
       
    }


}
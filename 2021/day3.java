import java.io.BufferedReader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;


import AOCutil.AOCutil;

public class day3 {

    public static void main(String[] args) {

        BufferedReader file = AOCutil.readFile("input3.txt");

        String[] input = file.lines().toArray(String[]::new) ;

        Dictionary<Integer, int[]> dict = new Hashtable<Integer, int[]>();

        for(int i = 0; i < input[0].length(); i++){
            dict.put(i, new int[]{0,0});
            
        }
        

        for (String s : input) {
            int k = 0;

            for (String c: s.split("")) {

                int cd = Integer.parseInt(c);

                if (cd == 0) {
                    dict.get(k)[0]++;
                } else {
                    dict.get(k)[1]++;
                }

                k++;
                
            }

        }

        String result = "";
        String oppresult = "";


        for (Enumeration<Integer> e = dict.keys(); e.hasMoreElements();) {
            int key = e.nextElement();
            int[] value = dict.get(key);

            System.out.println(key + ": " + value[0] + " " + value[1]);


            if (value[0] > value[1]) {
                result = result + "0";
                oppresult = oppresult + "1";
            } else if (value[0] < value[1]) {
                result = result + "1";
                oppresult = oppresult + "0";
            } else {
                result += "X";
            }
        }

        System.out.println(result);

        System.out.println(oppresult);







        
        
    }
    
}

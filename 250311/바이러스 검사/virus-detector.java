import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        long answer = n;  //깃테스팅

        int [] narr = new int [n];
        String [] nline = br.readLine().split(" ");
        for (int i =0 ; i<n ; i++)
        {
            narr[i] = Integer.parseInt(nline[i]);
        }
        String [] twoline = br.readLine().split(" ");
        int king= Integer.parseInt(twoline[0]);
        float person= Integer.parseInt(twoline[1]);

        for (int val : narr)
        {
            answer += howmany(val-king,person); //test
        }

        bw.write(""+answer);
        bw.close();

     
    }

    public static long howmany (int target, float person)
    {  
          if (target <= 0) {
            return 0; 
            }
         return (long)Math.ceil(target/person);
    }
}
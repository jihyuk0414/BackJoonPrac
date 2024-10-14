import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] dp = new int [N+1];

        for (int i = 2; i<= N ; i++)
            {
                int dividethree = Integer.MAX_VALUE ; 
                int dividetwo = Integer.MAX_VALUE ; 

                if ((i/3 != 0) && (i%3 == 0))
                {
                    dividethree = dp[i/3];
                } 
                if ((i/2 != 0) && (i%2 == 0) )
                {
                    dividetwo = dp[i/2];
                }

                int compare = Math.min(dividethree,dividetwo);
                dp[i] = Math.min(compare,dp[i-1])+1;

            }

        bw.write(String.valueOf(dp[N]));
        bw.close();
    }
}
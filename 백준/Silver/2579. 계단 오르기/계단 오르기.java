import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] Narr = new int [N+1] ;

        for (int i= 1 ; i <= N ; i++)
            {
                Narr[i] = Integer.parseInt(br.readLine());
            }

        
        if (N==1)
        {
            bw.write(String.valueOf(Narr[1]));
            bw.close();
            return ; 
        }

        
        int [][] dp = new int [N+1][3]; 
        dp[1][1] = Narr[1];

        if (N >= 2) {
            dp[2][1] = Narr[2]; 
            dp[2][2] = Narr[1] + Narr[2]; 
        }
        
        for (int i = 2; i<= N; i++)
            {
                dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]);
                dp[i][1] = dp[i-1][0] + Narr[i] ;
                dp[i][2] = dp[i-1][1] + Narr[i];
            }


        bw.write(String.valueOf(Math.max(dp[N][1],dp[N][2])));
        bw.close();
        
    }
}
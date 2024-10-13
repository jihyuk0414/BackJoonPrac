import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] narr= new int [N+1][4];

        for (int i = 1 ; i<=N; i++)
            {
                String [] inputarr = br.readLine().split(" ");
                narr[i][1] = Integer.parseInt(inputarr[0]);
                narr[i][2] = Integer.parseInt(inputarr[1]);
                narr[i][3] = Integer.parseInt(inputarr[2]);
            }

        int [] [] dp = new int [N+1][4];

        dp[1][1] = narr[1][1];
        dp[1][2] = narr[1][2];
        dp[1][3] = narr[1][3];

        for (int i = 2 ; i<= N ; i++)
            {
                dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3])+narr[i][1];
                
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3])+narr[i][2];
                
                dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2])+narr[i][3];
            }

        int onetwo = Math.min(dp[N][1],dp[N][2]);
        bw.write(String.valueOf(Math.min(onetwo,dp[N][3])));
        bw.close();
    }
}
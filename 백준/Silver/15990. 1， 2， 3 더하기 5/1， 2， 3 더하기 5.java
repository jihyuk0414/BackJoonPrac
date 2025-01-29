import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [][] dp = new long [100001][4];
        dp[1][1] = 1; 
        dp[2][2] = 1;
        dp[3][1] =1;
        dp[3][2]= 1;
        dp[3][3] =1;
        long mod = 1000000009L;

        for (int i = 4; i<=100000; i++)
            {
    dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % mod;
    dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % mod;
    dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % mod;
            }

        int T = Integer.parseInt(br.readLine());

        for (int z = 0 ; z<T ; z++)
            {
                int x = Integer.parseInt(br.readLine());
                long ans = 0;
                for (int i = 1; i<=3; i++)
                    {
                        ans = (ans+dp[x][i])%mod;
                    }
                bw.write(ans+"\n");
            }
        
        bw.close();





    }
}
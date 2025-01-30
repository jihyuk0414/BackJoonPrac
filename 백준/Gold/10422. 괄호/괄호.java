import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        long [] dp = new long [5001];
        long mod = 1000000007;

        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i<=5000; i+=2)
            {
                for (int j = 0 ; j<i; j+=2)
                    {
                        dp[i] = (dp[i] + (dp[i-j-2]*dp[j]) %mod) %mod;
                    }
            }

        for (int z = 0; z<T ; z++)
            {
                int N = Integer.parseInt(br.readLine());
                if (N%2 !=0 )
                {
                    bw.write("0"+"\n");
                    continue;
                } else {
                    bw.write(String.valueOf(dp[N])+"\n");
                    continue;
                }
            }
        
        bw.close();





    }
}
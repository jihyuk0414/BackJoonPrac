import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long [] dp = new long [N+1];

        for (int i = 1; i<=N ; i++)
            {
                dp[i] = dp[i-1]+1;

                for (int j=3 ; j<i; j++)
                    {
                        dp[i] = Math.max(dp[i], dp[i-j]*(j-1));
                    }
            }
        bw.write(dp[N]+"");
        bw.close();
    }
}
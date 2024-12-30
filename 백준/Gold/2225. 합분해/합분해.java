import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N= Integer.parseInt(oneline[0]);
        int K= Integer.parseInt(oneline[1]);

        long [][] dp = new long [N+1][K+1];
        
        for(int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int j = 0 ;j<=K ; j++)
            {
                dp[0][j] = 1;
            }


        for(int i=1 ; i<=N ; i++)
            {
                for (int j = 2; j<=K ; j++)
                    {
                        dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000000;
                    }
            }

        bw.write(dp[N][K]+"");
        bw.close();
    }
}
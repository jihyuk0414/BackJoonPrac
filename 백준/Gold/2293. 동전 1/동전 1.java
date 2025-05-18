import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int K = Integer.parseInt(oneline[1]);
        int [] dp = new int[K+1];
        dp[0] = 1;

        int [] Narr = new int[N];

        for (int i = 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(br.readLine());
            }

        for (int coin : Narr)
            {
                for (int i = coin ; i<= K; i++)
                    {
                        dp[i] += dp[i-coin];
                    }
            }

        bw.write(String.valueOf(dp[K]));
        bw.close();
        
    }
}
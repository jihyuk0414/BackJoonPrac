import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long [][] dp = new long [N+1][10];

        for (int i = 0 ; i<= 9 ; i++)
            {
                dp[1][i] = 1;
            }

        int mod = 10007;

        for (int i = 2; i<=N ; i++)
            {
                for (int j = 0; j<= 9; j++)
                    {
                        for (int k = 0 ; k<=j; k++)
                            {
                                dp[i][j] = (dp[i][j]+dp[i-1][k])%mod;
                            }
                    }
            }

        long answer= 0 ;

        for (int i = 0 ; i<= 9 ; i++)
            {
                answer = (answer +dp[N][i])%mod;
            }

        bw.write(answer+"");
        bw.close();





    }
}
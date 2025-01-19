import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long [][] dp = new long [31][31];

        for (int i = 1; i<31 ; i++)
            {
                dp[i][0] = 1;
            }

        for (int i = 1; i<31 ; i++)
            {
                for (int j = 1 ; j<= i ; j++)
                    {
                        dp[i][j] = dp[i][j-1]+dp[i-1][j];
                    }
            }
        

        while (true)
            {
                int N = Integer.parseInt(br.readLine()) ;
                if(N == 0 )
                {
                    break;
                }
                bw.write(dp[N][N]+"\n");

            }
        bw.close();
    }
}
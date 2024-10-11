import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) ;

        long [][] originalArr = new long [N+1][N+1];
        long [][] dp = new long [N+1][N+1];

        for (int i = 1; i<=N ; i++)
            {
                String [] inputarr = br.readLine().split(" ");
                for (int j =1; j<=inputarr.length; j++)
                    {
                        originalArr[i][j] = Long.parseLong(inputarr[j-1]);
                    }
            }

        dp[1][1] = originalArr[1][1];

        for (int i = 2; i<= N ;i++)
            {
                for(int j = 1; j<=i ;j++)
                    {
                        if (j==1)
                        {
                            dp[i][j] = dp[i-1][j]+originalArr[i][j];
                        }

                        else if(j == i )
                        {
                            dp[i][j] = dp[i-1][j-1]+originalArr[i][j];
                        }

                        else
                        {
                            dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + originalArr[i][j] ;  
                        }
                    }
            }

        long answer = 0L ; 

        for (int i = 0 ; i<=N ; i++)
            {
                if (dp[N][i] > answer)
                {
                    answer = dp[N][i] ;
                }
            }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
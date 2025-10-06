import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] map = new int [N][N];
        int [][] dp = new int [N+1][N+1];

        int answer = Integer.MIN_VALUE;
        for (int i = 0 ; i<N; i++)
            {
                String [] oneline = br.readLine().split(" ");
                for (int j = 0 ; j<N; j++)
                    {
                        map[i][j] = Integer.parseInt(oneline[j]);
                        answer = Math.max(answer,map[i][j]);
                    }
            }

      for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i-1][j-1];
            }
        }

        for (int i = 1 ; i<=N; i++)
            {
                for (int j = 1 ;j<=N; j++)
                    {
                        int startx = i;
                        int starty = j;

                        for (int len = 0 ;len<=N; len++)
                            {
                                if(startx+len > N || starty+len >N)
                                {
                                    break;
                                }
                                int val = dp[startx+len][starty+len]-dp[startx-1][starty+len]-dp[startx+len][starty-1]+dp[startx-1][starty-1];
                                answer = Math.max(answer,val);
                            }
                    }
            }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
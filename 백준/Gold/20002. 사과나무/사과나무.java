import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] Narr= new int [N][N] ;

        for (int i = 0 ; i<N; i++)
            {
                String [] nline = br.readLine().split(" ");
                for(int j = 0 ; j<N ; j++)
                    {
                        Narr[i][j] = Integer.parseInt(nline[j]);
                    }
            }

        //dp 만들자
        int [][] dp = new int [N][N];

        dp [0][0] = Narr[0][0];
        for (int i = 1 ; i<N ; i++)
            {
                dp[i][0] = dp[i-1][0] + Narr[i][0];
                dp[0][i] = dp[0][i-1] + Narr[0][i];
            }

        for (int i = 1; i<N; i++)
            {
                for(int j = 1; j<N ; j++)
                    {
                        dp[i][j] = dp[i-1][j]+dp[i][j-1] -dp[i-1][j-1] +Narr[i][j];
                    }
            }

        int answer = Integer.MIN_VALUE;

        //K를 조정하고, 그 안에서 시작점의 값 중 최대를 구하자. 
        for (int k = 1 ; k<=N ; k++)
            {
                //i,j는 종료시점
                for (int i = k-1; i<N ; i++)
                    {
                        for(int j = k-1 ; j<N ; j++)
                            {   
                                int left = j-k >=0 ? dp[i][j-k] : 0;
                                int up = i-k >=0 ? dp[i-k][j] : 0 ;
                                int plus = ((i-k)>=0 && (j-k)>=0) ? dp[i-k][j-k] : 0 ;
                                answer = Math.max(answer, dp[i][j] - left - up + plus);
                            }
                    }
            }

        bw.write(String.valueOf(answer));
        

        bw.close();

        
    }
}
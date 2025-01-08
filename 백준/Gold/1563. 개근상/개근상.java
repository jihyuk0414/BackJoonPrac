import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,H; 
    static int [] down;
    static int [] up;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N=  Integer.parseInt(br.readLine());

        int [][][] dp = new int [N+1][3][2] ;// 날짜, 연속 결석, 지각 

        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp [1][0][1] =1;

        if(N == 1)
        {
            bw.write("3");
            bw.close();
            return;
        }

        for (int i = 1; i<N ; i++)
            {
                //다음날 출석, 결석 지각 0 <다시검사>
                dp[i+1][0][0] = (dp[i][0][0]+dp[i][1][0]+dp[i][2][0])%1000000;

                //다음날 지각1회 , 결석 0회
                dp[i+1][0][1] = (dp[i][1][1]+dp[i][2][1]+dp[i][0][0]+dp[i][1][0]+dp[i][2][0]+dp[i][0][1])%1000000;
                    
                //다음날 결석1 연속 , 지각 0 
                dp[i+1][1][0] = dp[i][0][0]%1000000;
  

                //다음날 결석 1연속, 지각 1
                dp[i+1][1][1] = dp[i][0][1]%1000000;

                              
                //다음날 결석 2연속, 지각 0
                dp[i+1][2][0] = dp[i][1][0]%1000000;

                //다음날 결석 2연속, 지각 1 
                dp[i+1][2][1] = dp[i][1][1]%1000000;
            
            }
        
        
        bw.write(String.valueOf(
            (dp[N][0][0]+dp[N][1][0]+dp[N][2][0]+dp[N][0][1]+dp[N][1][1]+dp[N][2][1])%1000000
        ));
        bw.close();
    }
  

}
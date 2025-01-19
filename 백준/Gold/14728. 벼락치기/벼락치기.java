import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int T  =Integer.parseInt(oneline[1]);

        int [] [] dp = new int [N+1][T+1];
        int [][] Narr = new int [N+1][2];

        for (int i = 0 ; i<N ; i++)
            {
                String [] nline = br.readLine().split(" ");
                Narr[i+1][0] = Integer.parseInt(nline[0]); //cost
                Narr[i+1][1] = Integer.parseInt(nline[1]); //획득 값
            }

        for (int i =1 ; i<= N ; i++)
            {
                for (int j = 0; j<=T; j++)
                    {
                        if (Narr[i][0] <= j)
                        {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-Narr[i][0]]+Narr[i][1]);
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
            }

        bw.write(dp[N][T]+"");
        bw.close();
    }

}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()) ;

        for (int x=0; x<T ; x++)
            {
                int N = Integer.parseInt(br.readLine()) ;

                long [] dp = new long[N+1];
                dp[1] =1 ;

                if(N>=2)
                {
                    dp[2] = 1;
                }
                for( int i = 3; i<=N ; i++)
                    {
                        dp[i] = dp[i-3]+dp[i-2] ;
                    }

                bw.write(String.valueOf(dp[N]));
                bw.write("\n");
            }
        bw.close();
        
    }
}
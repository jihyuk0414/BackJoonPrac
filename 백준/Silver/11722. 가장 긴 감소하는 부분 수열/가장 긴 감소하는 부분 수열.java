import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String [] oneline =br.readLine().split(" ");
        int[] narr = new int[N];

        for(int i = 0 ; i<N ; i++)
            {
                narr[i] = Integer.parseInt(oneline[i]);
            }

        int [] dp = new int[N];

        for(int i = 0 ; i<N ; i++)
            {
                for(int j = 0 ; j<i ; j++)
                    {
                        if(narr[i]<narr[j])
                        {
                            dp[i] = Math.max(dp[j]+1,dp[i]);
                        }
                    }
            }

        int answer = 0;

        for(int i = 0 ; i<N ; i++)
            {
                if(dp[i] > answer)
                {
                    answer=dp[i];
                }
            }

        bw.write(String.valueOf(answer+1));
        bw.close();
        
    }
}
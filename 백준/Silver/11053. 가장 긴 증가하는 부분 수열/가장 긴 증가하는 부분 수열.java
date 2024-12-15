import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String [] nstr = br.readLine().split(" ");
        int [] Narr = new int[N];

        for (int i = 0 ; i < N ; i++)
            {
                Narr[i] = Integer.parseInt(nstr[i]);
            }

        int [] dp = new int [N];
        dp[0] = 1;

        for (int i = 1; i< N; i++)
        {
            dp[i] = 1;

            for (int j = 0 ; j< i ; j++)
                {
                    if (Narr[i] > Narr[j])
                    {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
        }

        int answer = 0 ;

        for (int i = 0 ; i < N ; i++)
            {
                answer = Math.max(answer, dp[i]);
            }
        bw.write(String.valueOf(answer));
        bw.close();
    }

}
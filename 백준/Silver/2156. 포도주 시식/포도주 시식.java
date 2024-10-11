import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()) ;

        int [] Narr = new int [N+1];

        for (int i = 1 ; i<=N ; i++)
            {
                Narr[i] = Integer.parseInt(br.readLine());
            }

        int [] dp = new int [N+1];

        dp[1] = Narr[1];

        if (N>=2)
        {
            dp[2] = Narr[1]+Narr[2];
        }

        for (int i =3 ; i<=N ;i++)
            {
                dp [i] = Math.max(dp[i-1],Math.max(dp[i-2]+ Narr[i],dp[i-3]+Narr[i-1]+ Narr[i]));
            }

        int answer = 0 ;
        for (int i = 0 ; i<=N ; i++)
            {
                answer = Math.max(answer,dp[i]);
            }

        System.out.print(answer);
    }
}
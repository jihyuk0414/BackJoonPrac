import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String [] oneline = br.readLine().split(" ");
        int [] Narr = new int [N+1];

        for (int i = 1; i<=N; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i-1]);
            }

        int [] dp = new int [N+1];

        for (int i = 1 ; i<=N ; i++)
            {
                dp[i] = Narr[i];
                //narr에는 i-1넣어야됨
                for (int j = 1; j< i ; j++)
                    {
                        dp[i] = Math.max(dp[i],dp[i-j]+Narr[j]);
                    }
            }
        bw.write(dp[N]+"");
        bw.close();





    }
}
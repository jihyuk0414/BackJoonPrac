import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        int [] dp = new int [N+1];
        
        dp[1] = 1;
        if(N>1)
        {
            dp[2] = 2;
        }

        for (int i =3 ; i<=N ; i++)
            {
                dp[i] = (dp[i-1]+dp[i-2])%10007;
            }

        bw.write(dp[N]+"");
        bw.close();

        
    }
}
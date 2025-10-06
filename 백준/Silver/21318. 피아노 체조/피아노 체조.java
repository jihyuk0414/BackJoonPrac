import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String [] oneline = br.readLine().split(" ");
        int [] Narr = new int [N];
        for (int i = 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i]);
            }

        int [] dp = new int [N];

        if(N >= 2)
        {
            dp[0] = Narr[0] > Narr[1] ? 1 : 0;
        }
        
        for (int i = 1 ; i<N; i++)
            {
                if (i == N-1)
                {
                    dp[i] = dp[i-1];
                    continue;
                }
                
                if(Narr[i] > Narr[i+1])
                {
                    dp[i] = dp[i-1]+1;
                }
                else{
                    dp[i] = dp[i-1];
                }
            }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<M; i++)
            {
                String [] twoline = br.readLine().split(" ");
                int a = Integer.parseInt(twoline[0])-1;
                int b = Integer.parseInt(twoline[1])-1;

                int localans = dp[b] - dp[a];
                if (a != N-1 && Narr[a] > Narr[a+1])
                {
                    localans += 1;
                }
                if (b != N-1 && Narr[b] > Narr[b+1])
                {
                    localans -= 1;
                }
                sb.append(String.valueOf(localans)+"\n");
            }
        bw.write(sb.toString());
        bw.close();
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr = new int[N+1];

        String [] twoline = br.readLine().split(" ");

        for (int i = 0 ; i<N ; i++)
            {
                Narr[i+1] = Integer.parseInt(twoline[i]);
            }

        //dp 만들자
        int [] dp = new int[N+1];

        // for (int i = 1; i< N ; i++)
        //     {
        //         dp[i] = Narr[i] > Narr[i+1] ? dp[i-1]+1 : dp[i-1];
        //     }

        for (int i = 1; i < N; i++) {
            // 현재 위치에서 다음 곡이 더 쉬운 경우
            dp[i+1] = dp[i] + (Narr[i] > Narr[i+1] ? 1 : 0);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0 ; i <Q ; i++)
            {
                String [] qline = br.readLine().split(" ");
                int x = Integer.parseInt(qline[0]);
                int y = Integer.parseInt(qline[1]);

                bw.write(String.valueOf(dp[y]-dp[x])+"\n");
            }
        bw.close();

        
    }
}
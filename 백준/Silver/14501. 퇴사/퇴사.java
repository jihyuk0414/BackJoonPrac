import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2]; // dp[N+1]까지 계산
        int[] Tarr = new int[N+1];
        int[] Parr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            String[] tline = br.readLine().split(" ");
            Tarr[i] = Integer.parseInt(tline[0]);
            Parr[i] = Integer.parseInt(tline[1]);
        }

        for (int i = 1; i <= N; i++) {
            if (i + Tarr[i] <= N + 1) { 
                dp[i + Tarr[i]] = Math.max(dp[i + Tarr[i]], dp[i] + Parr[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.print(dp[N + 1]); // 최종 답 출력
    }
}

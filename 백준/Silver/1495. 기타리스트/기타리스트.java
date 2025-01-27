import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nline = br.readLine().split(" ");
        int N = Integer.parseInt(nline[0]);
        int S = Integer.parseInt(nline[1]);
        int M = Integer.parseInt(nline[2]);
        
        String[] vline = br.readLine().split(" ");
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(vline[i]);
        }
        
        // dp[i][j]: i번째 곡을 연주할 때 볼륨 j가 가능한지 여부
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        
for (int i = 1; i <= N; i++) {  
    for (int j = 0; j <= M; j++) {
        if (dp[i-1][j]) {
            if (j-V[i-1]>=0) {
                dp[i][j-V[i-1]] = true;
            } 
            if (j+V[i-1]<=M) {
                dp[i][j+V[i-1]] = true;
            }
        }
    }
}
        
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
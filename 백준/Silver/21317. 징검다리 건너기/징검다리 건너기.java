import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] goone = new int[Math.max(4,N + 1)];
        int[] gotwo = new int[Math.max(4,N + 1)];
        
        for (int i = 1; i < N; i++) {
            String[] costline = br.readLine().split(" ");
            goone[i] = Integer.parseInt(costline[0]);
            gotwo[i] = Integer.parseInt(costline[1]);
        }
        
        int K = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[Math.max(4, N+1)][2];
        for (int i = 0; i <= N; i++) {
            dp[i][0]  = Integer.MAX_VALUE/2;
            dp[i][1]= Integer.MAX_VALUE/2;
        }
        
        dp[0][0]=0;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=0;
        dp[2][0]=goone[1];
        dp[3][0]=Math.min(dp[2][0]+goone[2],dp[1][0]+gotwo[1]);
        
        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][0]+goone[i-1],dp[i-2][0]+gotwo[i-2]);
            dp[i][1] = Math.min(dp[i-1][1]+goone[i-1],dp[i-2][1]+gotwo[i-2]);
            dp[i][1]= Math.min(dp[i][1],dp[i-3][0]+K);
        }
        
        int answer = Math.min(dp[N][0], dp[N][1]);
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}

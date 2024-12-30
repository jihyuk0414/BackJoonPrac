import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] tmap = new int[N+1];
        int[] pmap = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            String[] oneline = br.readLine().split(" ");
            tmap[i] = Integer.parseInt(oneline[0]);
            pmap[i] = Integer.parseInt(oneline[1]);
        }
        
        long[] dp = new long[N+2]; 
        
        for (int i = N; i >= 1; i--) {
            if (i + tmap[i] > N+1) {  
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], pmap[i] + dp[i+tmap[i]]);
            }
        }
        
        bw.write(dp[1]+"");
        bw.close();
    }
}
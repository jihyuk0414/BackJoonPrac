import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int K = Integer.parseInt(oneline[1]);

        int [] dp = new int [200001];

        for (int i = 1; i<= 2*K ; i++)
            {
                dp[i] = Integer.MAX_VALUE;
            }

        dp[N] = 0;

        boolean [] visited = new boolean[200001];
        int maxSize = 200000;


        Deque<Integer> q = new LinkedList<>(); 

        q.addFirst(N);
        visited[N] = true;
             
        while (!q.isEmpty()) {
            int now = q.poll();
    
            if (now * 2 < maxSize && !visited[now*2]) {
                q.addFirst(now*2);
                visited[now*2] = true;
                dp[now*2] = dp[now];  
            }

            if (now-1 >= 0 && !visited[now-1]) {
                q.addLast(now-1);
                visited[now-1] = true;
                dp[now-1] = dp[now] + 1;
            }
            if (now+1 < maxSize && !visited[now+1]) {
                q.addLast(now+1);
                visited[now+1] = true;
                dp[now+1] = dp[now] + 1;
            }

}

        bw.write(dp[K]+" ");
        bw.close();
    }
}
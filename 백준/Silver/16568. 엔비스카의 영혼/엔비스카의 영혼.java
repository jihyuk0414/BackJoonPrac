import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int a = Integer.parseInt(oneline[1]);
        int b = Integer.parseInt(oneline[2]);


        int [] dp = new int [N+1];

        for (int i =  0 ; i<=N;i++)
            {
                dp[i] = Integer.MAX_VALUE;
                
            }
        dp[0] = 0;

        for (int i = 1;  i<=N ; i++)
            {
                dp[i] = Math.min(dp[i-1]+1, dp[i]);

                if (i-a>0)
                {
                    dp[i] = Math.min(dp[i],dp[i-a-1]+1);
                }
                if (i-b>0)
                {
                    dp[i] = Math.min(dp[i], dp[i-b-1]+1);
                }
            }
        System.out.print(dp[N]);
    }
}

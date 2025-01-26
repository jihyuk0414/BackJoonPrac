import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];

        String[] Nline = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(Nline[i]);
        }
        int K = Integer.parseInt(br.readLine());

        int maxRange = 50001; 
        
        int [] dp = new int[maxRange];
        
        for (int i = 1; i<=50000; i++)
            {
                dp [i]  =Integer.MAX_VALUE;
                for (int j = 0 ; j<N; j++)
                    {
                        int nowval = Narr[j];

                        if (i-nowval >=0)
                        {
                            dp[i] = Math.min(dp[i],dp[i-nowval]+1);
                        }
                    }

                if (dp[i] > K)
                {
                    String name = (i%2 ==0 ? "holsoon" : "jjaksoon");
                    bw.write(name + " win at "+ i);
                    bw.close();
                    return;
                }
            }

    }
}

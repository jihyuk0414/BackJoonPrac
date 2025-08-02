    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
            String [] oneline = br.readLine().split(" ");
            int N = Integer.parseInt(oneline[0]);
            int K = Integer.parseInt(oneline[1]);
            int [] valvarr = new int [N];
            int [] weightarr = new int[N];
    
            for (int i = 0 ; i<N; i++)
                {
                        String [] twoline = br.readLine().split(" ");
                    int weight = Integer.parseInt(twoline[0]); 
                    int val = Integer.parseInt(twoline[1]); 
                    valvarr[i] = val;
                    weightarr[i] = weight;
                }

            int [][] dp = new int [N][K+1];

            for (int j = 0 ; j<=K; j++)
                {
                    if (j >= weightarr[0])
                    {
                        dp[0][j] = valvarr[0];
                    }
                }

            for (int i = 1; i<N; i++)
                {
                    for (int j = 0 ; j<=K; j++)
                        {
                            dp[i][j] = dp[i-1][j];

                            if (weightarr[i] <= j)
                            {
                                dp[i][j]= Math.max(dp[i][j],dp[i-1][j-weightarr[i]]+valvarr[i]);
                            }
                        }
                }

            bw.write(String.valueOf(dp[N-1][K]));
            bw.close();
        }
    }
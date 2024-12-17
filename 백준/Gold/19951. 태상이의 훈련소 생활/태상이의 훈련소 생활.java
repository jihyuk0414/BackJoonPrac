import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        String [] originalstr = br.readLine().split(" ");
        int [] Narr = new int [N+2];

        for (int i = 1; i<= N ; i++)
            {
                Narr[i] = Integer.parseInt(originalstr[i-1]);
            }

        int [] comparearr = new int[N+2];
        int [] dp = new int [N+2];

        for (int i = 0 ; i<M ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                
                int start = Integer.parseInt(twoline[0]);
                int end = Integer.parseInt(twoline[1]);
                int howmany = Integer.parseInt(twoline[2]);

                comparearr[start] += howmany;
                comparearr[end+1] += (-howmany);
            }

        for (int i = 1; i<= N ; i++)
            {
                dp[i] = dp[i-1]+comparearr[i];
            }

        for (int i = 1; i<= N ; i++)
            {
                Narr[i] += dp[i];
                bw.write(Narr[i]+" ");
            }
        bw.close();
    
    }
    
}
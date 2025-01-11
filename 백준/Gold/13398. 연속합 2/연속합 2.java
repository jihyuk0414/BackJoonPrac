import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr = new int [N];

        String [] nstrarr = br.readLine().split(" ");
        for (int i = 0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(nstrarr[i]);
            }

        int [] dp1 = new int [N];
        int [] dp2 = new int [N] ;
        int [] answerdp = new int [N];

        dp1[0] = Narr[0];
        for (int i = 1 ; i<N ; i++)
            {
                dp1[i] = Math.max(dp1[i-1]+Narr[i], Narr[i]);
            }

        dp2[N-1] = Narr[N-1];
        for (int i = N-2 ; i>=0; i--)
            {
                dp2[i] = Math.max(dp2[i+1]+Narr[i], Narr[i]);
            }

        for (int i = 1 ; i<N-1 ; i++)
            {
                answerdp[i] = dp1[i-1]+dp2[i+1] ;
            }

        int answer = dp1[0];
        for (int i = 1; i < N; i++) {
            answer = Math.max(answer, dp1[i]);
        }

        
         for (int i = 1; i < N-1; i++) {
            int removed = dp1[i-1] + dp2[i+1];
            answer = Math.max(answer, removed);
        }

            bw.write(String.valueOf(answer));
        bw.close();





    }

}
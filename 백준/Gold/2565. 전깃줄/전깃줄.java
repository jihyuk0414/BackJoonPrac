import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] [] narr = new int [N][2];

        for (int i = 0 ; i<N ; i++)
            {
                String [] inputstr = br.readLine().split(" ");
                narr[i][0] = Integer.parseInt(inputstr[0]);
                narr[i][1] = Integer.parseInt(inputstr[1]);
            }

        Arrays.sort(narr, (a,b)-> Integer.compare(a[0],b[0]));
        int [] dp = new int [N] ;

        for (int i = 0; i<N ; i++)
            {

                dp[i] = 1 ;

                for (int j = 0; j<i ; j++)
                    {
                        if (narr[i][1] > narr[j][1])
                        {
                            dp [i] = Math.max(dp[i],dp[j]+1);
                        }
                    }
            }

        int oklist = 0 ;
        for (int i = 0 ; i<N ; i++)
            {
                oklist = Math.max(oklist,dp[i]);
            }
        
        bw.write(String.valueOf(N-oklist));
        bw.close();
    }
}
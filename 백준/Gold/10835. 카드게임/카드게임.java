import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N; 
    static int [] left;
    static int [] right;
    static int [] [] dp ;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        left = new int [N];
        right = new int [N];
        dp = new int [N][N];
        

        String [] leftline = br.readLine().split(" ");
        String [] rightline = br.readLine().split(" ");

        for (int i = 0 ; i<N ; i++)
            {
                left [i] =Integer.parseInt(leftline[i]);
                right[i] = Integer.parseInt(rightline[i]);
            }

        for (int i = 0 ; i<N; i++)
            {
                for (int j = 0 ; j<N; j++)
                    {
                        dp[i][j] = -1;
                    }
            }

        bw.write(String.valueOf(dojob(0,0)));
        bw.close();
    }

    static int dojob(int leftindex, int rightindex)
    {
        if (leftindex== N || rightindex== N)
        {
            return 0;
        }

        if (dp[leftindex][rightindex] != -1)
        {
            return dp[leftindex][rightindex];
        }

         dp[leftindex][rightindex] = Math.max(dojob(leftindex+1,rightindex+1), dojob(leftindex+1,rightindex));

        if(left[leftindex] > right[rightindex])
            dp[leftindex][rightindex] = Math.max(dp[leftindex][rightindex], dojob(leftindex, rightindex+1) + right[rightindex]);

        return dp[leftindex][rightindex];
    }

}
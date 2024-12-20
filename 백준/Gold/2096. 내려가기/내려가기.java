import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] Narr = new int [N][3];

        int [][] maxdp = new int[N][3];
        int [][] mindp = new int[N][3];

        for (int i = 0 ; i<N ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                for (int j = 0; j < 3; j++)
                    {
                        Narr[i][j] = Integer.parseInt(oneline[j]);
                    }
            }

        maxdp[0][0] = Narr[0][0];
        maxdp[0][1] = Narr[0][1];
        maxdp[0][2] = Narr[0][2];

        mindp[0][0] = Narr[0][0];
        mindp[0][1] = Narr[0][1];
        mindp[0][2] = Narr[0][2];

        for (int i =1 ; i <N ; i++)
            {
                maxdp[i][0] = Math.max(maxdp[i-1][0],maxdp[i-1][1])+Narr[i][0];
                mindp[i][0] = Math.min(mindp[i-1][0],mindp[i-1][1])+Narr[i][0];

                int max2val = Math.max(maxdp[i-1][0],maxdp[i-1][1]);
                max2val = Math.max(max2val, maxdp[i-1][2]);
                maxdp[i][1] = max2val + Narr[i][1];

                int min2val = Math.min(mindp[i-1][0],mindp[i-1][1]);
                min2val = Math.min(min2val, mindp[i-1][2]);
                mindp[i][1] = min2val + Narr[i][1];
                

                maxdp[i][2] = Math.max(maxdp[i-1][1],maxdp[i-1][2])+Narr[i][2];
                mindp[i][2] = Math.min(mindp[i-1][1],mindp[i-1][2])+Narr[i][2];
            }

        int maxans = Integer.MIN_VALUE;
        int minans = Integer.MAX_VALUE;

        for (int i = 0 ; i<3 ; i++)
            {
                maxans = Math.max(maxans, maxdp[N-1][i]);
                minans = Math.min(minans, mindp[N-1][i]);
            }

        bw.write(String.valueOf(maxans)+ " " + String.valueOf(minans));
        bw.close();
        
    }

}

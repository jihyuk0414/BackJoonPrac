import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputlist = br.readLine().split(" ");
        int N = Integer.parseInt(inputlist[0]);
        int M = Integer.parseInt(inputlist[1]) ; 

        int [][] Nlist = new int [N][M];

        for (int i = 0 ; i<N; i++)
            {
                String [] inputNlist = br.readLine().split(" ");
                for (int j = 0 ; j<M; j++)
                    {
                        Nlist[i][j] = Integer.parseInt(inputNlist[j]);
                    }
            }

        long answer = 0 ; 

        //위아래
        answer += ((N*M)*2);


        //옆
        for (int i = 0 ; i<N ; i++)
            {
                int rightsum = Nlist[i][0];

                for (int j = 1 ; j <M ; j++)
                    {
                        rightsum += Math.abs(Nlist[i][j] - Nlist[i][j-1]);
                    }
                rightsum += Nlist[i][M-1];
                answer += rightsum;
            }

        //상하
        for (int i = 0 ; i<N ; i++)
            {  
                int rightsum = 0;
                if (i == 0 )
                {
                    for(int j = 0 ; j<M; j++)
                        {
                            rightsum += Nlist[i][j];
                        }

                    answer += rightsum;
                    continue;
                }
                for (int j = 0 ; j <M ; j++)
                    {
                        rightsum += Math.abs(Nlist[i][j] - Nlist[i-1][j]);
                    }
                answer += rightsum;
            }

        for (int i = 0; i< M; i++)
            {
                answer += Nlist[N-1][i];
            }

        bw.write(String.valueOf(answer));
        bw.close();
        
    }
}
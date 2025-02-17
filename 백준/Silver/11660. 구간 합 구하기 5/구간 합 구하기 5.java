import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");

        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        int [][] originmap = new int [N+1][N+1];

        for (int i = 0 ; i<N ; i++)
            {
                String [] nline = br.readLine().split(" ");
                for (int j =0  ; j<N; j++)
                    {
                        originmap[i+1][j+1] = Integer.parseInt((nline[j]));
                    }
            }

        int [][] map = new int [N+1][N+1];
        map[1][1] = originmap[1][1];

        
        for (int i = 1 ; i<=N ; i++)
            {
                map[i][0] = map[i-1][0]+originmap[i][0];
            }

        for (int i = 1; i<=N; i++)
            {
                map[0][i]= map[0][i-1]+originmap[i][0];
            }

        for (int i = 1 ; i<=N; i++)
            {
                for (int j =1 ; j<=N; j++)
                    {
                        map[i][j] = map[i-1][j] +map[i][j-1]-map[i-1][j-1]+originmap[i][j];
                    }
            }

        for (int z= 0 ; z<M ; z++)
            {
                String [] mline = br.readLine().split(" ");
                int x1 = Integer.parseInt((mline[0]));
                int y1 = Integer.parseInt((mline[1]));
                int x2 = Integer.parseInt((mline[2]));
                int y2 = Integer.parseInt((mline[3]));

                int val = map[x2][y2]-map[x2][y1-1]-map[x1-1][y2]+map[x1-1][y1-1];
                bw.write(String.valueOf(val)+"\n");
            }
        
        bw.close();
        
    
    }
}
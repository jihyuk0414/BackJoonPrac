import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);
        int R = Integer.parseInt(oneline[2]);
        int [] [] map = new int [N][M];

        for (int i = 0 ; i<N ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                for (int j = 0 ; j<M ; j++)
                    {
                        map[i][j] = Integer.parseInt(twoline[j]);
                    }
            }

        for (int i = 0 ; i<R ; i++)
            {
                for (int j = 0 ; j<Math.min(N,M)/2 ; j++)
                    {
                        int save = map[j][j];

                        //왼쪽으로
                        for (int z = j; z<M-j-1 ; z++)
                             {
                                map[j][z] = map[j][z+1];
                             }

                        //위로
                        for (int z = j; z<N-j-1 ; z++)
                             {
                                map[z][M-j-1] = map[z+1][M-j-1];
                             }

                        //오른쪽으로
                        for (int z = M-j-1; z>j ; z--)
                             {
                                map[N-j-1][z] = map[N-j-1][z-1];
                             }

                        //아래로 
                        for (int z = N-j-1; z>j ; z--)
                             {
                                map[z][j] = map[z-1][j];
                             }

                        map[j+1][j] = save;

                        
                    }
            }

        for(int i =0 ; i<N ; i++)
            {
                for(int j = 0 ; j<M ;j++)
                    {
                        bw.write(String.valueOf(map[i][j])+" ");
                    }
                bw.write("\n");
            }
        bw.close();


    }



    
}
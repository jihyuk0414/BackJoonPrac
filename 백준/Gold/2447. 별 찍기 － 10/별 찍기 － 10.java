import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static char [] [] map ;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        makestart(N,0,0,N-1,N-1);

        for (int i = 0 ; i<N ; i++)
            {
                for(int j = 0 ;j <N ; j++)
                    {
                        bw.write(map[i][j]);
                    }
                bw.write("\n");
            }
        bw.close();
        
    }

    public static void makestart(int N, int startx, int starty, int endx, int endy)
    {

        if (N == 3)
        {
            for(int i = startx ; i<= endx; i++)
                {
                    for (int j = starty ; j <= endy ; j++)
                        {
                            if (i == (startx+endx)/2 && j == (starty+endy)/2)
                            {
                                continue;
                            }
                                map[i][j] = '*';
                        }
                }
            return;
        }

        int next = N/3;

        //가로 첫줄
        makestart(N/3,startx,starty,startx+next-1,starty+next-1);
        makestart(N/3,startx,starty+next,startx+next-1,starty+next*2-1);
        makestart(N/3,startx,starty+next*2,startx+next,endy);
        
        makestart(N/3,startx+next,starty,startx+next*2-1,starty+next-1);
        makestart(N/3,startx+next,starty+next*2,startx+next*2-1,endy);

        makestart(N/3,startx+next*2,starty,endx,starty+next-1);
        makestart(N/3,startx+next*2,starty+next,endx,starty+next*2-1);
        makestart(N/3,startx+next*2,starty+next*2,endx,endy);
        
    }

}
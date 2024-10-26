import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ;
    static int [] [] Narr;
    static int zerocnt = 0;
    static int onecnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Narr = new int[N+1][N+1];

        for (int i = 1; i<=N ; i++)
            {
                String [] inputarr = br.readLine().split(" ");
                for (int j = 0 ; j<N ;j++)
                    {
                        Narr[i][j+1] = Integer.parseInt(inputarr[j]);
                    }
            }
        divide(1,N,1,N);
        bw.write(String.valueOf(zerocnt)+"\n");
        bw.write(String.valueOf(onecnt));
        bw.close();
    }

    public static void divide(int startx, int endx, int starty, int endy)
    {
        int firstnum = Narr[startx][starty];

        for (int i = startx; i<=endx; i++)
            {
                for (int j = starty; j<=endy;j++)
                    {
                        if (firstnum!= Narr[i][j])
                        {
                            //다르다면?탈출
                            int midx = (startx+endx)/2;
                            int midy = (starty+endy)/2;

                            divide(startx,midx,starty,midy);
                            divide(midx+1,endx,starty,midy);
                            divide(startx,midx,midy+1,endy);
                            divide(midx+1,endx,midy+1,endy);
                            return;
                        }
                    }
            }
        if (firstnum == 0)
        {
            zerocnt+=1;
        } else {
            onecnt+=1;
        }
    }

    

    
}
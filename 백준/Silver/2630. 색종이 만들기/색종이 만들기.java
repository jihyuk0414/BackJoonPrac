import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int onecnt = 0 ;
    static int zerocnt = 0 ;
    static int [][] map;
    static int [] answer = new int [2];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int [N][N];

        for (int i = 0 ; i<N ; i++)
            {
                String [] Nline = br.readLine().split(" ");
                for (int j = 0 ; j<N ; j++)
                    {
                        map[i][j] = Integer.parseInt(Nline[j]);
                    }
            }

        divide_conquer(0,0,N-1,N-1,N);

        bw.write(String.valueOf(answer[0])+"\n");
        bw.write(String.valueOf(answer[1])+"\n");
        bw.close();
        
    }

    public static void divide_conquer(int xstart , int ystart, int xend, int yend, int N)
    {
        int startval = map[xstart][ystart];

        boolean isitok = true;
        for (int i = xstart ; i<=xend ;i++)
            {
                for (int j = ystart ; j <=yend; j++)
                    {
                        if (map[i][j] != startval)
                        {
                            isitok = false;
                            break;
                        }
                    }
            }

        if(isitok)
        {
            answer[startval]+=1;
        } else {
            divide_conquer(xstart,ystart,xstart+(N/2)-1, ystart+(N/2)-1,N/2);
            divide_conquer(xstart+(N/2),ystart,xend, ystart+(N/2)-1,N/2);
            divide_conquer(xstart,ystart+(N/2),xstart+(N/2)-1,yend,N/2);
            divide_conquer(xstart+(N/2), ystart+(N/2),xend,yend,N/2);
        }
    
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N ;
    static int [] [] map;
    static int [] [] answerarr;

    static int [] garox = {0,1};
    static int [] garoy = {1,1};
    static int [] serox = {1,1};
    static int [] seroy = {0,1};
    static int [] degagx = {1,0,1};
    static int [] degagy = {1,1,0};
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int [N][N];
        answerarr = new int [N][N];

        for (int i = 0 ; i<N ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                for (int j = 0 ; j<N; j++)
                    {
                        map[i][j] = Integer.parseInt(oneline[j]);
                    }
            }

        DFS(0,1,-1);

        bw.write(String.valueOf(answerarr[N-1][N-1]));
        bw.close();

    }

    public static void DFS(int x, int y, int status)
    {
        if (x == N-1 && y == N-1) {
        answerarr[N-1][N-1]++;
        return;
        }

        if (status == -1)
        {
            for (int i = 0; i<2; i++)
                {
                    int nx = x+garox[i];
                    int ny = y+garoy[i];

                    if (0<= nx && nx <N && 0<= ny && ny <N && map[nx][ny]!=1)
                    {
                        if (i == 1) { 
                            if (map[x+1][y] == 1 || map[x][y+1] == 1) continue;
                        }
                        DFS(nx,ny,status+i); // -1,0
                    }
                }
        } else if (status == 1)
        {
            for (int i = 0; i<2; i++)
                {
                    int nx = x+serox[i];
                    int ny = y+seroy[i];

                    if (0<= nx && nx <N && 0<= ny && ny <N && map[nx][ny]!=1)
                    {                        if (i == 1) { 
                            if (map[x+1][y] == 1 || map[x][y+1] == 1) continue;
                        }
                        DFS(nx,ny,status+i); // -1,0
                    }
                }
        } else {
            int nextstatus = 0;
            for (int i = 0; i<3; i++)
                {
                    if ( i== 1 )
                    {
                        nextstatus = -1;
                    } else if (i==2)
                    {
                        nextstatus = 1;
                    }
                    
                    int nx = x+degagx[i];
                    int ny = y+degagy[i];

                    if (0<= nx && nx <N && 0<= ny && ny <N && map[nx][ny]!=1)
                    {                        if (i == 0) { 
                            if (map[x+1][y] == 1 || map[x][y+1] == 1) continue;
                        }
                        DFS(nx,ny,nextstatus);
                    }
                }
        }
        
    }
}
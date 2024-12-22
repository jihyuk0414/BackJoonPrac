import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static char [][] map;
    static boolean [] [] visited;
    static int endx ;
    static int endy;
    static int answer = 0;
    static int R ;
    static int C; 
    static int K ;

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        R = Integer.parseInt(oneline[0]);
        C = Integer.parseInt(oneline[1]);
        K = Integer.parseInt(oneline[2]);

        map = new char[R][C];
        for (int i = 0 ; i<R ; i++)
            {
                String twoline = br.readLine() ;
                for (int j = 0 ; j<C ; j++)
                    {
                        map[i][j] = twoline.charAt(j);
                    }
            }
        visited = new boolean[R][C];

        endx = 0;
        endy = C-1;

        visited[R-1][0] = true;
        dfs(1,R-1,0);

        bw.write(String.valueOf(answer));
        bw.close();
        
    }

    public static void dfs(int depth, int nowx, int nowy)
    {
        if (depth == K)
        {
            if(nowx == endx && nowy== endy)
            {
                answer +=1;
            }
            return;
        }

        for (int i = 0 ; i<4 ; i++)
            {
                int nextx = nowx+dx[i];
                int nexty = nowy+dy[i];

                if(0<=nextx && nextx<R && 0<=nexty && nexty<C)
                {
                    if (map[nextx][nexty] != 'T' && !visited[nextx][nexty])
                    {
                        visited[nextx][nexty] = true;
                        dfs(depth+1,nextx,nexty);
                        visited[nextx][nexty] = false;
                    }
                }
            }
        return;
    }
}
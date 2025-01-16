import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N,M ;
    static int [][] map;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        map = new int [N][M];
        for (int u = 0; u<N ; u++)
            {
                String [] mapline = br.readLine().split(" ");
                for (int p = 0 ; p<M ; p++)
                    {
                        map[u][p] = Integer.parseInt(mapline[p]);
                    }
            }

        int answer = 0;

        while(!allzero())
            {
                
                boolean [][] visited = new boolean [N][M];

                int cnt = 0 ;
                
                for (int i = 0 ; i<N;  i++)
                {
                    for (int j = 0; j<M ; j++)
                    {
                        if (map[i][j] != 0 && !visited[i][j])
                        {
                            visited[i][j] = true;
                            find(i,j,visited);
                            cnt +=1;
                        }
                    }
                }

                if(cnt >=2)
                {
                    bw.write(String.valueOf(answer));
                    bw.close();
                    return;
                }

                //시간에 따라서 변경
                changenarr();
                //마지막엔 answer +=1;
                answer +=1;
            }

        bw.write("0");
        bw.close();

        
    }

    public static void changenarr()
    {
        int [][] temparr =new int [N][M];       
        
        for (int i = 0 ; i<N;  i++)
            {
                for (int j = 0; j<M ; j++)
                    {
                        if (map[i][j] != 0)
                        {
                            findzerocntdxdy(i,j,temparr);
                        }
                    }
            }

        for (int i = 0 ; i<N;  i++)
            {
                for (int j = 0; j<M ; j++)
                    {
                        if (map[i][j] != 0)
                        {
                            map[i][j] = Math.max(0,map[i][j]-temparr[i][j]);
                        }
                    }
            }
    }

    public static void findzerocntdxdy(int x, int y, int [][] temparr)
    {
        int cnt = 0 ;
        for (int i = 0 ; i<4 ; i++)
            {                 
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (0<=nx && nx<N && 0<=ny && ny<M)
                {
                    if (map[nx][ny] == 0 )
                    {
                        cnt +=1;
                    }
                }
            }
        temparr[x][y] = cnt;
    }

    public static boolean allzero()
    {
        for (int i = 0 ; i<N;  i++)
            {
                for (int j = 0; j<M ; j++)
                    {
                        if (map[i][j] != 0)
                        {
                            return false;
                        }
                    }
            }
        return true;
    }

    public static void find(int x , int y, boolean [][] visited)
    {
        for (int i = 0 ;i<4 ; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (0<=nx && nx<N && 0<=ny && ny<M)
                {
                    if(!visited[nx][ny] && map[nx][ny] !=0)
                    {
                        visited[nx][ny] = true; 
                        find(nx,ny,visited);
                    }
                }
            }
    }
}
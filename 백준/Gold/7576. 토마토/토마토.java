import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int N ;
    static int M ;
    static int [] [] map ;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");

        
        M = Integer.parseInt(oneline[0]);
        N = Integer.parseInt(oneline[1]);

        map = new int [N][M];
        visited=  new boolean[N][M];
        
        for (int i = 0 ; i<N ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                for(int j = 0 ; j<M ; j++)
                    {
                        map[i][j] = Integer.parseInt(twoline[j]);
                    }
            }

        Queue<int []> q = new LinkedList<>();

        //최초 depth 0
        for (int i = 0 ; i<N ; i++)
            {
                for(int j = 0 ; j<M ; j++)
                    {
                        if(map[i][j] == 1)
                        {
                            int [] firstq = {i,j,0};
                            q.add(firstq);
                        }
                    }
            }

        //다 익었나 검사로직필요
        if(check())
        {
            bw.write("0");
            bw.close();
            return;
        }

        int answer = 0 ;

        while(!q.isEmpty())
            {
                int [] nowq = q.poll();
                int x = nowq[0];
                int y= nowq[1];
                int depth = nowq[2];

                answer = Math.max(answer,depth);
                
                if (!visited[x][y] && map[x][y] == 1)
                {
                    visited[x][y] = true;
                    for (int i = 0 ; i<4 ; i++)
                        {
                            int nextx= x+dx[i];
                            int nexty= y+dy[i];
                            if(0<=nextx && nextx< N && 0<=nexty && nexty<M)
                            {
                                if(!visited[nextx][nexty] && map[nextx][nexty] ==0)
                                {
                                    map[nextx][nexty] = 1;
                                    int [] newq = {nextx,nexty,depth+1};
                                    q.add(newq);
                                }
                            }
                        }
                }
            }

        bw.write(check() ? String.valueOf(answer) : "-1");
        bw.close();

  
    }

    public static boolean check()
    {
        //안익은 토마토만 검사
        for (int i = 0 ; i<N ; i++)
            {
                for (int j = 0 ; j<M ; j++)
                    {
                        if(map[i][j] == 0)
                        {
                            return false;
                        }
                    }
            }
        return true;
    }


}
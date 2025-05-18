import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N,M;
    static int [][] graph;
    static int [][] beforegraph ;
    static int beforeanswer = 0 ; 
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);

        graph = new int[N][M];

        for (int i = 0 ; i<N; i++)
            {
                String [] twoline = br.readLine().split(" ");
                for (int j = 0 ; j<M; j++)
                    {
                        graph[i][j] = Integer.parseInt(twoline[j]);
                    }
            }

        int cnt = 0 ;

        while(true)
            {
                //녹이기전 치즈 형태
                int beforecheezecnt= 0 ; 
                for (int i = 0 ; i<N; i++)
                    {
                        for (int j = 0 ; j<M; j++)
                            {
                                if(graph[i][j] == 1 )
                                {
                                    beforecheezecnt +=1;
                                }
                            }
                    }

                //녹이고

                if(beforecheezecnt == 0 )
                {
                    //처음부터 0 이라면
                    break;
                }
                
                cnt +=1;

                dojob();

                //다 녹은게 0이라면  break, 이전 치즈 map 
                int cheezecnt= 0 ; 
                for (int i = 0 ; i<N; i++)
                    {
                        for (int j = 0 ; j<M; j++)
                            {
                                if(graph[i][j] == 1 )
                                {
                                    cheezecnt +=1;
                                }
                            }
                    }
                if(cheezecnt == 0 )
                {
                    beforeanswer = beforecheezecnt;
                    break;
                }

            }

        bw.write(String.valueOf(cnt)+"\n"+String.valueOf(beforeanswer));
        bw.close();
        
    }

    public static void dojob()
    {
        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean[N][M];
        visited[0][0] = true;
        int [] firstarr = new int [] {0,0};
        q.add(firstarr);

        while(!q.isEmpty())
            {
                int [] nowarr = q.poll();

                int x = nowarr[0];
                int y = nowarr[1];

                for (int i = 0 ; i<4; i++)
                    {
                        int nx = x+dx[i];
                        int ny = y+dy[i];

                        if (0<=nx && nx<N && 0<= ny && ny<M && !visited[nx][ny])
                        {
                            if (graph[nx][ny] == 0)
                            {
                                q.add(new int [] {nx,ny});
                                visited[nx][ny] = true;
                            } else {
                                graph[nx][ny] = 0;
                                visited[nx][ny] = true;
                            }
                        }

                    }

            }
    }
}
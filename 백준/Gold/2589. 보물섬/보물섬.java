import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static int N,M;
    static char [][] originmap;
    static boolean [][] visited ;
    static int answer = 0 ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);
        originmap = new char[N][M];

        for (int i = 0 ; i<N; i++)
            {
                String twoline = br.readLine();
                for (int j = 0 ; j<M; j++)
                    {
                        originmap[i][j] = twoline.charAt(j);
                    }
            }

        for (int i = 0 ; i<N; i++)
            {
                for (int j = 0 ; j<M; j++)
                    {
                        //map초기화 
                        char [][] map = originmap;
                        visited = new boolean[N][M];

                        if(map[i][j]=='L')
                        {
                            int localans = 0 ;
                            Queue<int []> q=  new LinkedList<>();
                            q.add(new int [] {i,j,0});
                            visited[i][j] = true;

                            while(!q.isEmpty())
                                {
                                    int [] now = q.poll();
                                    localans = Math.max(localans, now[2]);
                                    int x = now[0];
                                    int y = now[1];

                                    for (int z = 0; z<4 ; z++)
                                        {
                                            int nx = x+dx[z];
                                            int ny = y+dy[z];

                                            if(0<= nx && nx<N && 0<=ny && ny<M)
                                            {
                                                if(!visited[nx][ny] && map[nx][ny]== 'L')
                                                {
                                                    q.add(new int [] {nx,ny,now[2]+1});
                                                    visited[nx][ny] = true;
                                                }
                                            }
                                        }
                                }

                            answer = Math.max(answer,localans);
                        }
                    }
            }

        bw.write(String.valueOf(answer));
        bw.close();

        
    }
}
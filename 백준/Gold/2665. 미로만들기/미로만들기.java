import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [][] map = new int [N][N];
        boolean[][] visited=  new boolean[N][N];

        for (int i = 0 ; i<N; i++)
            {
                String oneline = br.readLine();
                for (int j = 0 ; j<N; j++)
                    {
                        map[i][j] = Character.getNumericValue(oneline.charAt(j));
                    }
            }

        Deque<int []> q = new ArrayDeque<>(); //x,y,cnt

        int answer = Integer.MAX_VALUE ;
        q.addFirst(new int [] {0,0,0});
        visited[0][0] = true;

        while(!q.isEmpty())
            {
                int [] nowarr = q.poll();

                int x = nowarr[0];
                int y = nowarr[1];
                int cnt = nowarr[2];

                if (x == (N-1) && y == (N-1))
                {
                    answer = Math.min(answer,cnt);
                    continue;
                }

                for (int i = 0 ;i<4; i++)
                    {
                        int nx = x+dx[i];
                        int ny = y+dy[i];

                        if ( 0<= nx && nx <N && 0<= ny && ny<N && !visited[nx][ny])
                        {
                            if (map[nx][ny] == 1)
                            {
                                q.addFirst(new int [] {nx,ny,cnt});
                            }
                            else{
                                q.addLast(new int [] {nx,ny,cnt+1});
                            }
                            visited[nx][ny] = true;
                        }

                    }
            }

        if (answer == Integer.MAX_VALUE)
        {
            answer=  0;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        int [][] map = new int [N][M];
        boolean [][] visited = new boolean[N][M];
        int [][] answermap = new int[N][M];

        Queue<int []> q = new LinkedList<>();

        for (int i = 0 ; i<N ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                for(int j = 0 ; j<M; j++)
                    {
                        map[i][j] = Integer.parseInt(twoline[j]);
                        if(map[i][j] == 2 )
                        {
                            int [] newq = {i,j,0};
                            q.add(newq);
                        }
                    }
            }

        while(!q.isEmpty())
            {
                int [] oneq = q.poll();
                int x = oneq[0];
                int y = oneq[1];
                int depth = oneq[2];

                for (int i = 0 ; i<4 ; i++)
                    {
                        int nx = x+dx[i];
                        int ny = y+dy[i];

                        if(0<=nx && nx<N && 0<= ny && ny <M)
                        {
                            if(!visited[nx][ny] && map[nx][ny] == 1)
                            {
                                visited[nx][ny] = true;
                                answermap[nx][ny] = depth+1;
                                int [] newq = {nx,ny,depth+1};
                                q.add(newq);
                            }
                        }
                    }
            }

        for (int i = 0 ; i<N ; i++)
            {
                for (int j = 0 ; j<M; j++)
                    {
                        if(!visited[i][j] && map[i][j]==1)
                        {
                            answermap[i][j] = -1;
                        }
                    }
            }

        for (int i = 0 ; i<N ; i++)
            {
                for (int j = 0 ; j<M; j++)
                    {
                        bw.write(String.valueOf(answermap[i][j])+ " ");
                    }
                bw.write("\n");
            }
        bw.close();

    }

    
}
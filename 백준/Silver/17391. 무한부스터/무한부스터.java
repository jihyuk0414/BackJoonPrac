import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] nline=  br.readLine().split(" ");
        int N = Integer.parseInt(nline[0]);
        int M = Integer.parseInt(nline[1]);

        int [][] map = new int [N][M];

        for (int i = 0 ; i<N; i++)
            {
                String [] nmline = br.readLine().split(" ");
                for (int j = 0 ; j<M; j++)
                    {
                        map[i][j] = Integer.parseInt(nmline[j]);
                    }
            }

        int [] dx = {0,1};
        int [] dy = {1,0};

        boolean [][] visited= new boolean[N][M];

        Queue<int [] > q = new LinkedList<>();
        int [] firsstarr = new int[]{0,0,map[0][0],0}; //x,y,갖고있는 boost수, 닿은 수
        visited[0][0] = true;
        q.add(firsstarr);

        while(!q.isEmpty())
            {
                int [] now = q.poll();
                int a = now[0];
                int b = now[1];
                int cnt = now[2];
                int answercnt = now[3];

                if (a == (N-1) && b == (M-1))
                {
                    bw.write(answercnt+"");
                    bw.close();
                    return;
                }

                for (int i = 1; i<=cnt ; i++)
                    {
                        //부스터 수 만큼 갈 수 있음
                        for (int j = 0; j<=1;  j++)
                            {
                                int nx = a+dx[j]*i;
                                int ny = b+dy[j]*i;

                                if (0<= nx && nx <N && 0<=ny && ny<M)
                                {
                                    if(!visited[nx][ny])
                                    {
                                        visited[nx][ny] = true;
                                        int [] newarr = new int [] {nx,ny,map[nx][ny],answercnt+1};
                                        q.add(newarr);
                                    }
                                }
                            }
                    }
            }
    }
}
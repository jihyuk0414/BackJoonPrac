import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] intstr = br.readLine().split(" ");
        int N = Integer.parseInt(intstr[0]);
        int M = Integer.parseInt(intstr[1]);

        int [] [] nstr = new int [N][M];
        for (int i =0 ; i<N ; i++)
            {
                String onelinestr = br.readLine();
                for (int j = 0 ; j<M; j++)
                    {
                        nstr[i][j] = Integer.parseInt(String.valueOf(onelinestr.charAt(j)));
                    }
            }

        Queue<int[]> q = new LinkedList<>();
        int [] firststart = {0,0};
        q.add(firststart);

        int [] dx = {0,-1,0,1};
        int [] dy = {-1,0,1,0};

        boolean [][] visited = new boolean [N][M];
        visited[0][0] = true;

        while (!q.isEmpty())
            {
                int [] now = q.poll();
                int x = now[0];
                int y = now[1];

                for (int i = 0 ; i<4; i++)
                    {
                        int nx = x+dx[i];
                        int ny = y+dy[i];

                        if(0<=nx && nx<N && 0<=ny && ny< M && visited[nx][ny] == false )
                        {
                            //아직 안갔다
                            if (nstr[nx][ny] != 0)
                            {
                                nstr[nx][ny] = nstr[x][y]+1;
                                visited[nx][ny]= true;
                                int [] nxy = {nx,ny};
                                q.add(nxy);
                            }
                        }
                    }
            }
        System.out.println(nstr[N-1][M-1]);
        
    }

}
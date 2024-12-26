import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int M = Integer.parseInt(oneline[0]);
        int N = Integer.parseInt(oneline[1]);

        int [] [] map = new int [N+1][M+1];
        boolean [][] visited = new boolean [N+1][M+1];

        for (int i = 0; i<N ;i++)
            {
                String twoline = br.readLine();
                for (int j = 0 ; j<M ; j++)
                    {
                        map[i+1][j+1] = Character.getNumericValue(twoline.charAt(j));
                    }
            }

        Deque<int[]> q = new ArrayDeque<>();
        int [] firstarr = {1,1,0};
        visited[1][1] = true;
        q.add(firstarr);

        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        while(!q.isEmpty()){
            int [] firstq = q.pollFirst();
            int x = firstq[0];
            int y = firstq[1];
            int crush = firstq[2];

            if(x==N && y==M)
            {
                bw.write(String.valueOf(crush));
            }

            for (int i = 0; i<4; i++)
                {
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(1<=nx && nx<=N && 1<=ny && ny<=M)
                    {
                        if(!visited[nx][ny])
                        {
                            visited[nx][ny] = true;
                            if(map[nx][ny] == 0)
                            {
                                int [] nextq = {nx,ny,crush};
                                q.addFirst(nextq);
                            } else{
                                int [] nextq = {nx,ny,crush+1};
                                q.addLast(nextq);
                            }
                        }
                    }
                }
        }
        

        bw.close();
        
    }
}
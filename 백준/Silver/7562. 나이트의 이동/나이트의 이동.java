import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int [] dx = {-2,-1,1,2,2,1,-1,-2};
        int [] dy = {1,2,2,1,-1,-2,-2,-1};

        for (int z = 0 ; z<T ; z++)
            {
                int L = Integer.parseInt(br.readLine());
                String [] oneline = br.readLine().split(" ");
                int startx = Integer.parseInt(oneline[0]);
                int starty = Integer.parseInt(oneline[1]);

                String [] twoline = br.readLine().split(" ");
                int endx = Integer.parseInt(twoline[0]);
                int endy = Integer.parseInt(twoline[1]);

                Queue<int []> q = new LinkedList<>();
                int [] firstarr = {startx,starty, 0};
                q.add(firstarr);

                boolean[][] visited = new boolean[L][L];
                visited[startx][starty] = true;

                while(!q.isEmpty())
                    {
                        int [] firstq = q.poll();
                        int x = firstq[0];
                        int y = firstq[1];
                        int depth = firstq[2];

                        if(x == endx && y == endy)
                        {
                            bw.write(String.valueOf(depth)+"\n");
                            break;
                        }

                        for (int i = 0 ; i< 8; i++)
                            {
                                int nx = x+dx[i];
                                int ny = y+dy[i];

                                if(0<=nx && nx < L && 0<=ny && ny< L)
                                {
                                    if(!visited[nx][ny])
                                    {
                                        visited[nx][ny] = true;
                                        int [] newq = {nx,ny,depth+1};
                                        q.add(newq);
                                    }
                                }
                            }
                    }

            }
        bw.close();
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int startx,starty,d;
    static int [][] map;
    static int [] dx = new int [] {-1,0,1,0};
    static int [] dy = new int [] {0,1,0,-1};
    static boolean [][] visited;
    static int answer = 0 ;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);

        String [] twoline = br.readLine().split(" ");
        startx = Integer.parseInt(twoline[0]);
        starty = Integer.parseInt(twoline[1]);
        d = Integer.parseInt(twoline[2]);

        map = new int[N][M];
        visited=  new boolean [N][M];
        for (int i = 0 ;i<N; i++)
        {
            String [] threeline = br.readLine().split(" ");
            for (int j = 0 ; j<M; j++)
            {
                map[i][j] = Integer.parseInt(threeline[j]);
            }
        }

        int nowx = startx;
        int nowy = starty;

        while (true)
        {
            if (!visited[nowx][nowy] && map[nowx][nowy] == 0) {
                visited[nowx][nowy] = true;
                answer++;
            }

            boolean cleaned = false;
            
            for (int i = 0; i < 4; i++) {
                int newd = (d + 3) % 4;
                int newx = nowx + dx[newd];
                int newy = nowy + dy[newd];
                
                if (0 <= newx && newx < N && 0 <= newy && newy < M && 
                    !visited[newx][newy] && map[newx][newy] == 0) {
                    d = newd;
                    nowx = newx;
                    nowy = newy;
                    cleaned = true;
                    break;
                }
                d = newd;
            }
            
            
            if (!cleaned) {
                int backDir = (d + 2) % 4;
                int backx = nowx + dx[backDir];
                int backy = nowy + dy[backDir];
                
                if (0 <= backx && backx < N && 0 <= backy && backy < M && map[backx][backy] == 0) {
                    nowx = backx;
                    nowy = backy;
                } else {
                    break; 
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
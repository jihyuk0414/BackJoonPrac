import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static char [][] map;
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static int answer = Integer.MAX_VALUE;
    static int answerx = -1;
    static int answery = -1;

    public static void main (String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);

        map = new char[N][M];

        int redx =-1;
        int redy = -1;
        int bluex = -1;
        int bluey = -1;

        for (int i = 0 ; i<N; i++)
        {
            String nline = br.readLine();
            for (int j = 0 ; j<M; j++)
            {
                map[i][j] = nline.charAt(j);
                if( map[i][j] == 'R')
                {
                    redx = i;
                    redy = j;
                }

                if (map[i][j] == 'B')
                {
                    bluex = i;
                    bluey = j;
                }
            }
        }
        backtracking(redx,redy,bluex,bluey,0);

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        bw.write(answer+"");
        bw.close();
    }

    public static void backtracking (int redx , int redy , int bluex, int bluey, int depth)
    {
        if (depth >=10)
        {
            return;
        }

        if (map[redx][redy] == 'O')
        {
            if (map[bluex][bluey] != 'O')
            {
                answer = Math.min(answer,depth);
                return;
            } else {
                return; 
            }
        }

        //상하 좌우로 이동시키고, 해당 이동 후에 blue가 나가버리는지 검사해서 맞으면 return. 아니면 진행

        for (int i= 0 ; i<4; i++)
        {
            int rednextx = redx;
            int rednexty = redy;
            int bluenextx = bluex;
            int bluenexty = bluey;

            while (true)
            {
                //여기서는, 그냥 끝으로만 이동
                rednextx += dx[i];
                rednexty += dy[i];
                
                if (rednextx >= N || rednexty >= M || rednextx < 0 || rednexty <0 || map[rednextx][rednexty] == '#')
                {
                    rednextx -=dx[i];
                    rednexty -=dy[i];
                    break;
                }

                if (map[rednextx][rednexty] == 'O')
                {
                    break;
                }
            }

            while (true)
            {
                bluenextx +=dx[i];
                bluenexty +=dy[i];
                
                if (bluenextx >= N || bluenexty >= M || bluenextx < 0 || bluenexty <0 ||map[bluenextx][bluenexty] == '#')
                {
                    bluenextx -=dx[i];
                    bluenexty -=dy[i];
                    break;
                }

                if (map[bluenextx][bluenexty]== 'O')
                {
                    break;
                }
            }

            if (map[bluenextx][bluenexty] == 'O')
            {
                continue;
            }

            if (rednextx == bluenextx && rednexty == bluenexty) {
       
                int redDist = Math.abs(rednextx - redx) + Math.abs(rednexty - redy);
                int blueDist = Math.abs(bluenextx - bluex) + Math.abs(bluenexty - bluey);
        
                if (redDist > blueDist) {
                    rednextx -= dx[i];
                    rednexty -= dy[i];
                } else {
                 bluenextx -= dx[i];
                 bluenexty -= dy[i];
                }
            }
    
            if (rednextx != redx || rednexty != redy || bluenextx != bluex || bluenexty != bluey) {
                backtracking(rednextx, rednexty, bluenextx, bluenexty, depth + 1);
            }

        }


    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int [] dx = new int [] {0,0,-1,1};
    static int [] dy = new int [] {1,-1,0,0};
    static int N,M;
    public static int [][] map ;
    public static int nowx,nowy;
    public static StringBuilder sb = new StringBuilder();
    public static int top = 0, left = 0, right = 0, front = 0, back = 0, bottom = 0;
    public static int topidx = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String  [] oneline =br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);
        nowx = Integer.parseInt(oneline[2]);
        nowy = Integer.parseInt(oneline[3]);
        int k = Integer.parseInt(oneline[4]);

        map = new int [N][M];

        for (int i = 0 ; i<N; i++)
        {
            String [] nowarr = br.readLine().split(" ");
            for (int j = 0 ;j<M; j++)
            {
                map[i][j] = Integer.parseInt(nowarr[j]);
            }
        }

        map[nowx][nowy] = 0;
        String [] jobline = br.readLine().split(" ");

        //k번 작업
        for (int z = 0 ; z<k ; z++)
        {
            int nowjob = Integer.parseInt(jobline[z])-1;

            roll(nowjob);
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void roll(int nowjob)
    {
        int nextx = nowx+dx[nowjob];
        int nexty = nowy+dy[nowjob];

        if (nextx<0 || nextx>= N || nexty <0 || nexty>=M)
        {
            //넘어가면 무시
            return;
        }

        int mapval = map[nextx][nexty]; //주사위가 닿은 칸 값
        
        //next,nowxy는 주사위의 (위치)
  
        //다이스 굴리기해야됨
        onlydice(nowjob);

        if (mapval == 0 )
        {
            map[nextx][nexty] = bottom;
        } else {
            bottom = map[nextx][nexty];
            map[nextx][nexty] = 0;
        }

        nowx = nextx;
        nowy = nexty;

        sb.append(top +"\n");
        //위 거 출력 ()

    }

    public static void onlydice(int nowjob)
    {
        //0이 오른족 1이 왼쪽 2가 위 3이 아래
        if (nowjob == 0)
        {
            int temp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = temp;
        } else if (nowjob == 1 )
        {
            int temp = top;
            top = right;
            right = bottom;
            bottom = left; 
            left = temp;
        } else if (nowjob ==2)
        {
            int temp = top;
            top = front;
            front = bottom;
            bottom = back;
            back = temp;
        } else {
            int temp = top;
            top = back;
            back = bottom;
            bottom = front;
            front = temp;
        }
    }
}
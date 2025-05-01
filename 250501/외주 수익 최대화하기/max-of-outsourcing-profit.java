import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<int []> Nlist = new LinkedList<>();
    static boolean [] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Nlist.add(new int [] {0,0,0});
        for (int i = 1; i<=N; i++)
        {
            String [] oneline = br.readLine().split(" ");
            int start = i;
            int end = start+Integer.parseInt(oneline[0])-1;
            int cost = Integer.parseInt(oneline[1]);

            int [] newarr = new int[3];
            newarr[0] = start;
            newarr[1] = end;
            newarr[2] = cost;

            Nlist.add(newarr);
        }

        visited = new boolean[N+1];

        dojob(1,0,0);

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void dojob(int depth, int cnt, int nowtime)
    {
        if (depth == N+1)
        {
            answer =Math.max(answer,cnt);
            return;
        }

        visited[depth] = true;

        int [] now = Nlist.get(depth);

        if(now[0] >= nowtime)
        {
            dojob(depth+1,cnt+now[2],now[1]);
        }

        dojob(depth+1,cnt,nowtime);

    }
}
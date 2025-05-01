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

        for (int i = 1 ; i<=N; i++)
        {
            visited[i] = true;
            dojob(0,i,Nlist.get(i)[2],Nlist.get(i)[1]);
            visited[i] = false;
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void dojob(int depth, int beforeidx, int cnt, int nowtime)
    {
        answer =Math.max(answer,cnt);
        // System.out.println("Depth : " + depth);
        // System.out.println("beforeidx : " + beforeidx);
        // System.out.println("cnt : " + cnt);
        // System.out.println("nowtime : " + nowtime);

        if (depth == N)
        {
            return;
        }

        for (int i = beforeidx+1; i<=N; i++)
        {
            int [] next = Nlist.get(i);
            if(visited[i] == false)
            {
                if (nowtime < next[0])
                {
                    visited[i] = true;
                    dojob(depth+1,i,cnt+next[2], next[1]);
                    visited[i] = false;
                } 
            }
        }
    }
}
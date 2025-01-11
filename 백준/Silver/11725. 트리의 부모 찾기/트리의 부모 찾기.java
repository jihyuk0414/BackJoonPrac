import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ; 
    static List<List<Integer>> Narr = new ArrayList<>();
    static int [] whoisdaddy ;
    static boolean[] visited ; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i<=N ; i++)
            {
                List<Integer> newlist=  new ArrayList<>();
                Narr.add(newlist);
            }

        whoisdaddy = new int [N+1];
        visited= new boolean[N+1];
        
        for (int i = 0 ; i<N-1;  i++)
            {
                String [] oneline = br.readLine().split(" ");
                int x = Integer.parseInt(oneline[0]);
                int y = Integer.parseInt(oneline[1]);

                Narr.get(x).add(y);
                Narr.get(y).add(x);
            }

        DFS(1,-1);

        for (int i = 2; i<=N ; i++)
            {
                bw.write(String.valueOf(whoisdaddy[i]) + "\n");
            }
        bw.close();
    }

    public static void DFS(int now, int father)
    {
        visited[now] = true;
        whoisdaddy[now] = father;

        for (Integer val : Narr.get(now))
            {
                if(!visited[val])
                {
                    DFS(val,now);
                }
            }
    }
}
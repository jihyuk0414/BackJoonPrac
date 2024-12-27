import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ; 
    static int [] [] narr ; 
    static boolean [] visited;
    static int answer = Integer.MIN_VALUE;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        narr = new int[N+1][N+1];
        visited = new boolean [N+1];

        for (int i = 0 ; i<N-1 ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                int a = Integer.parseInt(twoline[0]);
                int b = Integer.parseInt(twoline[1]);
                int val = Integer.parseInt(twoline[2]);
                narr[a][b]= val;
                narr[b][a]= val;
            }

        for (int i = 0 ; i<M ;i++)
            {
                String [] twoline = br.readLine().split(" ");
                int start = Integer.parseInt(twoline[0]);
                int end = Integer.parseInt(twoline[1]);
                visited[start] = true;
                DFS(start, end, 0);
                visited[start] = false;
            }
        bw.close();
    }

    public static void DFS(int start, int end , int cost) throws IOException
    {
        if(start == end)
        {
            bw.write(String.valueOf(cost)+"\n");
            return;
        }

        for (int i = 1; i<= N ; i++)
            {
                if (narr[start][i] != 0 && !visited[i])
                {
                    visited[i] = true;
                    DFS(i,end, cost+narr[start][i]);
                    visited[i] = false;
                }
            }
        return;

    }
}
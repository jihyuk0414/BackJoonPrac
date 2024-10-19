import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ;
    static String [] secondinput;
    static int findstart ;
    static int findend;
    static int M ;
    static int [][] narr ;
    static boolean [] visited;
    static int answer = -1 ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        secondinput = br.readLine().split(" ");
        findstart = Integer.parseInt(secondinput[0]);
        findend = Integer.parseInt(secondinput[1]);

        M = Integer.parseInt(br.readLine());

        narr = new int [N+1][N+1];

        visited = new boolean[N+1];
        visited[0] = true;

        for(int i =0 ; i<M; i++)
            {
                String[] narrinput = br.readLine().split(" ");
                int a = Integer.parseInt(narrinput[0]);
                int b = Integer.parseInt(narrinput[1]);

                narr[a][b] = 1;
                narr[b][a] = 1;
            }
        DFS(findstart,0);

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void DFS(int start,int depth)
    {
        //종단의 조건
        if (start == findend)
        {
            answer = depth;
        }
        for (int i =1 ; i<= N ; i++)
        {
            if (narr[start][i] ==1 & !visited[i] )
            {
                visited[i] = true;
                DFS(i,depth+1);
                visited[i] = false;
            }
        }

        
    }

    
}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static int M ;
    static List<Integer>[] Nlist; 
    static int answer = 0 ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        Nlist = new List[N+1];

        for (int i =0 ;i<N+1 ; i++)
            {
                Nlist[i]= new ArrayList<>();
            }

        for (int i = 0 ; i<M ; i++)
            {
                String [] secondline = br.readLine().split(" ");
                int x = Integer.parseInt(secondline[0]);
                int y = Integer.parseInt(secondline[1]);

                Nlist[x].add(y);
                Nlist[y].add(x);
            }

        boolean[] visited= new boolean[N+1];
        
        for (int i = 1; i<= N; i++)
            {
                if (!visited[i])
                {
                    DFS(i,visited);
                    answer+=1;
                }
            }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }

    public static void DFS(int startindex, boolean[] visited)
    {
        visited[startindex] = true;
        
        for (int nextindexgo : Nlist[startindex])
            {
                if (!visited[nextindexgo])
                {
                    DFS(nextindexgo,visited) ;
                }
            }
        return ;
    }
    
}
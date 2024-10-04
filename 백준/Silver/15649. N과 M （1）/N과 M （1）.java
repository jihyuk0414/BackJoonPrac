import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N ;
    static int M ;
    static boolean [] visited;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputstream = br.readLine().split(" ");

        N = Integer.parseInt(inputstream[0]);
        M = Integer.parseInt(inputstream[1]);

        visited= new boolean[N+1];
        DFS(0, ""); 

    }

    public static void DFS(int depth, String answer)
    {
        if (depth == M)
        {
            System.out.println(answer);
            return;
        }

        for (int i = 1; i<=N; i++)
            {
                if (visited[i] == false)
                {
                    visited[i]= true;
                    if (depth == 0)
                    {
                        DFS(depth+1,String.valueOf(i));
                    } else{
                        DFS(depth+1,answer+" "+i);
                    }

                    visited[i] = false;
                }
            }
    }
}
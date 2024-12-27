import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ; 
    static int [] originarr ;
    static boolean [] visited;
    static int answer = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        originarr = new int [N];
         String [] oneline = br.readLine().split(" ");
        for(int j = 0 ; j<N ; j++)
            {
                originarr[j] = Integer.parseInt(oneline[j]);
            }
        visited = new boolean[N];

        for (int i = 0 ; i<N ;i++)
            {
                List<Integer> newlist = new LinkedList<>();
                visited[i] = true;
                newlist.add(originarr[i]);
                
                DFS(1,newlist);
                
                visited[i] = false;
                
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void DFS(int depth, List<Integer> newlist)
    {
        if(depth==N)
        {
            int cnt = 0;
            for (int i = 1 ; i<N; i++)
                {
                    cnt += Math.abs(newlist.get(i)-newlist.get(i-1));
                }
            answer = Math.max(answer,cnt);
            return;
        }

        for (int i = 0 ; i<N ; i++)
            {
                if(!visited[i])
                {
                    visited[i] = true;
                    newlist.add(originarr[i]);
                    DFS(depth+1,newlist);
                    newlist.remove(newlist.size()-1);
                    visited[i] = false;
                }
            }
        return;
    }
}
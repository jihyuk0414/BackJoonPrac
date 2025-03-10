import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N,M;
    static int answer = Integer.MAX_VALUE;
    static int [][] map;
    static List<int[]> twolist = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        map = new int [N][N];

        int twocnt = 0;
        for (int i = 0 ; i<N; i++)
            {
                String [] oneline = br.readLine().split(" ");
                for (int j = 0 ; j<N; j++)
                    {
                        map[i][j] = Integer.parseInt(oneline[j]);
                        if(map[i][j] == 2)
                        {
                            twocnt +=1;
                            twolist.add(new int[] {i,j});
                        }
                    }
            }

        boolean [] visited = new boolean[twolist.size()];
        List<int []> safechicken = new ArrayList<>();
        DFS(visited,0,safechicken,0);

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void DFS(boolean[] visited, int depth, List<int []> safechicken, int start)
    {
        if (depth == M)
        {
            calcualte(safechicken);
            return;
        }

        for (int i = start; i< twolist.size(); i++)
            {
                if (!visited[i])
                {
                    int [] nowtwo = twolist.get(i);
                    visited[i] = true;
                    safechicken.add(nowtwo);
                    
                    DFS(visited,depth+1,safechicken,i+1);
                    
                    visited[i] = false;
                    safechicken.remove(safechicken.size()-1);
                }
            }
    }

    public static void calcualte(List<int []> safechicken)
    {
        int ans = 0;

              for (int i = 0 ; i<N; i++)
                    {
                        for (int j = 0 ; j<N; j++)
                            {
                                
                                int localans = Integer.MAX_VALUE;
                                if (map[i][j] ==1 )
                                {
                                            for (int [] twonow : safechicken)
                                            {
                                                int twox = twonow[0];
                                                int twoy = twonow[1];
          
                                                localans = Math.min(localans, Math.abs(twox-i)+Math.abs(twoy-j));   
                                            }
                                ans += localans;
                                }
                            }
                    }

        answer = Math.min(answer,ans);
    }
}
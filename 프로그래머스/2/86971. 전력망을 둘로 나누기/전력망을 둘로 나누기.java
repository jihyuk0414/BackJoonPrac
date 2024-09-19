import java.util.*; 

class Solution {
    static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        graph = new int[n+1][n+1];
        int answer = Integer.MAX_VALUE;
    
        for(int i = 0 ; i<n-1; i++)
        {
            int x = wires[i][0];
            int y = wires[i][1];
            
            graph[x][y]=1 ;
            graph[y][x]=1;
        }
        
        for (int i = 0 ; i< n-1 ; i ++)
        {
            int x1 = wires[i][0];
            int y1 = wires[i][1];
            
            int x2 = wires[i][1];
            int y2 = wires[i][0];
            
            graph[x1][y1] = 0;
            graph[x2][y2] = 0;
            
            answer= Math.min(answer,BFS(graph,n));
            
            graph[x2][y2] = 1;
            graph[x1][y1] = 1;
            
        }
        
        return answer;
    }
    
    public static int BFS(int [][]graph, int n)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n+1];
        int cnt = 1;

        
        //하나만 드가면 되잖아 생각해보니까
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty())
        {
            int now = q.poll();
            
            for (int i = 1; i<n+1 ; i++)
            {
                if (graph[now][i] == 1 && visited[i] == false)
                {
                    q.add(i);
                    visited[i]=true;
                    cnt+=1;
                }
            }
        }
        
        
        return Math.abs(cnt*2 - n);
        
    }
}
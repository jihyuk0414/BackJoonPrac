import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxval = 0;
        Map<Integer, Integer> answermap = new HashMap<>();

        boolean [][] map = new boolean [n+1][n+1];
        for (int i = 0; i<edge.length ; i++)
        {
            int [] nowedge = edge[i];
            int a = nowedge[0];
            int b = nowedge[1];
            
            map[a][b] = true;
            map[b][a] = true;
        }
        
        
        boolean [] visited=  new boolean[n+1];
        
        Queue<int []> q = new LinkedList<>();
        
        int [] newarr = new int [] {1,0};
        q.add(newarr);
        visited[1] = true;
        answermap.put(1,0);
        while(!q.isEmpty())
        {
            int [] now = q.poll();
            int start = now[0];
            int cnt = now[1];
            
            for (int i= 1; i<=n ; i++)
            {
                if (!visited[i])
                {
                    if (map[start][i])
                    {
                        int [] nextline = new int [] {i,cnt+1};
                        visited[i] = true;
                        q.add(nextline);
                        maxval = Math.max(cnt+1,maxval);
                        answermap.put(i,cnt+1);
                    }
                }
            }
        }
        
        for (Integer key : answermap.keySet())
        {
            if (answermap.get(key) == maxval)
            {
                answer+=1;
            }
        }
        
        return answer;
    }
}
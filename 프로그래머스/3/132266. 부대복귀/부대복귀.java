import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> answerlist = new ArrayList<>();
        
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0 ; i<=n ; i++)
        {
            map.add(new ArrayList<>());
        }
        
        for (int i = 0; i<roads.length ; i++)
        {
            int [] now  = roads[i];
            int a = now[0];
            int b = now[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        int[] distances = new int[n+1];
        Arrays.fill(distances, -1);
        

        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {destination,0});
            
        boolean [] visited = new boolean[n+1];
        visited[destination] = true;
        distances[destination] = 0;

        while (!q.isEmpty())
            {
                int [] now = q.poll();
                int before =now[0];
                int cnt = now[1];
                
                
                List<Integer> oneline = map.get(before);
                for (Integer val : oneline)
                {
                    if (!visited[val])
                    {
                        distances[val] = cnt+1;
                        int [] newarr = new int [] {val,cnt+1};
                        q.add(newarr);
                        visited[val] = true;
                    }
                }
            }
        
        
        
      
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        
        return answer;
    }
}
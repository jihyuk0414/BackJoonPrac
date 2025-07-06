import java.util.*;

class Solution {
    public boolean [] visited;
    public List<List<Integer>> graph = new LinkedList<>();
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        visited = new boolean[n+1];
        
        for (int i  = 0 ; i<= n ; i++)
        {
            graph.add(new LinkedList<>());
        }
        
        for (int i = 0 ; i<wires.length; i++)
        {
            int[] now = wires[i];
            int a = now[0];
            int b = now[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int i = 0 ; i<wires.length; i++ )
        {
            int [] nowcut = wires[i];
            
            Integer a = nowcut[0];
            Integer b = nowcut[1];
            graph.get(a).remove(b);
            graph.get(b).remove(a);
            
            for (int j = 1 ; j<graph.size(); j++)
            {
                //j는 출발 idx
                if (!visited[j] && graph.get(j).size() !=0 )
                {
                    visited[j] = true;
                    int checkval = check(j,1);
                    int diff = Math.abs(checkval - (n - checkval));
                    answer = Math.min(diff, answer);
                    visited[j] = false;
                    break;
                }
            }
            
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return answer;
    }
    
    public int check(int a, int cnt)
    {
        List<Integer> now = graph.get(a);
        for (int next : now)
        {
            if(!visited[next])
            {
                visited[next] = true;
                cnt +=1;
                cnt = check(next,cnt);
                visited[next] = false;
            }
        }
        return cnt;
    }
}
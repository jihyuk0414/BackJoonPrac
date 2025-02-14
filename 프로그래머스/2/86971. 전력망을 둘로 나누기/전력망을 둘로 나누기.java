import java.util.*;

class Solution {
    
    public List<List<Integer>> connectmap = new ArrayList<>();
    public int answer ;
    
    public int solution(int n, int[][] wires) {
        answer = n+1;
        
        for (int i = 0 ; i <= n;  i++)
        {
            //0은 사용하지 않고, 1~n
            List<Integer> onelinemap = new ArrayList<>();
            connectmap.add(onelinemap);
        }
        
        for (int i = 0 ; i<wires.length; i++)
        {
            int a = wires[i][0];
            int b = wires[i][1];    
            connectmap.get(a).add(b);
            connectmap.get(b).add(a);
        }
        
        for (int z = 0 ; z<wires.length ; z++)
        {
            int a = wires[z][0];
            int b = wires[z][1];    
            //하나 끊고
connectmap.get(a).remove(Integer.valueOf(b));  // b를 Integer 객체로 변환
connectmap.get(b).remove(Integer.valueOf(a));  
            
            boolean [] visited = new boolean[n+1];
            //둘의 차이 check
            int startone = 0 ;
            for (int i = 1; i<= n ; i++)
            {
                if (!visited[i])
                {
                    startone = i;
                    break;
                }
            }
            visited [startone] = true;
            int acnt = check(visited, startone);
            
            int starttwo = 0 ;
            for (int i = 1; i<= n ; i++)
            {
                if (!visited[i])
                {
                    starttwo = i;
                    break;
                }
            }
            visited [starttwo] = true;
            int bcnt = check(visited, starttwo);
            
            answer = Math.min(answer,(int) Math.abs(acnt-bcnt));
            
            connectmap.get(a).add(b);
            connectmap.get(b).add(a);
            
        }
        
        return answer;
    }
    
    public int check (boolean [] visited, int startidx)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(startidx);
        
        int ans = 1;
        while (!q.isEmpty())
        {
            int start = q.poll();
            List<Integer> cango = connectmap.get(start);
            for (Integer next : cango)
            {
                if (!visited[next])
                {
                    visited[next] = true;
                    q.add(next);
                    ans +=1;
                }
            }
        }
        return ans;
    }
}
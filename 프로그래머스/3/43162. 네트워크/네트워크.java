import java.util.*;
class Solution {
    public boolean [] visited ;
    public int answer = 0 ;
    public int globaln ;
        
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        globaln = n;
        
        List<List<Integer>>link = new ArrayList<>();
        for (int i = 0 ; i<n; i++)
        {
            List<Integer> newlink = new ArrayList<>();
            link.add(newlink);
        }   
        
        for (int i = 0 ; i<computers.length ; i++)
        {
            for (int j = 0 ; j<computers[i].length; j++)
            {
                if (i == j )
                {
                    continue;
                }
                int now = computers[i][j];
                if (now == 1)
                {
                    link.get(i).add(j);
                }
            }
        }      
        
        for (int i = 0 ; i<n ; i++)
        {
            if(!visited[i])
            {
                System.out.println("돌아갑니다 i : "+ i);
                visited[i] = true;
                answer +=1;
                DFS(link,0,i);
            }
        }
        
        return answer;
    }
    
    public void DFS(List<List<Integer>>link, int depth, int before)
    {
        if (depth == globaln)
        {
            return;
        }
        
        for (int i = 0 ; i <globaln; i++)
        {
            if (!visited[i] && link.get(before).contains(i))
            {
                visited[i] = true;
                DFS(link,depth+1,i);
            }
        }
    }
}
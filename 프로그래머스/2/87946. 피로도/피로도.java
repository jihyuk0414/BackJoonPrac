import java.util.*;
class Solution {
    public boolean [] visited;
    public int N,globalk; 
    public int answer = 0;
    public int [][] globaldungeons;
    public int solution(int k, int[][] dungeons) {
        globaldungeons = dungeons; //최소필요, 소모
        globalk = k;
        N = dungeons.length;
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++)
        {
            if (dungeons[i][0] <= k) {  
                visited[i] = true;    
                backtracking(1, i, k - dungeons[i][1]);  
                visited[i] = false;      
            }
        }
        
        return answer;
    }
    
    public void backtracking(int depth, int nowidx, int energy)
    {
        answer = Math.max(depth, answer);  // 도달했다 = 해당 idx까지 갈 숭 ㅣㅆ다.
        
        if (depth == N)
        {
            return;
        }
        
        for (int i = 0; i < N; i++)
        {
            if (!visited[i] && globaldungeons[i][0] <= energy)  
            {
                visited[i] = true;
                backtracking(depth+1, i, energy-globaldungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}
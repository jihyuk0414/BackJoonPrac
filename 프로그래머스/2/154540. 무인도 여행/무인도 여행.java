import java.util.*;

class Solution {
    public int [] dx = {0,1,0,-1};
    public int [] dy = {1,0,-1,0};
    public List<Integer> answerlist = new ArrayList<>();
    public int [][] intmap;
    public boolean[][] visited;
    public int N,M;
    public int[] solution(String[] maps) {
        
        intmap = new int [maps.length][maps[0].length()];
        for (int i = 0 ; i<maps.length ; i++)
        {
            for (int j = 0 ; j<maps[0].length(); j++)
            {
                char now = maps[i].charAt(j);
                if (now == 'X')
                {
                    intmap[i][j] = 0;
                } else {
                    intmap[i][j] = Character.getNumericValue(now);
                }
            }
        }
        
        N = intmap.length; 
        M = intmap[0].length; 
        
        visited = new boolean[N][M];
        
        for(int i = 0 ; i<N ; i++)
        {
            for (int j = 0 ; j<M; j++)
            {
                if (visited[i][j])
                {
                    continue;
                }
                if(intmap[i][j] !=0 )
                {
                    visited[i][j] = true;
                    int cnt = DFS(i,j,intmap[i][j]);
                    answerlist.add(cnt);
                }
            }
        }
        
        Collections.sort(answerlist);
        
        int [] answer = new int [answerlist.size()];
        for (int i = 0  ; i <answerlist.size() ; i++)
        {
            answer[i] = answerlist.get(i);
        }
        if (answer.length == 0)
        {
            answer = new int [] {-1};
        }
        
        return answer;
    }
    
    public int DFS(int startx, int starty,int cnt)
    {
        for (int i = 0 ;i<4; i++)
        {
            int nx = startx+dx[i];
            int ny = starty+dy[i];
            
            if (0<=nx && nx<N && 0<=ny && ny<M)
            {
                if (!visited[nx][ny] && intmap[nx][ny] !=0 )
                {
                    visited[nx][ny] =true;
                    cnt = DFS(nx,ny,cnt+intmap[nx][ny]);
                }
            }
        }
        
        return cnt;
    }
}
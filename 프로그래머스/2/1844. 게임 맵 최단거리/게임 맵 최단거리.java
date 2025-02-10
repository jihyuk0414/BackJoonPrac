import java.util.*;

class Solution {
    public int [] dx = {0,1,0,-1};
    public int [] dy = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<int [] > q = new LinkedList<>();
        
        boolean [][] visited = new boolean [maps.length][maps[0].length];
        
        int [] firstarr = {0,0,1}; //x,y,cnt
        q.add(firstarr);
        visited[0][0] = true;
        while (!q.isEmpty())
        {
            int [] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            if (x == maps.length-1 && y == maps[0].length-1)
            {
                return cnt;
            }
            
            for (int i = 0 ; i<4; i ++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if (0<=nx && nx<maps.length && 0<=ny && ny<maps[0].length)
                {
                    if (!visited[nx][ny] && maps[nx][ny]==1)
                    {
                        visited[nx][ny] = true;
                        int [] newarr = {nx,ny,cnt+1};
                        q.add(newarr);
                    }
                }
            }
        }
        
        return -1;
    }
}
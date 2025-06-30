import java.util.*;

class Solution {
    
    int [] dx = new int [] {0,1,0,-1};
    int [] dy = new int [] {1,0,-1,0};
    boolean [][] visited ;
    int N,M; 
    List <Integer> answerlist = new ArrayList<>();
    String [] globalmap ;
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        globalmap = maps;
        
        for (int i = 0 ; i<N; i++)
        {
            for (int j = 0 ; j<M ; j++)
            {
                if (!visited[i][j] && globalmap[i].charAt(j) != 'X')
                {
                    int val = dfs(i,j,0);
                    answerlist.add(val);
                }
            }
        }
        
        Collections.sort(answerlist);
        
        if (answerlist.size() == 0)
        {
            return new int [] {-1};
        }
        
        int [] answerarr = new int [answerlist.size()];
        
            for (int i = 0 ; i<answerlist.size(); i++)
            {
                answerarr[i] = answerlist.get(i);
            }
        
        return answerarr;
    }
    
    public int dfs(int x, int y, int cnt)
    {
        visited[x][y] = true;
        cnt += Character.getNumericValue(globalmap[x].charAt(y));
        
        for (int i = 0 ; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(0<=nx && nx <N && 0<= ny && ny <M )
            {
                if (!visited[nx][ny] && globalmap[nx].charAt(ny) != 'X')
                {
                    //일 하고
                    cnt = dfs(nx,ny,cnt);
                }
            }
        }
        
        return cnt;
    }
}
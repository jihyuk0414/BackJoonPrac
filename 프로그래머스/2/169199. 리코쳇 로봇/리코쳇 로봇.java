import java.util.*;

class Solution {
    
    public int [] dx = {0,1,0,-1};
    public int [] dy = {1,0,-1,0};
    public char [][]map;
    public boolean [][] visited ;
    public int rx = -1;
    public int ry = -1;
    public int N,M ;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        map = new char[N][M];
        
        for (int i = 0 ; i<N ; i++)
        {
            for (int j = 0 ; j<M ; j++)
            {
                map[i][j]=  board[i].charAt(j);
            }
        }
        
         visited=  new boolean[N][M];
        
        //R의 위치를 찾고
        findAndSetRxRy();
        
        Queue<int []> q=  new LinkedList<>();
        int [] firstarr = new int [] {rx,ry,0}; //rx,ry,cnt;
        q.add(firstarr);
        visited[rx][ry] = true;
        //1칸씩 계속 나아가는 함수 필요 
        
        while(!q.isEmpty())
        {
            int [] nowarr = q.poll();
            int x = nowarr[0];
            int y = nowarr[1];
            int cnt = nowarr[2];
            
            if (map[x][y]=='G')
            {
                return cnt;
            }
            
            for (int i= 0 ; i<4; i++)
            {
                int nx = x;
                int ny = y;
                
                while(true)
                {
                    nx +=dx[i];
                    ny +=dy[i];
                    if (0>nx || nx>=N || 0>ny || ny>=M || map[nx][ny] =='D')
                    {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                
                if((nx == x && ny == y) || visited[nx][ny]) continue;
                
                visited[nx][ny] =true;
                int [] newarr = new int []{nx,ny,cnt+1};
                q.add(newarr);
            }
        }
        
        return -1;
    }
    
    public void findAndSetRxRy()
    {
        for (int i = 0 ; i<N ; i++)
        {
            for (int j = 0 ; j<M ; j++)
            {
                if (map[i][j] == 'R')
                {
                    rx = i ;
                    ry = j;
                    return;
                }
            }
        }
    }
}
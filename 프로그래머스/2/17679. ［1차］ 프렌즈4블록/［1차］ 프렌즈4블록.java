import java.util.*; 


class Solution {
    public int globaln, globalm;
    public int answer = 0;
    public char [][] globalmap ;
    public int [] dx = {0,0,1,1};
    public int [] dy = {0,1,1,0};
    
        
    public int solution(int m, int n, String[] board) {
        globalm = board.length ; 
        globaln = board[0].length();
        globalmap = new char [globalm][globaln];
        
        for (int i = 0 ; i<globalm ; i++)
        {
            for (int j =0  ; j<globaln; j++)
            {
                globalmap[i][j] = board[i].charAt(j);
            }
        }
        
        while (true)
        {
            char [][] savemap = new char[globalm][globaln];
            for (int i = 0 ; i<globalm; i++)
            {
                for (int j = 0 ; j<globaln ; j++)
                {
                    dojob(i,j,savemap);
                }
            } //지울 애들 check
            
            int localcnt = del(savemap);
            if (localcnt <4)
            {
                break;
            }
            
            answer += localcnt;
            
            for (int j = 0 ; j<globaln; j++)
            {
                godown(j);
            }
        
            
        }
        
        return answer;
    }
    
    public void dojob(int x, int y, char [][] savemap)
    {
        char now = globalmap[x][y];
        if (now == '0')
        {
            return;
        }
        
        //m이 x
        //n이 y
        int howmany = 0 ;
        for (int i = 0 ; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if (nx < globalm && ny <globaln)
            {
                if(globalmap[nx][ny] == now)
                {
                    howmany +=1; 
                }
            }
        }    
        
        if (howmany ==4 )
        {
            for (int i = 0 ; i<4; i++)
        {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if (nx < globalm && ny <globaln)
             {
                savemap[nx][ny] = '0' ;
            }
        }  
        }
        
    }
    
    public int del (char [][] savemap)
    {
        // 지우기로 했던 애들을 지우고, 지울게 몇개인지 확인하는 함수
        int cnt = 0 ;
        for (int i = 0 ; i<globalm ; i++)
        {
            for (int j =0  ; j<globaln; j++)
            {
                if (savemap[i][j] == '0')
                {
                    globalmap[i][j] = '0';
                    cnt +=1;
                }
            }
        }
        return cnt ;
    }
    
    public void godown(int y)
    {
        //특정 세로열의 값을 내린다.
        for (int i = globalm-1; i>=0 ; i--)
        {
            if (globalmap[i][y] == '0')
            {
                int nx = i-1;
                while (nx >=0)
                {
                    if(globalmap[nx][y] != '0')
                    {
                        globalmap[i][y] = globalmap[nx][y];
                        globalmap[nx][y]= '0';
                        break;
                    }
                    nx -=1;
                }
            }
        }
    }
    
    
   
    
}
class Solution {
    
    public int [] dx = {1,0,-1};
    public int [] dy = {0,1,-1};
    
    public int[] solution(int n) {
        if (n ==1 )
        {
            return new int[] {1};
        }
        int [][]narr = new int [n][n]; 
        
        int x= -1;
        int y = 0;
        //down , right, left위
        
        int cnt = n;
        int whatdo = 0; //할일
        int val = 1;
        for (int move = n; move >=1 ; move --)
        {
            for (int i = 0 ; i<move; i++)
            {
                x = x+dx[whatdo%3];
                y = y+dy[whatdo%3];
                
                narr[x][y] = val;
                val+=1;
                //한 행동에서 할일 
            }
            whatdo +=1;
        }
        
        int nsize = 0;
        for (int i = 1; i<= n ; i++)
        {
            nsize += i;
        }
        
        int [] answer = new int[nsize];
        int ncnt = 0;
        for (int i = 0 ; i<n ; i ++)
        {
            for (int j = 0 ; j<=i ; j++)
            {
                if (narr[i][j]!=0)
                {
                    answer[ncnt] = narr[i][j];
                    ncnt +=1;
                }
            }
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    
    public int globaln;
    public int answer = 0 ;
    public int solution(int n) {
        globaln = n;
    
        //백트래킹으로 해보기는. .하자 
        int [] p = new int [n];
        backtracking(p,0);
        
        return answer;
    }
                
    public void backtracking(int [] p , int depth)
    {
        if (depth == globaln)
        {
            answer +=1;
            return;
        }
        
        for (int i = 0 ; i<globaln; i++)
        {
            //depth,i에 놓는다.
            p[depth] = i;
            if(prune(p,depth))
            {
                backtracking(p,depth+1);
            }
            p[depth] = 0;
        }
    }
    
    public boolean prune(int []p, int garo)
    {
        for (int i = 0 ; i<garo; i++)
        {
            //p를 이전 idx까지 다 돌면서, 해당 가로에 놓을 수 있는지
            if (p[garo] == p[i] || (Math.abs(garo-i) == Math.abs(p[garo]-p[i])))
            {
                return false;
            }
        }
        return true;
    }
}
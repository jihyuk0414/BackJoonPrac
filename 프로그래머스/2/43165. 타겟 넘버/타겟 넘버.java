import java.util.*;

class Solution {
    public int answer = 0 ;
    public int [] globalanswer ;
    public int n,globaltarget;
    public int solution(int[] numbers, int target) {

        globalanswer = numbers;
        n = numbers.length;
        globaltarget = target;
        dfs(0,0);
        return answer;
    }
    
    public void dfs(int val,int depth)
    {
        if (depth == n)
        {
            if (val == globaltarget)
            {
                answer+=1;
 
            }              
            return;
        }
        
        dfs(val-globalanswer[depth],depth+1);
        dfs(val+globalanswer[depth],depth+1);
    }
}
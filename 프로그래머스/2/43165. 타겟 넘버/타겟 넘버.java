class Solution {
    public int answer = 0;
    public int realtarget;
    
    public int solution(int[] numbers, int target) {
        realtarget = target;
        DFS(0, numbers,0);
        return answer;
    }
    
    public void DFS(int sumcnt,int[]numbers, int nowindex)
    {
        if (nowindex == numbers.length)
        {
            if (sumcnt == realtarget)
            {
                answer += 1;
                return;
            }
        }else {
            DFS(sumcnt+numbers[nowindex], numbers, nowindex+1);
            DFS(sumcnt-numbers[nowindex], numbers, nowindex+1);
        }      
    

        
    }
}
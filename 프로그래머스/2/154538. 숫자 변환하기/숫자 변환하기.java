class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int [] dp = new int [y+1];
        
        for (int i = 0 ; i <=y ; i++)
        {
            dp[i] = Integer.MAX_VALUE/2;
        }
        dp[x] = 0;
        
        for (int i = x+1; i<=y; i++)
        {
            if (i-n >= x)
            {
                dp[i] = Math.min(dp[i],dp[i-n]+1);
            } 
            if (i%2 ==0 &&i/2 >= x)
            {
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if (i%3 ==0 && i/3 >= x)
            {
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        answer = dp[y] != Integer.MAX_VALUE/2 ? dp[y] : -1;
        return answer;
    }
}
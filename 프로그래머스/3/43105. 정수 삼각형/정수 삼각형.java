class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int [][] dp = new int [triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i<dp.length; i++)
        {
            for (int j = 0; j<=i; j++)
            {
                if (j ==0)
                {
                    dp[i][j] = dp[i-1][j]+triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
                }
            }
        }
        
        for (int j = 0 ; j<dp[0].length; j++)
        {
            answer = Math.max(answer,dp[dp.length-1][j]);
        }
        return answer;
    }
}
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int [][] dp = new int [land.length][land[0].length];
        
        for (int i = 0 ; i<dp[0].length ; i++)
        {
            dp[0][i] = land[0][i];
        }
        
        for (int i =1; i<dp.length; i++)
        {
            for (int j = 0; j<dp[0].length; j++)
            {
                for (int z = 0; z<dp[0].length; z++)
                {
                    if (j!= z)
                    {
                        dp[i][j] = Math.max(dp[i-1][z] + land[i][j],dp[i][j]);
                    }
                }
            }
        }
        
        for (int i = 0 ; i<dp[0].length; i++)
        {
            answer =Math.max(answer,dp[dp.length-1][i]);
        }

        return answer;
    }
}
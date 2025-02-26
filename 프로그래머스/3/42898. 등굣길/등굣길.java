class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] dp = new int [n][m];
        
        for (int i = 0 ; i<puddles.length; i++)
        {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (dp[0][i] != -1) {
                dp[0][i] = dp[0][i-1];
            } else {
                dp[0][i] = 0;  // 물웅덩이인 경우 0으로 설정
            }
        }
        
        // 첫 열 초기화
        for (int i = 1; i < n; i++) {
            if (dp[i][0] != -1) {
                dp[i][0] = dp[i-1][0];
            } else {
                dp[i][0] = 0;  
            }
        }
        
        for (int i = 1; i<n; i++)
        {
            for (int j = 1; j<m; j++)
            {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;  
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
                }
            }
            
        }
        return dp[n-1][m-1];
    }
}
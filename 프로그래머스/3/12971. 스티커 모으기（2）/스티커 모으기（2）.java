class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if (n ==1 )
        {
            return sticker[n-1];
        } else if (n==2)
        {
            return Math.max(sticker[0],sticker[1]);
        }
        
        //첫번째거 선택 경우
        
        int [] dp1 = new int [n]; //맨처음에 마지막거
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i<n-1; i++)
        {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+sticker[i]);
        }
        
        int [] dp2= new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i<n; i++)
        {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
        }
        
        return Math.max(dp1[n-2],dp2[n-1]);
    }
}
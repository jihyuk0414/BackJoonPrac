class Solution {
    public int[] solution(int[] prices) {
        
        int N = prices.length;
        
        int[] answer = new int[N];
        
        for(int i = 0 ; i<N; i++)
        {
            int realans = 0;
            for(int j = i+1 ; j<N;j++)
            {
                realans+=1;
                if(prices[j]<prices[i])
                {
                    break;
                }
            }
            answer[i]=realans;
        }
        return answer;
    }
}
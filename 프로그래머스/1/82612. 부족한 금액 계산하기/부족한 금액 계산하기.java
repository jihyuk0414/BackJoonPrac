class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long cntmoney = 0;
        for (int i = 1 ; i<=count; i++)
        {
            cntmoney += (price*i);
        }
        
        answer = (long) money - cntmoney;
        
        if (answer>0)
        {
            answer = 0 ;
        }
        else 
        {
            answer = -answer; 
        }

        return answer;
    }
}
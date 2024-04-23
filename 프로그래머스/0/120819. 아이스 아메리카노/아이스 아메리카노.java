class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        int cnt = 0 ;
        for (int i =1 ; i < 2000; i++)
        {
            if (money >= 5500)
            {
                money = money - (5500);
                cnt = i  ;
            }
            else
            {
                break ; 
            }
           
        }
        
        answer[0] = cnt;
        answer[1] = money;
        return answer;
    }
}
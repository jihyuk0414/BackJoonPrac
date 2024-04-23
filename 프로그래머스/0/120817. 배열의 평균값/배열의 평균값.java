class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double cnt = 0 ;
        
        for(int i = 0 ; i<numbers.length; i++)
        {
            cnt += (double) numbers[i] ;
        }
        
        answer = cnt / numbers.length ;
        
        return answer;
    }
}
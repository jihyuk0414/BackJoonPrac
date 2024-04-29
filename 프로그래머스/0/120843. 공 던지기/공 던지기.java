class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;

        
        int cnt = 1 ;
        int next = 0;
        while (true)
        {
            if (cnt == k)
            {
                answer = numbers[next];
                break;
            }
            
            next = (next+2)%numbers.length;
            cnt += 1;
        }
            
        return answer;
    }
}
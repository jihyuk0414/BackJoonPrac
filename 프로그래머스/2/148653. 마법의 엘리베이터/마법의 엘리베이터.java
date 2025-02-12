class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int nowval = storey % 10;
            int nextval = (storey / 10) % 10;
            
            if (nowval < 5) {
                answer += nowval;
            } else if (nowval > 5) {
                answer += (10-nowval);
                storey += 10;
            } else { // nowval == 5
                if (nextval >= 5) {
                    storey += 10;
                }
                answer += 5;
            }
            
            storey /= 10;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        Stack<Integer> indexstack = new Stack<>();
        
        for (int i = 0 ; i<prices.length; i++)
        {
            int nowval = prices[i];
            while (!indexstack.isEmpty() && prices[indexstack.peek()] > nowval)
            {
                int out = indexstack.pop();
                answer[out] = i-out;
            }
            indexstack.push(i);
        }
        
        int cnt= 0;
        
        while (!indexstack.isEmpty())
        {
            int idx = indexstack.pop();
            answer[idx] = prices.length-1-idx;
        }
        
        
        return answer;
    }
}
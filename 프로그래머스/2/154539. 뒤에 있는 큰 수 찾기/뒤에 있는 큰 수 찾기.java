import java.util.* ;
class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        
        int n = numbers.length ;
        
        int[] answer = new int [n];
        for (int i = n-1; i>= 0 ; i--)
        {
            while (!stack.isEmpty())
            {
                int before = stack.peek();
                
                if (before > numbers[i])
                {
                    answer[i] = before;
                    break;
                } else {
                    stack.pop();  
                }
            }
            stack.push(numbers[i]);
            if (stack.size() ==1 )
            {
                //못찾은경우
                answer[i] = -1;
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int answer = 0 ;
    
    public int solution(int[][] board, int[] moves) {
        
        List<Stack<Integer> > boardstack = new ArrayList<>();
        
        for (int i = 0 ; i<board.length; i++)
        {
            Stack<Integer> oneline = new Stack<>();
            boardstack.add(oneline);
        }
        
        for (int i = board.length-1 ; i>=0; i--)
        {
            for (int j = 0 ; j<board[0].length; j++)
            {
                int now = board[i][j];
                if (now == 0)
                {
                    continue;
                }
                boardstack.get(j).add(now);
            }
        }
        
        
        
        Stack<Integer> popstack = new Stack<>();
        
        for (int i = 0 ; i<moves.length; i++)
        {
            if (!boardstack.get(moves[i]-1).isEmpty())
            {
                
            int a = boardstack.get(moves[i]-1).pop();
            popstack.add(a);
            pop(popstack);
            }
        }
        
        return answer;
    }
    
    public void pop (Stack<Integer> stack)
    {
        if (stack.size () >=2)
        {
            int a = stack.pop();
            int b=  stack.pop();
            
            if (a==b)
            {
                answer +=2;
                return;
            } else {
                stack.push(b);
                stack.push(a);
            }
        }
    }
}
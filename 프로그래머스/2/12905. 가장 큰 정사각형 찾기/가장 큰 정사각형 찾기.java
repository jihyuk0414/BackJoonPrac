import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int n = board.length; 
        int m = board[0].length;
        
        if (n ==1 || m ==1 )
        {
            for (int i = 0 ; i<n ; i++)
            {
                for (int j = 0 ; j<m ; j++)
                {
                    if (board[i][j] == 1)
                    {
                        return 1;
                    }
                }
            }
            return answer;
        }

        for (int i =1; i<n ; i++)
        {
            for (int j = 1; j<m; j++)
            {
                if (board[i][j] == 1)
                {
                    board[i][j] = Math.min(
                        Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                    answer = Math.max(answer,board[i][j]);
                    
                }
            }
        }
        
        return answer*answer;
    }
}
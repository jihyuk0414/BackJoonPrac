import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N =board.length;
        int M = board[0].length;
        
        //차분 배열 + 누적합 (변화를 기록하는 차분
        
        int [][] change = new int[N][M];
        int [][] changenew = new int[N][M];
        
        // 기록에 o(1), 누적 계산에 nn
        int go = skill.length;
        
        for (int i = 0; i<go; i++)
        {
            int [] now = skill[i];
            int type = now[0];
            int r1 = now[1];
            int c1 = now[2];
            int r2 = now[3];
            int c2 = now[4];
            int degree = now[5];
            
            if (type == 1)
            {
                degree = -degree;
            }
            
            change[r1][c1] += degree;
            
            if (r2+1 <N && c2+1<M)
            {
                change[r2+1][c2+1] += degree;
                
            }
            
            if (c2+1<M)
            {
            change[r1][c2+1] -= degree;
            }
             if (r2+1 <N )
            {
            change[r2+1][c1] -= degree;
            }
            
        }
        
        changenew[0][0] = change[0][0];
        //누적합형태로 change 계산
        for (int i = 1 ; i<N; i++)
        {
            changenew[i][0] = changenew[i-1][0]+change[i][0];
        }
        
        for (int j = 1; j<M; j++)
        {
            changenew[0][j] = changenew[0][j-1] + change[0][j];
        }
        
        for (int i = 1; i<N; i++)
        {
            for (int j = 1; j<M; j++)
            {
                changenew[i][j] = changenew[i-1][j] + changenew[i][j-1] 
                                - changenew[i-1][j-1] + change[i][j] ;
            }
        }
        
        for (int i = 0 ;i<N ; i++)
        {
            for (int j = 0 ; j<M; j++)
            {
                board[i][j] += changenew[i][j];
                
                if(board[i][j] >= 1)
                {
                    answer +=1;
                }
            }
        }
        

        
        
        
        
        
        
        return answer;
    }
}
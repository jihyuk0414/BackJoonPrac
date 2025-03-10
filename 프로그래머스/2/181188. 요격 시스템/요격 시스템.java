import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> 
                    {
                        return a[1]-b[1];
                    });
        
        int lastMissile = -1; 
        
        for (int i = 0 ; i<targets.length; i++)
        {
            int start = targets[i][0];
            int end = targets[i][1];
            
            if (start >= lastMissile)
            {
                lastMissile= end;
                answer+=1;
            }
        }
        
        return answer;
    }
}
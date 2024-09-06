import java.util.* ;
import java.lang.* ;

class Solution {
    public String solution(String s) {
        String answer = "";
        String [] strarr = s.split(" ");
        int[] intarr = new int[strarr.length];
        
        for (int i = 0 ;i<intarr.length; i++)
        {
            intarr[i] = Integer.parseInt(strarr[i]);
        }
        
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        
        for (int i = 0 ; i<intarr.length; i++)
        {
            if (intarr[i] <minNum)
            {
                minNum = intarr[i];
            }
            
            if (intarr[i] > maxNum)
            {
                maxNum = intarr[i];
            }
        }
        
        answer += minNum;
        answer += " ";
        answer += maxNum;
        
        return answer;
    }
}
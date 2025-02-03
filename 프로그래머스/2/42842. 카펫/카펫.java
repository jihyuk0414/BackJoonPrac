import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> answerlist=  new ArrayList<>();
        for (int i = 1 ; i<=yellow; i ++)
        {
            if (yellow%i == 0)
            {
                int [] newarr = {i, yellow/i};
                answerlist.add(newarr);
            }
        }
        
        
        
        for (int i = 0 ; i<answerlist.size() ; i++)
        {
            int [] nowarr = answerlist.get(i);
            int a= nowarr[0];
            int b = nowarr[1];

            
            if ((a+2)*(b+2) == (brown+yellow))
            {
                int [] newarr = {Math.max(a+2,b+2), Math.min(a+2,b+2)};
                return newarr;
            }
        }
        return null;
    }
}
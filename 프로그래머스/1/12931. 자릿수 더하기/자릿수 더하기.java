import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String nstr = Integer.toString(n); 
        
        for (int i=0; i<nstr.length(); i++)
        {
            char mychar = nstr.charAt(i) ;
            int x= Character.getNumericValue(mychar);
            answer+=x;
            
        }
        
        return answer;

        
    }
}
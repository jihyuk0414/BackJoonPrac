import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n >= 1)
        {
            if (n ==1)
            {
                ans +=1;
                n = 0 ;
                continue;
            }
            
            if (n%2 ==0)
            {
                n/=2;
            } else {
                ans +=1;
                n-=1;
            }
        }

        return ans;
    }
}
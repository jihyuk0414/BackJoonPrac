import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantmap = new HashMap<>();
        
        int total = 0;
        for (int i = 0 ; i<number.length; i++)
        {
            wantmap.put(want[i],number[i]);
            total+= number[i];
        }
        
        int day = 0 ;
        while (day <= (discount.length-total))
        {
            Map<String,Integer> comparemap = new HashMap<>();
            for (int i = day; i<total+day; i++)
            {
                comparemap.put(discount[i],comparemap.getOrDefault(discount[i],0)+1);
            }
            boolean flag = true;
            for (String key : comparemap.keySet())
            {
                if (!wantmap.keySet().contains(key))
                {
                    flag= false;
                    break;
                }
                
                if (comparemap.get(key) != wantmap.get(key))
                {
                    flag= false;
                    break;
                }
            }
            
            if (flag)
            {
                answer+=1;
            }
            day+=1;
        }
 
        
        return answer;
    }
}
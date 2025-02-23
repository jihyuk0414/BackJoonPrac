import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];
        
        Map <Character,Integer> map = new HashMap<>();
        
        for (int i = 0 ; i<keymap.length; i++)
        {
            for (int j = 0 ; j< keymap[i].length();j++)
            {
                if (!map.keySet().contains(keymap[i].charAt(j)))
                {
                    map.put(keymap[i].charAt(j),j);
                } else {
                    int min = Math.min(j,map.get(keymap[i].charAt(j)));
                    map.put(keymap[i].charAt(j),min);
                }
            }
        }
      
            
        for (int i = 0 ;i<targets.length; i++)
        {
              int ans = 0 ;
            int before = -1;
            for (int j = 0 ; j<targets[i].length();j++)
            {  
                char now = targets[i].charAt(j);
                
                if (map.keySet().contains(now))
                {
                    ans += (map.get(now)+1);
                } else {
                    ans = 0;
                    break;
                }
                
            }
            
                         
        ans = ans == 0? -1 : ans;
        answer[i] = ans; 
        }

        
        
        return answer;
    }
}
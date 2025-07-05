import java.util.*;

class Solution {
    public Map<String, Set<String>> map = new HashMap<>();
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (int i = 0 ; i<clothes.length; i++)
        {
            String [] now  = clothes[i];
            String val = now[0];
            String key = now[1];
        
            if(!map.keySet().contains(key))
            {
                Set<String>newset = new HashSet<>();
                newset.add(val);
                map.put(key,newset);
            }else
            {
                map.get(key).add(val);
            }
        }
        
        for (String key : map.keySet())
        {
            answer *= (map.get(key).size()+1);
        }
        
        return answer-1;
    }
}
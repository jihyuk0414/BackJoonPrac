import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        int minlen = 1000001;
        int minstart = 1000001;
        int minend = 1000001;
        
        Map<String, Integer> checkfirst = new HashMap<>();
        for (String val : gems)
        {
            checkfirst.put(val,checkfirst.getOrDefault(val,0)+1);
        }
        
        int target = checkfirst.keySet().size();//채워야 되는 key
        
        Map<String, Integer> check = new HashMap<>();
        int n = gems.length;
        
        
        String [] gem_real = new String [n+1];
        for (int i = 0 ; i<n ; i++)
        {
            gem_real[i] = gems[i];
        }
        
        
        int start =0;
        int end = 0;
        check.put(gem_real[start],1);
        int cnt = 1;
        
        while (end < n)
        {
            if (cnt < target)
            {
                //아직 다 못채웠다
                end+=1;
                if(end ==n)
                {
                    break;
                }
                check.put(gem_real[end],check.getOrDefault(gem_real[end],0)+1);
                cnt = check.keySet().size();
            } else if (cnt == target)
            {
                if (minlen > (end-start+1))
                {
                    minlen = (end-start+1);
                    minstart = start;
                    minend = end;
                }
                
                
                int howmany = check.get(gem_real[start]);
                if (howmany == 1)
                {
                    check.remove(gem_real[start]);
                    start += 1;
                    cnt = check.keySet().size();
                    
                    end += 1;
                    if (end == n)
                    {
                        break;
                    }
                    check.put(gem_real[end], check.getOrDefault(gem_real[end], 0) + 1);
                    cnt = check.keySet().size();
                } 
                else 
                {
                    check.put(gem_real[start], howmany - 1);
                    start += 1;
                }
            } 
        }
        
        int [] answer = new int[2];
        answer[0] = minstart+1;
        answer[1] = minend+1;
        return answer;
    }
}
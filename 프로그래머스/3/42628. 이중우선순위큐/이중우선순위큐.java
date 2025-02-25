import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        
        for (int i = 0 ; i<operations.length; i++)
        {
            String [] now = operations[i].split(" ");
            if (now[0].equals("I"))
            {
                int k= Integer.parseInt(now[1]);
                tmap.put(k, tmap.getOrDefault(k,0)+1);
            }
            
            else if (now[0].equals("D"))
            {
                if (now[1].equals("1") && tmap.size()!=0)
                {
                    int last=  tmap.lastKey();
                    if(tmap.get(last) > 1)
                    {
                        tmap.put(last,tmap.get(last)-1);
                    } else {
                        tmap.remove(last);
                    }
                } else if (now[1].equals("-1") && tmap.size()!=0)
                {
                    int first=  tmap.firstKey();
                    if(tmap.get(first) > 1)
                    {
                        tmap.put(first,tmap.get(first)-1);
                    } else {
                        tmap.remove(first);
                    }
                }
            }
        }
                                    
        if(tmap.size() == 0)
        {
            return new int []{0,0};
        }
        
        int [] answer = new int [2];
        
        
        answer[0] = tmap.lastKey();
        answer[1] = tmap.firstKey();
        
        return answer;
    }
}
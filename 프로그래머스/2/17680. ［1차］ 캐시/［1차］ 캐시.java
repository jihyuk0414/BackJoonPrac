import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize ==0)
        {
            return cities.length*5;
        }
        List<String> cachelist = new ArrayList<>();
        for (int i = 0 ; i<cities.length; i++)
        {
            String now = cities[i].toLowerCase();
            if (cachelist.size() < cacheSize )
            {
                if (!cachelist.isEmpty() && cachelist.contains(now))
                {
                       answer+=1;
    cachelist.remove(now); // 히트된 항목을 제거
    cachelist.add(now);    // 해당 항목을 가장 최근 사용으로 추가
    continue;
                }else {
                    
                answer +=5; 
                cachelist.add(now);
                continue;
                } 
                
            }
            
            //크기가 cachesize이미 되었음
            if (!cachelist.contains(now))
            {
                cachelist.remove(0);
                cachelist.add(now);
                
                answer +=5;
            } else {
                //있다면
                int where= -1;
                for (int j = 0 ; j<cachelist.size() ; j++)
                {
                    if (cachelist.get(j).equals(now))
                    {
                        where = j;
                    }
                }
                cachelist.remove(where);
                cachelist.add(now);

                answer+=1;
            }
        }
        return answer;
    }
}
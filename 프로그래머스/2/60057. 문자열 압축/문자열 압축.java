import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        if (answer ==1 )
        {
            return 1;
        }

        StringBuilder sb = new StringBuilder();

        Map<String, Integer> answermap  =new HashMap<>();
        
        int k = 1;
        while (k < s.length())
        {
            StringBuilder anssb = new StringBuilder();
            String beforestr = "";
            int samecnt= 0 ;
            for (int i = 0 ; i< s.length();  i++)
            {
                sb.append(s.charAt(i));
                
                // if (i == 0 )
                // {
                //     continue;
                // }
                
                if ((i+1)%k == 0 || i == s.length()-1)
                {
                    if (beforestr.equals("") || sb.toString().equals(beforestr))
                    {
                        samecnt +=1;
                    } else {
                        
                        //여태까지 앞에있던 애들 추가해야되겠다.
                        
                        if (samecnt != 1)
                        {
                            anssb.append(String.valueOf(samecnt));
                        }
                        anssb.append(beforestr);
                        samecnt = 1; 
                    }
                    beforestr = sb.toString();

                    sb.setLength(0);
                }
                
            }
            
            if (samecnt != 1) {
               anssb.append(String.valueOf(samecnt));
            }
            anssb.append(beforestr);
            answer = Math.min(answer,anssb.length());
            k+=1;
        }
        
        //값 중 최소를 최대한 빠르게 구해내야 한다. 

        return answer;
    }
}
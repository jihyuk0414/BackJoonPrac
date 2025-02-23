import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> slist = new ArrayList<>();
        char now = '0';
        int nowcnt = 0;
        int nowidx = -1;
        int diffcnt = 0 ;
        for (int i = 0 ;i<s.length(); i++)
        {
            if (now == '0')
            {
                now = s.charAt(i);
                nowcnt +=1;
                nowidx = i;
                diffcnt = 0;
            }else {
                if (s.charAt(i) == now)
                {
                    nowcnt +=1;
                } else {
                    diffcnt +=1;
                    if (nowcnt == diffcnt)
                    {
                        slist.add(s.substring(nowidx,i+1));
                        now = '0';
                        nowidx = -1;
                        nowcnt = 0;
                    }
                }
            }
            
        }
        
        if (now != '0')
        {
            slist.add(s.substring(nowidx,s.length()));
        }
        
        return slist.size();
    }
}
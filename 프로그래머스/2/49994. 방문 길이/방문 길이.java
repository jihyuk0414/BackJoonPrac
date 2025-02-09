import java.util.*;

class Solution {
    public int nowx,nowy = 0 ;
    public Set<String> answerset = new HashSet<>();
    public int solution(String dirs) {
        for (int i = 0 ; i<dirs.length(); i++)
        {
            move(dirs.charAt(i));
        }
        
        return answerset.size();
    }
    
    public void move (char whattodo)
    {
        int beforex = nowx;
        int beforey = nowy;
        if (whattodo == 'U')
        {
            if (nowx+1 <=5)
            {
                nowx+=1;
            } else {
                return;
            }
        } else if (whattodo == 'L')
        {
            if (nowy-1 >=-5)
            {
                nowy-=1;
            }else {
                return;
            }
        }else if (whattodo == 'R')
        {
            if (nowy+1 <=5)
            {
                nowy+=1;
            }else {
                return;
            }
        }else if (whattodo == 'D')
        {
            if (nowx-1 >= -5)
            {
                nowx-=1;
            }else {
                return;
            }
        } // 이동 완료
        
        String road1 = beforex+""+beforey+""+nowx+""+nowy;
         String road2 = nowx+""+nowy+""+beforex+""+beforey;
        if (answerset.contains(road1)||answerset.contains(road2))
        {
            return;
        }
        answerset.add(road1);
    
    }
}
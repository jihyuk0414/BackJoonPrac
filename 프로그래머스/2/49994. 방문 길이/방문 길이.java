import java.util.*;

class Solution {
    
    public int [] dx = new int [] {1,0,-1,0};
    public int [] dy = new int [] {0,-1,0,1};
    
    public int solution(String dirs) {
        int answer = 0;
        
        List<Character> dirlist = new ArrayList<>();
        for (int i = 0 ; i<dirs.length(); i++)
        {
            dirlist.add(dirs.charAt(i));
        }
        
        List <String> visitlist = new ArrayList<>();
        
        int nowx = 0; 
        int nowy = 0;
        
        for (int i = 0 ; i<dirlist.size(); i++)
        {
            char now = dirlist.get(i);
            int beforex= nowx;
            int beforey = nowy;
            if (now == 'U')
            {
                nowy +=1;
            }
            else if (now == 'R')
            {
                nowx+=1;
            }
            else if (now == 'L')
            {
                nowx -=1;
            }
            else if (now == 'D')
            {
                nowy -=1;
            }
            
            if (nowx < -5 || nowx > 5 || nowy < -5 || nowy > 5)
            {
                nowx = beforex;
                nowy = beforey;
                continue;
            }
            
            String line1 = String.valueOf(beforex)+beforey+nowx+nowy;
            String line2 = String.valueOf(nowx)+nowy+beforex+beforey;
            
            if (visitlist.contains(line1) || visitlist.contains(line2))
            {
                continue;
            }
            
            visitlist.add(line1);
            visitlist.add(line2);
            
            answer +=1;
        }
        
        return answer;
    }
}
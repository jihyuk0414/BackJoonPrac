import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
       
        int n = park.length;
        int m = park[0].length();
        char [] [] map = new char[n][m];
        
        int startx = 0;
        int starty = 0 ;
        
        for (int i = 0 ; i<n ; i++)
        {
            String oneline = park[i];
            for (int j = 0 ; j<m ; j++)
            {
                map[i][j] = oneline.charAt(j);
                if (map[i][j] == 'S')
                {
                    startx = i;
                    starty = j;
                }
            }
        }
        
        for (int i =0 ; i<routes.length; i++)
        {
            String [] oneline = routes[i].split(" ");
            char where = oneline[0].charAt(0);
            int nextx = startx;
            int nexty = starty;
            int move = Integer.parseInt(oneline[1]);
            boolean safe = true;
            
            if (where == 'E')
            {
                nexty += move;
                for (int j = starty ; j<=nexty; j++)
                {
                    if(j<0 || j>= m || map[startx][j] == 'X')
                    {
                        safe=false;
                        break;
                    }
                }
            } else if (where == 'W')
            {
                nexty -= move;
                for (int j = nexty ; j<=starty; j++)
                {
                    if(j<0 || j>= m||map[startx][j] == 'X')
                    {
                        safe=false;
                        break;
                    }
                }
            } else if (where == 'N')
            {
                nextx -= move;
                for (int j = nextx; j<=startx; j++)
                {
                    if(j<0 || j>=n|| map[j][starty] == 'X')
                    {
                        safe=false;
                        break;
                    }
                }
            } else {
                nextx += move;
                for (int j = startx ; j<=nextx; j++)
                {
                    if(j<0 || j>=n|| map[j][starty] == 'X')
                    {
                        safe=false;
                        break;
                    }
                }
            }
            
            if (safe)
                {
                    startx = nextx;
                    starty =  nexty;
                    
                }
        }
        
        int[] answer = new int [] {startx,starty};
        
        return answer;
    }
}
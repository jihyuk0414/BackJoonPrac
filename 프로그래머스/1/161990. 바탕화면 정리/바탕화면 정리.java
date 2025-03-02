class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];
        //누적합으로 , 구한다
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int [][] summap = new int [n][m];
        
        int shopcnt = 0;
        
        
        for (int i = 0 ; i<n; i++)
        {
            for (int j = 0; j<m ; j++)
            {
                if(wallpaper[i].charAt(j) == '#')
                {
                    shopcnt +=1;
                }
            }
        }
        
        if (wallpaper[0].charAt(0) == '#')
        {
            summap[0][0] = 1;
        } else {
            summap[0][0] = 0;
        }
        
        for (int j = 1 ; j<m; j++)
        {
            summap[0][j] = wallpaper[0].charAt(j) == '#' ? summap[0][j-1]+1 : summap[0][j-1]; 
        }
        
        for (int i = 1 ; i<n; i++)
        {
            summap[i][0] = wallpaper[i].charAt(0) == '#' ? summap[i-1][0]+1 : summap[i-1][0];  
        }
        
        for (int i = 1 ; i<n; i++)
        {
            for (int j = 1 ; j<m ; j++)
            {
                summap[i][j] = summap[i-1][j]+summap[i][j-1]-summap[i-1][j-1];
                if(wallpaper[i].charAt(j) == '#')
                {
                    summap[i][j] +=1;
                }
            }
        }
        
        int start_minx = 51;
        int start_miny = 51;
        int end_minx = 51;
        int end_miny = 51;
        
        
        for (int i = 0 ; i<n; i++)
        {
            for (int j = 0 ; j<m ; j++)
            {
                if (summap[i][j] == shopcnt)
                {
                    end_minx = Math.min(end_minx,i);
                    end_miny = Math.min(end_miny,j);
                }
                
                if (summap[i][j] >= 1)
                {
                    start_minx = Math.min(start_minx,i);
                    start_miny = Math.min(start_miny,j);
                }
            }
        }
        
        answer[0] = start_minx;
        answer[1] = start_miny;
        answer[2] = end_minx+1;
        answer[3] = end_miny +1;
        
        return answer;
    }
}
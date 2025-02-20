import java.util.*;

class Solution {
    public List<Integer> answerlist = new ArrayList<>() ;
    public int[] solution(int rows, int columns, int[][] queries) {
        

        //x,y -1 , endx,y -1 까지 회전
        
        int [] [] map = new int [rows][columns];
        
        int cnt = 1;
        for (int i = 0 ; i<rows ;i++)
        {
            for (int j = 0 ; j<columns; j++)
            {
                map[i][j] = cnt ;
                cnt +=1;
            }
        }
        
        for (int i = 0 ;i<queries.length; i++)
        {
            int [] oneline = queries[i];
            int startx = oneline[0]-1;
            int starty = oneline[1]-1;
            int endx = oneline[2]-1;
            int endy = oneline[3]-1;
        
            roll(startx,starty,endx,endy,map);
            
        }
        
        int [] answer = new int [answerlist.size()];
        
        for (int i = 0 ; i<answerlist.size(); i++)
        {
            answer[i] = answerlist.get(i);
        }
        
        return answer;
    }
    
    public void roll(int startx, int starty, int endx,int endy, int [][] map)
    {
        if (startx == endx && starty == endy )
        {
            return;
        }
        
        int [][] copymap = new int [map.length][map[0].length];
        int maxval = 100001;
        
        for (int i = 0 ; i<map.length ;i++)
        {
            for (int j = 0 ; j<map[0].length; j++)
            {
                copymap[i][j] = map[i][j] ;
            }
        }
        
        //가로 부터
        for (int j = starty+1 ; j<=endy; j++)
        {
            map[startx][j] = copymap[startx][j-1];
            maxval = Math.min(maxval,map[startx][j]);
        }
        
        for (int i = startx+1 ; i<=endx; i++)
        {
            map[i][endy] = copymap[i-1][endy];
            maxval = Math.min(maxval,map[i][endy]);
        }
        
        for (int j = endy-1 ; j>=starty; j--)
        {
            map[endx][j] = copymap[endx][j+1];
            maxval = Math.min(maxval,map[endx][j]);
        }
        
        for (int i = endx-1 ; i>=startx; i--)
        {
            map[i][starty] = copymap[i+1][starty];
            maxval = Math.min(maxval,map[i][starty]);
        }
        
        
        answerlist.add(maxval);
        
        return;
   }
    
    //void 함수로 ans 넣고 +=1; 하면 적용되나 다시 확인해보자
}
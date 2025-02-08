import java.util.*; 
class Solution {
    public int [] answer = {0,0}; //0,1
    public int [][] globalarr ;
    public int[] solution(int[][] arr) {
        
        globalarr = arr;
        int endx = arr.length -1;
        int endy = arr[0].length -1;
        divideconquer(0,endx,0,endy,(endx+1)*(endy+1));
        
        //복잡도? 
        return answer;
    }
    
    public void divideconquer(int startx, int endx, int starty, int endy , int size)
    {
        if (size ==1)
        {
            int val = globalarr[startx][starty];
            answer[val] +=1;
            return;
        }
        
        boolean flag = checkAreaZeroOrOne(startx,endx,starty,endy);
        
        if (flag)
        {
            int val = globalarr[startx][starty];
            answer[val] +=1;
            return;
        } else {
            int midx = (startx+endx)/2 ;
            int midy = (starty+endy)/2;
            int newsize = size/4;
            divideconquer(startx, midx, starty,midy, newsize);
            divideconquer(midx+1, endx, starty,midy, newsize);
            divideconquer(startx, midx, midy+1,endy, newsize);
            divideconquer(midx+1, endx, midy+1,endy, newsize);
        }
    }
    
    public boolean checkAreaZeroOrOne(int startx ,int endx, int starty, int endy)
    {
        int standard = globalarr[startx][starty];
        
        for (int i = startx; i<=endx; i++)
        {
            for (int j = starty; j<=endy; j++)
            {
                if (globalarr[i][j] != standard)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
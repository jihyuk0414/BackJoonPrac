import java.util.* ; 

class Solution {
    public int[] solution(int brown, int yellow) {
        List<int[]> comparelist = new ArrayList<>();
        
        if (yellow ==1 )
        {
            return new int[] {3,3};
        }
        
        for (int i = 1; i<=(yellow/2); i++)
        {
            if (yellow%i == 0)
            {
                int yellowy = i;
                int yellowx = yellow/i;
                
                if((yellowy+2) * (yellowx+2) - yellow == brown)
                {
                    return new int [] {yellowx+2,yellowy+2};
                }
            }
        }
        
        return null;
    }
    

    
}
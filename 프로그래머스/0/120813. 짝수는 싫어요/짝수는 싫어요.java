import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList <Integer> alist = new ArrayList<>();
        for (int i =0; i<= n; i++)
        {
            if (i%2 == 1 )
            {
                alist.add(i);
            }
        }
        int [] answer = new int[alist.size()];
        
        for(int i=0; i<alist.size(); i++)
        {
            answer[i] = alist.get(i) ;
        }
        
        return answer;
    }
}
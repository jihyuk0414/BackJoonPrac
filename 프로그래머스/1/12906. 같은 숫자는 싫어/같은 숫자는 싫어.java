import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        
        List<Integer> mylist = new ArrayList<>();
        
        int currentnum = -1;
        for(int i = 0 ; i< arr.length; i++)
        {
            if (i == 0 )
            {
                mylist.add(arr[i]);
            }
            
            else{
                if(arr[i] != currentnum)
                {
                    mylist.add(arr[i]);
                }
            }
            
              currentnum = arr[i];
        }
        
        int[]answer = new int[mylist.size()];
        
        for(int j = 0; j<mylist.size(); j++)
        {
            answer[j] = mylist.get(j);
        }

        
        
        

        return answer;
    }
}
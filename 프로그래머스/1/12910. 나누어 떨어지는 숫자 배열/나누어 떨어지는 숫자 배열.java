import java.util.ArrayList ; 
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
   
        ArrayList<Integer> answerlist = new ArrayList<>(); 
        for (int i= 0 ; i<arr.length ; i++)
        {
            if (arr[i]%divisor == 0)
            {
                answerlist.add(arr[i]); 
            }
        }
        
        //answerlist를 answer로 바꾸는 법 
        if (answerlist.size() >= 1)
        {
            int[] answer = new int[answerlist.size()] ;
            
             
         
          for (int i =0; i<answerlist.size(); i++)
          {
            answer[i] = answerlist.get(i) ; 
          }
            
            Arrays.sort(answer) ;
            
             
          return answer;
        
        }
    
        else
        {
            int [] answer = {-1};
            return answer;
 
        }

       
        
       
    }
}
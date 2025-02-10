import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        //dp로, 거기까지의 원소 수를 확인하는 배열 
        int [] dpstart = new int[topping.length];
        int [] dpend = new int [topping.length];
        
        Set<Integer> checkset = new HashSet<>();
        Set<Integer> compareset = new HashSet<>();
        
        for (int i = 0 ; i<topping.length; i++)
        {
            checkset.add(topping[i]);
            dpstart[i] = checkset.size();
        }
        for (int i = topping.length-2; i>= 0; i--)
        {
            compareset.add(topping[i+1]);
            dpend[i] = (compareset.size());
        }
        
        for (int i = 0 ; i< topping.length ; i++)
        {
            if (dpstart[i] == dpend[i])
            {
                answer +=1;
            }
        }

        
        return answer;
    }
}
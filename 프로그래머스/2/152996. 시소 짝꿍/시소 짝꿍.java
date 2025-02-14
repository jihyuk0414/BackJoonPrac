import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Set<Integer> weightset = new HashSet<>();
        long [] canweightbe = new long [4001];
        
        for (int weight : weights)
        {
            canweightbe[weight] +=1;
        }
        
        for (int i = 100 ; i<= 1000 ; i++)
        {
            if (canweightbe[i] >= 2)
            {
                answer += (canweightbe[i] * (canweightbe[i] -1))/2;
                //조합이었음..
            }
        }
        
        for (int i = 100; i <= 1000; i++) {
            if (canweightbe[i] == 0) continue;

            if (i % 2 == 0 && (i * 3 / 2) <= 1000) {
                answer += canweightbe[i] * canweightbe[i * 3 / 2];
            }
 
            if (i * 2 <= 1000) {
                answer += canweightbe[i] * canweightbe[i * 2];
            }

            if (i % 3 == 0 && (i * 4 / 3) <= 1000) {
                answer += canweightbe[i] * canweightbe[i * 4 / 3];
            }
        }
        

        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers) ;
        
        int minmax = numbers[0]*numbers[1];
        
        int maxmax = numbers[numbers.length-1]*numbers[numbers.length-2];
        
        int answer = Math.max(minmax,maxmax) ;
        
        return answer;
    }
}
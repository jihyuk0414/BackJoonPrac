import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Integer[] myarr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Arrays.sort(myarr, Comparator.reverseOrder());
        
        answer = myarr[0]*myarr[1];
        
        return answer;
    }
}
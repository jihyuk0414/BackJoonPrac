import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {

        ArrayList<Integer> answerlist = new ArrayList<>();
        
        for (int i =0; i<my_string.length(); i++)
        {
            char next = my_string.charAt(i);
            if (next <= '9')
            {
                answerlist.add(Character.getNumericValue(next)) ;
            }
        }
        
        int[] answer = new int[answerlist.size()];
        
        for (int j =0 ; j<answerlist.size(); j++)
        {
            answer[j]=answerlist.get(j) ;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}
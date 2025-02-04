import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> wordset = new HashSet<>();
        
        char beforechar = words[0].charAt(words[0].length()-1);
        wordset.add(words[0]);
        
        for (int i = 1; i<words.length; i++)
        {
            String now = words[i];
            
            if (now.charAt(0) != beforechar)
            {
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                answer[1] = (i+1)%n == 0 ? ((i+1)/n) : ((i+1)/n)+1;
                return answer;
            }
            
            if (wordset.contains(now))
            {
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
                answer[1] = (i+1)%n == 0 ? ((i+1)/n) : ((i+1)/n)+1;
                return answer;
            }
            
            wordset.add(now);
            
            beforechar = now.charAt(now.length()-1); 
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);  
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                answer.append(words[i].substring(0, 1).toUpperCase())
                      .append(words[i].substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}
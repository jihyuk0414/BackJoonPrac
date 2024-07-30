import java.util.*;

class Solution {
    public String solution(String my_string) {

        char [] strarr = new char [my_string.length()];
        for (int i= 0 ; i< my_string.length(); i++)
        {
            strarr[i] = Character.toLowerCase(my_string.charAt(i));
        }
        Arrays.sort(strarr);
        String answer = "";
        
        for(int j =0 ; j < strarr.length ; j++)
        {
            answer+= strarr[j];
        }
        return answer;
    }
}
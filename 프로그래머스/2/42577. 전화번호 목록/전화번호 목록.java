import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for (int i= 0; i < phone_book.length-1; i++)
        {
            int strsize = phone_book[i].length();
            if(phone_book[i+1].length() > strsize)
            {
                if(phone_book[i+1].substring(0,strsize).equals(phone_book[i]))
                {
                    answer=false;
                    break;
                }
            }
        }
        
        return answer;
    }
}
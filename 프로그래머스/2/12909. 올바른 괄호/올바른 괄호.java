import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for (int i = 0 ; i<s.length(); i++)
        {
            char nowval = s.charAt(i);
            
            if (nowval == '(')
            {
                st.push(nowval);
            } else {
                if (st.isEmpty())
                {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        
        boolean answer = st.isEmpty() ? true : false;


        return answer;
    }
}
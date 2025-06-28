import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        //sb를 돌면서, 한개씩 회전
        int answer = 0 ;
        int slen = s.length();
        for (int roll = 0 ; roll< slen; roll++)
        {
            char now = sb.charAt(0);
            // 돈 값에 대해서 검사 .
            Stack<Character> st = new Stack<Character>();
            st.push(now);
            for (int i = 1 ; i<sb.length(); i++)
            {
                Character nowchar = sb.charAt(i);
                if (nowchar == ']')
                {
                    if (!st.isEmpty() && st.peek() == '[')
                    {
                        st.pop();
                    }else
                    {
                        st.push(nowchar);
                    }
                } else if (nowchar == '}')
                {
                    if (!st.isEmpty() && st.peek() == '{')
                    {
                        st.pop();
                    }else
                    {
                        st.push(nowchar);
                    }
                } else if (nowchar == ')')
                {
                    if (!st.isEmpty() && st.peek() == '(')
                    {
                        st.pop();
                    }else
                    {
                        st.push(nowchar);
                    }
                } else
                {
                    st.push(nowchar);
                }
            }

            if(st.isEmpty())
            {
                answer +=1;
            }
            
            sb.deleteCharAt(0);
            sb.append(now);
            
        }
        
    
        return answer;
    }
}
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Queue<Character> charq = new LinkedList<>();
        int leftcnt = 0;
        for (int i = 0; i<s.length();i++)
        {
            charq.add(s.charAt(i));
        }
        
        if(charq.size()%2 != 0 )
        {
            //일단 홀수면 불가능함.
            return false;
        }
        
        while(!charq.isEmpty())
        {
            char topval = charq.poll();
            if(topval == '(')
            {
                
                if(!charq.isEmpty())
                {
                   char nextval = charq.peek();
                    if(nextval==')')
                    {
                        charq.poll();
                    }else{
                        leftcnt+=1;
                    }
                }
                else{
                    return false;
                }
                
            }
            
            else {
                //)라면
                if(leftcnt<=0)
                {
                    answer = false;
                    break;
                }
                leftcnt-=1;
            }
        }

        if(leftcnt !=0)
        {
            answer = false;
        }
        
        
        
        return answer;
    }
}
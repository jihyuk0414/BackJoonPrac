import java.util.*;
class Solution {
    
    public char [] point = new char [] {'1','2','3','4','5','6','7','8','9','0'};
    public char [] bonus = new char[] {'S','D','T'}; //idx+1 제곱
    public char [] option = new char[] {'*','#'} ;
    public int answer=  0 ;
    public int before = 0 ;
    public int solution(String dartResult) {
        StringBuilder sb=  new StringBuilder();
        for (int i = 0; i<dartResult.length(); i++)
        {
            char now = dartResult.charAt(i);
            sb.append(now);
            if (findidx(now, bonus) != -1 && i<dartResult.length()-1 && findidx(dartResult.charAt(i+1),option) == -1) {
            int nowval = calculate(sb.toString());
            answer += nowval;
            before = nowval;
            System.out.println("nowval : " + nowval + " ans : " + answer);
            sb.setLength(0);
            }
        // 옵션(*,#)도 계산 시작
        else if (findidx(now, option) != -1) {
            int nowval = calculate(sb.toString());
            answer += nowval;
            before = nowval;
            System.out.println("nowval : " + nowval + " ans : " + answer);
            sb.setLength(0);
        }
        }
        
        int nowval = calculate(sb.toString());
                    answer += nowval;
                    before = nowval;
                    System.out.println("nowval : "+nowval+ " ans : "+ answer);
        
        
        return answer;
    }
    
    public int calculate(String ans)
    {
        int val = 0 ;
        StringBuilder num = new StringBuilder();
        for (int i = 0 ; i<ans.length() ; i++)
        {
            char now = ans.charAt(i);
           if (findidx(now,point) != -1)
           {
               num.append(now);
           } else if (findidx(now,bonus) != -1)
           {
                val = Integer.parseInt(num.toString());  
                val = (int) Math.pow(val, findidx(now, bonus) + 1);
                num.setLength(0);
           } else if (findidx(now,option)!=-1)
           {
              if (now == '*')
              {
                  answer += before;
                  val *= 2;
              } else {
                  val = (0-val);
              }
           }
        }
        
        if (num.length() > 0) {
            val = Integer.parseInt(num.toString());
        }

        
        return val;
    }
    
    public int findidx (char val , char [] target)
    {
        for (int i = 0 ; i<target.length; i++)
        {
            
        if (target[i] == val)
        {
            return i;
        }
        }
        return -1;
    }
}
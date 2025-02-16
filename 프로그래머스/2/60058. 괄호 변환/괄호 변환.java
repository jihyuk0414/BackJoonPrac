import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        boolean balanceStr = isItBalance(p);
        boolean correctStr = isItCorrect(p);
        
        if (correctStr || p.equals(""))
        {
            return p;
        }
        
        StringBuilder sb = new StringBuilder();
        
        return dojob(p,sb);
    
    }
    
    public int divideidx(String target) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
        if (target.charAt(i) == '(') count++;
        else count--;
        if (count == 0) return i;
        }
    return -1;
    }
    
    public String dojob(String target, StringBuilder sb)
{
    if (target.equals(""))
    {
        return "";
    }
    
    int divideIdx = divideidx(target);
    String u = target.substring(0, divideIdx+1);
    String v = target.substring(divideIdx+1);
    
    if (isItCorrect(u))
    {
        return u + dojob(v, new StringBuilder()); 
    } 
    else 
    {
        StringBuilder temp = new StringBuilder();
        temp.append('(');
        temp.append(dojob(v, new StringBuilder()));
        temp.append(')');
        
        for (int i = 1; i < u.length()-1; i++)
        {
            if (u.charAt(i) == '(')
            {
                temp.append(')');
            } 
            else 
            {
                temp.append('(');
            }
        }
        return temp.toString();
    }
}
    
    public boolean isItBalance(String line)
    {
        int openCnt = 0 ;
        int closeCnt = 0 ;
        for (int i = 0 ; i<line.length(); i++)
        {
            if (line.charAt(i) == '(')
            {
                openCnt +=1;
            } else {
                closeCnt +=1;
            }
        }
        
        return openCnt == closeCnt;
    }
    
    public boolean isItCorrect(String line)
    {
        Queue<Character> q = new LinkedList<>();
        
        for (int i = 0 ; i<line.length() ; i++)
        {
            if (line.charAt(i) == '(')
            {
                q.add(line.charAt(i));
            } else {
                if (q.isEmpty())
                {
                    return false;
                } 
                q.poll();
            }
        }
        
        boolean isittrue = q.isEmpty() ? true : false;
        
        return isittrue;
    }
}
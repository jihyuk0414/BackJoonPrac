import java.util.*;

class Solution {
    List<String> strlist = new ArrayList<>();
    char[] aeiou = new char[]{'A','E','I','O','U'};
    public int solution(String word) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        allfind(0,sb);
        
        for (int i =0; i<strlist.size(); i++)
        {
            if (word.equals(strlist.get(i)))
            {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
    
    public void allfind(int depth, StringBuilder sb)
    {
        if(depth == 5)
        {
            return; 
        }
        
        for (int i = 0 ; i<5;  i++)
        {
            sb.append(aeiou[i]);
            strlist.add(sb.toString());
            allfind(depth+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
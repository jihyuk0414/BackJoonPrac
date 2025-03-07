import java.util.*;

class Solution {
    
    public char [] mom = new char [] {'A','E','I','O','U'};
    public List<String> strlist = new ArrayList<>();
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        findstr(word,sb,0);
        for (int i = 0 ; i<strlist.size(); i++)
        {
            if (word.equals(strlist.get(i)))
            {
                return i+1;
            }
        }
        return 0;
    
    }
    
    public void findstr (String target, StringBuilder before, int depth)
    {
        if(depth == 5)
        {
            return;
        }
        
        
        for (int i = 0 ; i<5; i++)
        {
            before.append(mom[i]);
            strlist.add(before.toString());
            findstr(target,before,depth+1);
            before.deleteCharAt(before.length()-1);
        }
        
    }
}
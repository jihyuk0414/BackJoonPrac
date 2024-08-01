import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> myarr = new ArrayList<>() ; 
        int cnt = 0 ;
        String newstr = "";
        for (int i = 0 ; i<my_str.length(); i++)
        {
            cnt +=1 ; 
            
            newstr+= my_str.charAt(i);
            
            if (cnt == n )
            {
                myarr.add(newstr);
                cnt = 0 ;
                newstr = "";
                continue; 
            }
            
            if (i == my_str.length()-1)
            {
                myarr.add(newstr);
            }
            
        }
        String[] answer = new String[myarr.size()];
        for (int i = 0 ; i <myarr.size(); i ++)
        {
            answer[i] = myarr.get(i);
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public List<Character> english = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1list = new ArrayList<>();
for (int i = 1; i < str1.length(); i++) {
    String pair = (str1.charAt(i-1) + "" + str1.charAt(i)).toLowerCase();
    if (pair.matches("[a-z]{2}")) { 
        str1list.add(pair);
    }
}

List<String> str2list = new ArrayList<>();
for (int i = 1; i < str2.length(); i++) {
    String pair = (str2.charAt(i-1) + "" + str2.charAt(i)).toLowerCase();
    if (pair.matches("[a-z]{2}")) {
        str2list.add(pair);
    }
}
        
        
        if (str1list.size() == 0 && str2list.size() == 0)
        {
            return 65536;
        } 
        
        if (str1list.size() == 0 || str2list.size() == 0)
        {
            return 0;
        }
        
        List<String> samelist = new ArrayList<>();
        List<String> list2save = new ArrayList<>(str2list);
        
        
        for (int i = 0 ;i<str1list.size(); i++)
        {
            if (list2save.contains(str1list.get(i)))
            {
                samelist.add(str1list.get(i));
                list2save.remove(str1list.get(i));
            }
        }
        
        if (samelist.size() ==0 )
        {
            return 0;
        }
        
        
        double val = (double) samelist.size() / (str1list.size()+str2list.size()-samelist.size());
        
        //기호,숫자 제거 
        return (int)(val*65536);
    }
}
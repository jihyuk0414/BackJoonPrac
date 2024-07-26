import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        
        for (int i =0 ; i<s1.length; i++)
        {
            set1.add(s1[i]);
        }
        
                
        for (int j =0 ; j<s2.length; j++)
        {
            set2.add(s2[j]);
        }
        
        set1.retainAll(set2);
        
        return set1.size();
    }
}
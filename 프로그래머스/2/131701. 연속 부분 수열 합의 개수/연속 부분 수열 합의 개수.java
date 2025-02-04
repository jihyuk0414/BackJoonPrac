import java.util.*; 

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int [] circle = new int [elements.length*2];
       
        for (int i = 0 ; i<elements.length; i++)
        {
            circle[i] = elements[i];
            circle[elements.length+i] = elements[i];
        }
        
        Set<Integer> answerset = new HashSet<>();

        for (int i = 0; i<elements.length; i++)
        {
            int cnt =  0;
            for (int j = 0; j< elements.length; j++)
            {
                cnt += circle[i+j];
                answerset.add(cnt);
            }
        }
        
        
        return answerset.size();
    }
}
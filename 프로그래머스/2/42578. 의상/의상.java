import java.util. *;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> mymap = new HashMap<>();
        
        for (int i = 0 ; i<clothes.length; i++)
        {
            String what = clothes[i][0];
            String key = clothes[i][1];
            
            mymap.put(key,mymap.getOrDefault(key,0)+1);
        }
        
        for (String key : mymap.keySet())
        {
            answer *= mymap.get(key)+1;
        }
        
        

        
        return answer-1;
    }
}
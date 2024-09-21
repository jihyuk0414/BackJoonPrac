import java.util.*; 
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int smallindex = 0;
        int bigindex = people.length -1 ;
        
        while (smallindex <= bigindex)
        {
            if (people[smallindex]+people[bigindex] <= limit)
            {
                smallindex +=1 ;
            }
            
            bigindex -= 1;
            
            answer+=1 ;
        }
        return answer;
    }
}
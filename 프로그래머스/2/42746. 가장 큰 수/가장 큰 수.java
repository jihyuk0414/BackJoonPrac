import java.util.* ;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String [] strnum = new String [numbers.length];
        
               
        for(int i = 0 ; i<strnum.length; i++)
        {
            strnum[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strnum, (o1,o2) -> 
                   (o2+o1).compareTo(o1+o2)) ;
        
        if(Integer.parseInt(strnum[0]) ==0 )
        {
            return "0";
        }
        
        
        for(int i = 0 ; i<strnum.length; i++)
        {
            answer += strnum[i];
        }
        return answer;
    }
}
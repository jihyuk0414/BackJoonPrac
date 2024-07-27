import java.util.* ;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        ArrayList<Integer> intarr = new ArrayList<>();
        
        for (int i = 0 ; i<numlist.length; i++)
        {
            if (numlist[i]%n == 0 )
            {
                intarr.add(numlist[i]);
            }
        }
        
        int[] answer = new int[intarr.size()];
        
        for (int i =0 ;i<answer.length ; i++)
        {
            answer[i] = intarr.get(i);
        }
        
        return answer;
    }
}
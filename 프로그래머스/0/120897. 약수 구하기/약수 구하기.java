import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList <Integer> mylist = new ArrayList<>();
        
        for(int i =1 ; i<n+1; i++)
        {
            if (n%i ==0 )
            {
                mylist.add(i);
            }
        }
        int [] answer = new int[mylist.size()];
        for (int j = 0 ; j<mylist.size(); j++)
        {
            answer[j] = mylist.get(j);
        }
        return answer;
    }
}
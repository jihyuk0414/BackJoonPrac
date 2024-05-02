import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> threearr = new ArrayList<>() ;
        while (n>0)
        {
            threearr.add(n%3);
            n = n /3; 
        }
        
        System.out.println(threearr);
      
        for (int i =0 ; i <threearr.size(); i++)
        {
            answer += threearr.get(i)*Math.pow(3,threearr.size()-1-i);
            System.out.println(threearr.size()-1-i);
        }
       
        
        return answer;
    }
}
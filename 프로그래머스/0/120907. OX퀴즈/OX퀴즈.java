import java.util.*  ;

class Solution {
    public String[] solution(String[] quiz) {
        ArrayList<String> resultsub= new ArrayList<>();
        
        for (int i =0; i<quiz.length; i++)
        {
            String [] newarr = quiz[i].split(" ");
            int cnt = Integer.parseInt(newarr[0]);
            for (int j =1 ; j<newarr.length; j++)
            {
                
                if(newarr[j].equals("-"))
                {
                    cnt -= Integer.parseInt(newarr[j+1]);
                }
                else if(newarr[j].equals("+"))
                {
                    cnt += Integer.parseInt(newarr[j+1]);
                }

            }
            
            if (cnt == Integer.parseInt(newarr[newarr.length - 1])) {
                resultsub.add("O");
            } else {
                resultsub.add("X");
            }
        }
        String [] answer = new String [resultsub.size()] ;
        for(int j = 0;j<answer.length; j++)
        {
            answer[j] = resultsub.get(j);
        }
        
        return answer;
    }
}
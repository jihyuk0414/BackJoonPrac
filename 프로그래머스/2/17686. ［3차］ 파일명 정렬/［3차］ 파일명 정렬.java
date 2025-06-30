import java.util.*;

class Solution {
    List<String []> answerlist = new ArrayList<>();
    public String[] solution(String[] files) {
        for (int i = 0 ; i<files.length; i++)
        {
            String now = files[i];
            
            int start = 0;
            while (start < now.length() && !Character.isDigit(now.charAt(start))) {
                start++;
            }
            
            String head = now.substring(0, start);
            
            int next = start;
            while (next < now.length() && Character.isDigit(now.charAt(next))) {
                next++;
            }
            
            String number = now.substring(start, next);
            String tail = (next == now.length() ? "" : now.substring(next));
            
            answerlist.add(new String[]{head, number, tail});
        }
        
        Collections.sort(answerlist, 
                        (a,b) ->
                         {
                            if (a[0].toUpperCase().equals(b[0].toUpperCase()))
                            {
                                if (Integer.parseInt(a[1]) == Integer.parseInt(b[1]))
                                {
                                    return 0;
                                }
                                
                                return Integer.parseInt(a[1])-Integer.parseInt(b[1]);
                            }
                            return a[0].toUpperCase().compareTo(b[0].toUpperCase());
                         });

        String[] answer = new String[files.length];
        for (int i = 0; i < answerlist.size(); i++) {
            String[] parts = answerlist.get(i);
            answer[i] = parts[0] + parts[1] + parts[2];
        }
        
        return answer;
    }
}
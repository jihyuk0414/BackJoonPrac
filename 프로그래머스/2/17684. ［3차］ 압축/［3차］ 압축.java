import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answerlist = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        char start = 'A';
        int startint = 1 ;
        
        for (int i = 1 ; i<= 26; i++)
        {
            map.put(start+"",startint);
            startint +=1;
            start +=1;
        }
        
        Queue<Character> msgq = new LinkedList<>();
        
        for (int i = 0 ; i<msg.length(); i++)
        {
            msgq.add(msg.charAt(i));
        }
        
        StringBuilder nowsb = new StringBuilder();
        int nowsbval = 0;
        
        for (int i = 0 ; i<msg.length() ; )  
        {
            int startidx = i;
            int endidx = startidx+1 ;
            
            while(endidx <= msg.length() && map.keySet().contains(msg.substring(startidx,endidx)))
            {
                endidx +=1;
            }
            answerlist.add(map.get(msg.substring(startidx,endidx-1)));
            
            i += (endidx - 1 - startidx);
            
            if (endidx <= msg.length()) {
                map.put(msg.substring(startidx,endidx),startint);
                startint+=1;
            }
        }
        
        int [] answer = new int [answerlist.size()];
        for (int i = 0 ; i<answerlist.size(); i++)
        {
            answer[i] = answerlist.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    
    public String[] solution(String[] record) {

        List<String[]> chatting = new ArrayList<>();
        // id, 한 일 순
        Map<String,String> nicknamemap = new HashMap<>(); //id,닉네임
        
        for (int i = 0 ; i<record.length ; i++)
        {
            String [] oneline = record[i].split(" ");
            String whattodo = oneline[0];
            String id = oneline[1];
            
            if (whattodo.equals("Enter"))
            {
                String nick = oneline[2];
                String [] insert = {id,whattodo};
                //들어올때도 닉네임 바뀜 . 
                nicknamemap.put(id,nick);
                chatting.add(insert);
            }
            
            else if (whattodo.equals("Leave"))
            {
                String [] insert = {id,whattodo};
                chatting.add(insert);
            } else
            {
                //닉네임 변경
                String nick = oneline[2];
                nicknamemap.put(id,nick);
            }
        }
        
        String [] answer = new String [chatting.size()];

                
        for (int i = 0 ; i<chatting.size(); i++)
            {
                String [] now = chatting.get(i);
                if (now[1].equals("Enter"))
                {
                    answer[i] = nicknamemap.get(now[0])+"님이 들어왔습니다.";
                } else {
                    answer[i] = nicknamemap.get(now[0])+"님이 나갔습니다.";
                }
            }
        
        return answer;
    }
}
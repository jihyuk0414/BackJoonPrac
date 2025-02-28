import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<int []>> map = new HashMap<>();
        Map<String, Integer> totalcnt = new HashMap<>(); //합계를 확인 
        for (int i = 0 ; i<genres.length; i++)
        {
            totalcnt.put(genres[i],totalcnt.getOrDefault(genres[i],0)+plays[i]);
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }
            map.get(genres[i]).add(new int[] {i, plays[i]});
        }
        
        // sum 대로 정렬 하고 
        List<String> totalkey = new ArrayList<>(totalcnt.keySet());
        Collections.sort(totalkey, (a,b) -> {
            return totalcnt.get(b)-totalcnt.get(a);
        });
        
        for (String key : map.keySet())
        {
            Collections.sort(map.get(key), (a,b) ->
                             {
                                 if (a[1]==b[1])
                                 {
                                     return a[0]-b[0];
                                 }else {
                                     return b[1]-a[1];
                                 }
                             });
        }
        
                         
        List<Integer> answerlist = new ArrayList<>();

                         
        for (String key : totalkey)
        {
            List<int []> now = map.get(key);
            for (int i = 0 ; i<Math.min(now.size(),2); i++)
            {
                answerlist.add(now.get(i)[0]);
            }
                        
        }
        
        int[] answer = new int [answerlist.size()];
        for(int i = 0; i<answer.length; i++)
                         {
                             answer[i] = answerlist.get(i);
                         }
        
        return answer;
    }
}
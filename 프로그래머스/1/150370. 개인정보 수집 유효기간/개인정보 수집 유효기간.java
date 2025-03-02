import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerlist = new ArrayList<>();
        
        String[] todaysplit = today.split("\\.");
        int todayY = Integer.parseInt(todaysplit[0]);
        int todayM = Integer.parseInt(todaysplit[1]);
        int todayD = Integer.parseInt(todaysplit[2]);
        int todayDays = todayY * 12 * 28 + todayM * 28 + todayD;
        
        Map<String, Integer> termmap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] termarr = terms[i].split(" ");
            termmap.put(termarr[0], Integer.parseInt(termarr[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] first = privacies[i].split(" ");
            String termType = first[1];
            
            String[] date = first[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            
            int validMonths = termmap.get(termType);
            
            int expireDays = year * 12 * 28 + month * 28 + day + validMonths * 28 - 1;
            
            if (expireDays < todayDays) {
                answerlist.add(i + 1); 
            }
        }
        
        int[] answer = new int[answerlist.size()];
        for (int i = 0; i < answerlist.size(); i++) {
            answer[i] = answerlist.get(i);
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public Map<Integer, Map<String,Integer>> answermap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();
        
        // 각 주문을 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        // 각 코스 길이별로 조합 생성
        for (int courselen : course) {
            answermap.put(courselen, new HashMap<>());
            createmap(courselen, orders);
            
            // 해당 코스 길이에서 가장 많이 주문된 조합 찾기
            Map<String, Integer> combinations = answermap.get(courselen);
            if (!combinations.isEmpty()) {
                int max = Collections.max(combinations.values());
                if (max >= 2) { // 최소 2번 이상 주문된 경우만
                    for (Map.Entry<String, Integer> entry : combinations.entrySet()) {
                        if (entry.getValue() == max) {
                            answerList.add(entry.getKey());
                        }
                    }
                }
            }
        }
        
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }
    
    public void createmap(int courselen, String[] orders) {
        // 각 주문에 대해 조합 생성
        for (String order : orders) {
            combination("", order, 0, courselen);
        }
    }
    
    private void combination(String current, String order, int start, int courselen) {
        if (current.length() == courselen) {
            Map<String, Integer> courseMap = answermap.get(courselen);
            courseMap.put(current, courseMap.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            combination(current + order.charAt(i), 
                       order, 
                       i + 1, 
                       courselen);
        }
    }
}
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> mymap = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            mymap.put(tangerine[i], mymap.getOrDefault(tangerine[i],0)+1);
        }
        
        // 개수 기준 내림차순 정렬
        List<Integer> values = new ArrayList<>(mymap.values());
        Collections.sort(values, Collections.reverseOrder());
        
        int sum = 0;
        int count = 0;
        for (int v : values) {
            sum += v;
            count++;
            if (sum >= k) {
                return count;
            }
        }
        
        return count;
    }
}
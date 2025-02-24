import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> xmap = new HashMap<>();
        Map<Character, Integer> ymap = new HashMap<>();
        
        // 이 부분은 유지 (HashMap 사용)
        for (int i = 0 ; i<X.length(); i++) {
            xmap.put(X.charAt(i), xmap.getOrDefault(X.charAt(i),0)+1);
        }
        for (int i = 0 ; i<Y.length(); i++) {
            ymap.put(Y.charAt(i), ymap.getOrDefault(Y.charAt(i),0)+1);
        }
        
        // String 대신 StringBuilder 사용
        StringBuilder sum = new StringBuilder();
        
        for (char key : xmap.keySet()) {
            if (ymap.keySet().contains(key)) {
                int count = Math.min(xmap.get(key), ymap.get(key));
                for (int i = 0; i < count; i++) {
                    sum.append(key);
                }
            }
        }
        
        if (sum.length() == 0) {
            return "-1";
        }
        
        // String을 char array로 변환하여 정렬
        char[] chars = sum.toString().toCharArray();
        Arrays.sort(chars);
        
        // 결과 생성을 위해 StringBuilder 사용
        StringBuilder answer = new StringBuilder();
        boolean onlyzero = false;
        
        for (int i = chars.length - 1; i >= 0; i--) {
            answer.append(chars[i]);
            if (chars[i] != '0') {
                onlyzero = true;
            }
        }
        
        if(!onlyzero) {
            return "0";
        }
        
        return answer.toString();
    }
}
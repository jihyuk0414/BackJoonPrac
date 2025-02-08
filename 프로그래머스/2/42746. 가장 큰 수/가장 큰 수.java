import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // Python의 x*3 개념을 동일하게 적용
        Arrays.sort(strNumbers, (a, b) -> {
            return (b + b + b).compareTo(a + a + a);
        });
        
        // 모든 숫자가 0인 경우 처리
        if(strNumbers[0].equals("0")) {
            return "0";
        }
        
        // 문자열 이어붙이기
        StringBuilder answer = new StringBuilder();
        for(String str : strNumbers) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}
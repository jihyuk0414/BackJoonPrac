class Solution {
    public int solution(int num, int k) {
        // 숫자를 문자열로 변환
        String numString = String.valueOf(num);
        
        // 문자열에서 숫자를 찾고 그 위치를 반환
        for (int i = 0; i < numString.length(); i++) {
            // 현재 문자에서 숫자 추출
            int currentDigit = Character.getNumericValue(numString.charAt(i));
            
            // 숫자가 찾고자 하는 숫자와 같은지 비교
            if (currentDigit == k) {
                // 1-based 인덱스를 반환
                return i + 1;
            }
        }
        
        // 숫자를 찾지 못한 경우 -1 반환
        return -1;
    }
}
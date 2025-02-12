class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        int[] dp = new int[n];  // dp[i]: i위치 이후에 있는 첫 번째 큰 수의 위치
        
        // 마지막 원소는 항상 -1
        answer[n-1] = -1;
        dp[n-1] = -1;
        
        // 뒤에서부터 순회
        for(int i = n-2; i >= 0; i--) {
            int j = i + 1;  // 바로 다음 위치부터 확인
            
            // 현재 숫자보다 큰 수를 찾을 때까지 계속 다음 위치로 이동
            while(j != -1 && numbers[i] >= numbers[j]) {
                j = dp[j];
            }
            
            dp[i] = j;  // i위치 이후의 첫 번째 큰 수의 위치 저장
            answer[i] = (j == -1) ? -1 : numbers[j];
        }
        
        return answer;
    }
}
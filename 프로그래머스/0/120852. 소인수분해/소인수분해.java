import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> factors = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // 중복 제거된 소인수들을 정렬하여 배열에 저장
        int[] answer = new int[factors.size()];
        int index = 0;
        for (int factor : factors) {
            answer[index++] = factor;
        }
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 24;
        int[] result = solution.solution(n);
        System.out.println(Arrays.toString(result)); // [2, 3]
    }
}

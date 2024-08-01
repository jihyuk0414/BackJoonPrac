import java.util.* ; 

class Solution {
    public int solution(int[] array, int height) {
         Integer[] integerArray = Arrays.stream(array).boxed().toArray(Integer[]::new);

        // Step 2: 내림차순으로 정렬
        Arrays.sort(integerArray, Collections.reverseOrder());

        // Step 3: 다시 int[]로 변환
        int[] sortedArray = Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
        int answer = 0;
        for (int value : sortedArray) {
            if (value > height) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
        
    }
}
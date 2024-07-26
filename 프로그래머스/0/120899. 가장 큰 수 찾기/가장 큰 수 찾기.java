class Solution {
    public int[] solution(int[] array) {
        int[] answer = {0,0};
        int maxval = 0;
        int maxindex = 0;
        for (int i=0 ; i <array.length; i++)
        {
            if (array[i] >= maxval) 
            {
                maxval = array[i];
                maxindex = i;
            }
        }
        answer[0] = maxval;
        answer[1] = maxindex;
        return answer;
    }
}
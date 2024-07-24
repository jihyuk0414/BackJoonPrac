class Solution {
    public int solution(int[] array, int n) {
        int answer = Integer.MAX_VALUE;
        int realanswer = -1;
        for (int i = 0 ; i<array.length; i++)
        {
            int val = Math.abs(array[i]-n);
            int saveans = answer;
            
            if (val == answer)
            {
                realanswer = Math.min(realanswer,array[i]);
                continue;
            }
            answer = Math.min(val,answer);
            
            if (answer != saveans)
            {
            
                realanswer = array[i];
            }
        }
        return realanswer;
    }
}
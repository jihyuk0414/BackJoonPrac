class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        long longanswer = 0;
        
        for (int i =0 ; i < a.length ; i++)
        {
            longanswer += (long) (a[i]*b[i]);
        }
        answer  = (int) longanswer;
        return answer;
    }
}
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int i = 0 ; i<array.length; i ++)
        {
            String newstrr = String.valueOf(array[i]);
            for (int j =0; j<newstrr.length(); j++)
            {
                if (newstrr.charAt(j) == '7' )
                {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i =0; i<my_string.length();i++)
        {
            char next = my_string.charAt(i);
            if (next <= '9')
            {
                int nextint = Character.getNumericValue(next);
                answer+=nextint;
            }
        
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i =0; i<my_string.length(); i++)
        {
            Character next = my_string.charAt(i);
            if ((next == 'a') || (next == 'e') || (next == 'i') || (next== 'o') || (next=='u'))
            {
                continue;
            }
            else
            {
                answer+= String.valueOf(next);
            }
        }
        return answer;
    }
}
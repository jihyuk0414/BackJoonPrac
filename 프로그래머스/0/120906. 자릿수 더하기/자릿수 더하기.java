class Solution {
    public int solution(int n) {
        int answer = 0;
        String newn = String.valueOf(n);
        
        for (int i =0; i< newn.length() ; i++)
        {
            int x = Character.getNumericValue(newn.charAt(i));
            answer += x;
        }
        return answer;
    }
}
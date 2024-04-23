class Solution {
    public int solution(int n) {
        int answer = 0;
        double howmany = (double) n / (double) 7;
        
        answer = (int) Math.ceil(howmany);

        return answer;
    }
}
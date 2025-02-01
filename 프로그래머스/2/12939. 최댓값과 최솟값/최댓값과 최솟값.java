class Solution {
    public String solution(String s) {
        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        String [] sarr = s.split(" ");
        
        for (int i = 0 ; i<sarr.length; i++)
        {
            int now = Integer.parseInt(sarr[i]);
            minval = Math.min(minval, now);
            maxval = Math.max(maxval, now);
        }
        String answer = minval + " "+ maxval;
        return answer;
    }
}
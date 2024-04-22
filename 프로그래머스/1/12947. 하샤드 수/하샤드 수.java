class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String xstr = Integer.toString(x);
        int zaresum = 0;
        for (int i =0; i<xstr.length(); i++)
        {
            zaresum += Integer.parseInt(String.valueOf(xstr.charAt(i))) ;
        }
        
        if(x%zaresum == 0)
        {
            answer = true;
        }
        else{
            answer = false;
        }
        
        return answer;
    }
}
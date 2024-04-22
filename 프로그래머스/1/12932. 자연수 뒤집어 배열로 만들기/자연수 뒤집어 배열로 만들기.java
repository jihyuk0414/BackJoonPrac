class Solution {
    public int[] solution(long n) {
        String nstr = Long.toString(n); 
        int nnum = nstr.length(); //nnum의 길이를 구해서 
        
        int[] answer = new int[nnum] ;
        
        for (int i =0 ; i<nnum; i++)
        {
            answer[i] = Integer.parseInt(String.valueOf(nstr.charAt(nnum-i-1))) ; 
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[] common) {
        int cnt = common[1]-common[0];
        boolean plus = true;
        
        for (int i = 2; i< common.length; i++)
        {
            if (!plus)
            {
                break;
            }
            if (common[i] - common[i-1] != cnt)
            {
                cnt = (common[i] / common[i-1]);
                plus = false;
            }
        }
        
        System.out.println("cnt "+ cnt+ " plus " + plus) ;
        
        int answer = plus ? common[common.length-1]+cnt : common[common.length-1]*cnt;
        return answer;
    }
}
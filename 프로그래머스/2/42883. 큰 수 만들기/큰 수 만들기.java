class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int deletecnt = 0 ;
        for (int i = 0 ; i<number.length() ; i++)
        {
            
            while (
                sb.length() > 0 && 
                Character.getNumericValue(number.charAt(i)) >Character.getNumericValue(sb.charAt(sb.length()-1)))
            {
                if (deletecnt >= k)
                {
                    break;
                }
                
                sb.deleteCharAt(sb.length()-1); //가장 마지막꺼 제거 
                deletecnt+=1;
            }
           
            sb.append(number.charAt(i));
            
        }
        
        if (deletecnt <k)
        {
            while (deletecnt < k )
            {
                sb.deleteCharAt(sb.length() -1);
                deletecnt+=1;
            }
        }
        
        return sb.toString();
    }
}
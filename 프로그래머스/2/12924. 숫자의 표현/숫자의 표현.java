class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1; 
        int end = 1;
        int checkval = 1;
        while (end<= (n))
        {
            if (checkval <n)
            {
                //모자르다
                end +=1;
                checkval += end;
            } else if (checkval == n )
            {
                answer +=1;  
                end +=1;
                checkval += end;
            }  else {
                //값이 크다
                checkval -= start;
                start +=1;
            }
            
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int nonecnt = onecnt(n);
        int nextn = n+1;
        int answer = 0 ;
        while (nextn <= 1000000)
        {
            if (onecnt(nextn) == nonecnt)
            {
                answer = nextn ; break;
            }
            
            nextn +=1;
        }
        return answer;
    }
    
    public int onecnt (int val)
    {
        int oneval = 0;
        
        while (val >0)
        {
            if (val%2 ==1 )
            {
                oneval +=1;
            }
            val /= 2;
        }
        return oneval;
    }
}
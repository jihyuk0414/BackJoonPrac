class Solution {
    public int solution(int[] stones, int k) {
        
        //건널 수 있는 사람의 수를 기준으로 bs
        
        int start = 1;
        int end = 200000000; 
        
        while (start<=end)
        {
            int mid = (start) + (end-start)/2;
            if (cango(stones,k,mid))
            {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        
        return end;
    }
    
    public boolean cango (int [] stones, int k , int person)
    {
        int zerocnt = 0 ;
        
        for (int val : stones)
        {
            if (val >= person)
            {
                zerocnt = 0 ;
            } else {
                zerocnt +=1;
            }
            
            if (zerocnt >= k)
            {
                return false;
            }
        }
        
        return true;
        
    }
}
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int [2];
        
        int [] twopoint = new int[sequence.length+1];
        
        for (int i = 0 ; i<sequence.length; i++)
        {
            twopoint[i] = sequence[i];
        }
        
        int start = 0 ;
        int end = 0 ;
        long cnt = sequence[end];
        
        int answerlen = 1000001; //길이를 의미
        int minstart = 0;
        int minend=  0;
        
        while (end < sequence.length && start < sequence.length)
        {
            if (cnt >k)
            {
                cnt -= twopoint[start];
                start+=1;
            } else if (cnt <k) {
                end +=1;
                cnt += twopoint[end];
            } else {
                //같다면
                if (answerlen > end-start+1)
                {
                    minstart = Math.min(start,end);
                    minend = Math.max(start,end);
                    answerlen = end-start+1;
                }
                cnt -= twopoint[start];
                start +=1;
            }
        }
        
        answer[0] = minstart;
        answer[1] = minend;
        
        
        return answer;
    }
}
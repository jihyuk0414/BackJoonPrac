
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = stations[0]-w;
        int end = stations[0]+w;
        if (start >1)
        {
            //왼쪽만 체크하자.
            int between = (start-1) - 0 ; 
            answer += (Math.ceil((double)between / (2*w+1)));
        }
        //BS로 가야될거같다. 복잡도가 너무 큼
        for (int i = 1 ; i<stations.length; i++)
        {
            start = stations[i]-w;
            if (start - end -1 >0)
            {
                int between = (start-end-1) - 0 ; 
                answer += (Math.ceil((double)between / (2*w+1)));
            }
            end = stations[i]+w;
        }
        
        if (n - end >0)
        {
            int between = (n-end) - 0 ; 
            answer += (Math.ceil((double)between / (2*w+1)));            
        }

        return answer;
    }
}
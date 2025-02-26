import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        boolean [] visited = new boolean[B.length];
        
        int bindex = 0;
        for (int i = 0 ; i<A.length ; i++)
        {
            while (bindex<B.length)
            {
                if (!visited[bindex])
                {
                    //아직 안쓴거라면 
                    if (B[bindex] > A[i])
                    {
                        visited[bindex] = true;
                        bindex +=1;
                        break;
                    } else {
                        //이기지 못했다면
                        bindex +=1;
                    }
                } else {
                    bindex +=1;
                }
            }
        }
        
        for (int i = 0 ;i<visited.length; i++)
        {
            if (visited[i])
            {
                answer +=1;
            }
        }
        
        
        return answer;
    }
}
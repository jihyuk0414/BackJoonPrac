import java.util.*; 
class Solution
{
    public int solution(int []A, int []B)
    {
        Integer [] Barr =new Integer [B.length];
        for (int i = 0 ; i<B.length; i++)
        {
            Barr[i] = B[i];
        }
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(Barr, Collections.reverseOrder());
        
        for (int i = 0 ; i<A.length ; i++)
        {
            answer += (A[i]*Barr[i]);
        }

        return answer;
    }
}


class Solution {
    public int solution(int n) {
        int answer = 0;
        int gcd = gcd(n,6);
        int gmd = n*6/gcd ; 
        
        answer = gmd/6 ;
        return answer;
    }
    
    private static int gcd(int a, int b)
{
    if (b==0)
    {
        return a;
    }
    else
    {
        return gcd(b,a%b) ;
    }
}
}

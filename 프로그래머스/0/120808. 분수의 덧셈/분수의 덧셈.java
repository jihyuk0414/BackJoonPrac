class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int bunza = denom1*denom2; 
        int bunmo = denom2*numer1 + denom1*numer2 ;
        
        int gcdnum = gcd(bunza,bunmo) ; 
            
        bunza = bunza/gcdnum ;
        bunmo = bunmo/gcdnum ;
        
        answer[0] = bunmo;
        answer[1] = bunza;
        return answer ;
    }
    
    private static int gcd(int a, int b)
    {
        if (b == 0){
		return a;}
	    
        return gcd(b, a % b);
    }
}
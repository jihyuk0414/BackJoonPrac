import java.math.* ;

class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        
        BigInteger bunza = new BigInteger("1");
        BigInteger bigbunmo = new BigInteger("1");
        BigInteger smallbunmo = new BigInteger("1");
        
        for(int i = 1; i <= balls; i++) {
            bunza = bunza.multiply(BigInteger.valueOf(i));
        }
        
        for(int i = 1; i <= share; i++) {
            bigbunmo = bigbunmo.multiply(BigInteger.valueOf(i));
        }
        
        for(int i = 1; i <= balls - share; i++) {
            smallbunmo = smallbunmo.multiply(BigInteger.valueOf(i));
        }
        
        BigInteger result = (bunza.divide(bigbunmo.multiply(smallbunmo))) ;
        answer = result.intValue();
        return answer;
    }
}
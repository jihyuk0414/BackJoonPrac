import java.util.*; 

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> answerlist = new ArrayList<>();
        //각 자리수 별로 
        List<Integer> numbers = new ArrayList<>();  // 사용 가능한 숫자들 관리
        
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        k -=1;
        int idx = 1; //idx는 1~n까지
        
        while (idx <= n)
        {
            
            long val = factorial (n-idx);
            int addidx = (int) (k/val);
            int addnum = numbers.get(addidx);
            numbers.remove(addidx);
            answerlist.add(addnum);
            k %= val;
            idx +=1;
        }
        
        int [] answer = new int [answerlist.size()];
        for (int i = 0 ; i<answerlist.size() ; i++)
        {
            answer[i] = answerlist.get(i);
        }
        
        return answer;
    }
    
    public long factorial(int val)
    {
        long cnt = 1;
        while (val >=1)
        {
            cnt *= val;
            val -=1;
        }
        return cnt ;
    }
}
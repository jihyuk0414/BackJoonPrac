class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1 ; i <arr.length;i++)
        {
            int gcd = gcd(answer,arr[i]);
            answer = (answer*arr[i])/gcd;
        }
        return answer;
    }
    
    public int gcd(int a, int b)
    {
        while (b>0)
        {
            int c = b;
            b= a %b;
            a = c;
        }
        
        return a;
    }
}
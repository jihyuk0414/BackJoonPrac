class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        long originTotal = (long) w*h ; 
        
        long minus = (long)w+h - GCD(w,h);
        
        return originTotal-minus;
    }
    
    public int GCD(int a, int b)
    {
        while(b!=0)
        {
            int temp = a%b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}
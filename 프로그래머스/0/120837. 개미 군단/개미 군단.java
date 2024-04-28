class Solution {
    public int solution(int hp) {
        int answer = 0;
        while (hp>0)
        {
            if (hp-5 >=0)
            {
                answer+=1;
                hp = hp-5;
                continue;
            }
            
            else if (hp-3 >=0)
            {
                answer+=1;
                hp = hp-3;
                continue;
            }
            
            else if (hp-1 >=0)
            {
                answer+=1;
                hp = hp-1;
                continue;
            }
        }
        return answer;
    }
}
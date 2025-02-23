class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2] ;
        int zerocnt = 0 ;
        int correctcnt = 0 ;
        boolean [] correct = new boolean[win_nums.length];
        for (int i = 0 ; i<lottos.length; i++)
        {
            if (checkidx(lottos[i],win_nums) != -1)
            {
                //안에있다면
                correct[checkidx(lottos[i],win_nums)] = true;
                correctcnt+=1;
            } else if (lottos[i] == 0)
            {
                zerocnt +=1;
            }
        }
        
        answer[0] = zerocnt == 0 && correctcnt ==0? 6 : (7-correctcnt-zerocnt);
        answer[1] = correctcnt == 0? 6 : (7-correctcnt) ;
        
        
        return answer;
    }
    
    public int checkidx (int val , int [] win_nums)
    {
        for (int i = 0 ; i<win_nums.length; i++)
        {
            if (win_nums[i] == val)
            {
                return i;
            }
        }
        return -1;
    }
}
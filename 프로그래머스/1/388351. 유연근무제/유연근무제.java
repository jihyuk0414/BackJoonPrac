

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0 ; i<schedules.length ; i++)
        {
            int now = schedules[i];
            int target = now+10;
            if (target%100 >= 60)
            {
                target -= 60;
                target +=100;
            }
            
            schedules[i] = target;
        }
        //출근 희망 +10분 
        
        //계산 후 분이 60 초과시, +100 , - 60 
        
        //시간을 보고 break 할지 말지 
        
        for (int i = 0 ;i<schedules.length; i++)
        {
            int target = schedules[i]; 
            boolean safe = true;
            //시간을 돌면서 검사
            for (int j = 0 ; j<timelogs[0].length; j++)
            {
                 if (((j+startday) % 7 == 6 ||(j+startday) % 7 == 0))
                     {
                         continue;
                     }
                     
                 if (timelogs[i][j] > target)
                     {
                         safe = false;
                         break;
                     }
            }
            
            if (safe)
            {
                answer +=1;
            }
                     
            
        }
        
        
        
        return answer;
    }
}
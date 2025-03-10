class Solution {
    public int [] answer;
    public int maxpurchase = 0;
    public int maxpersonans = 0 ;
    public int[] rate = {90, 80, 70, 60};
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int [2];
        dojob(users,emoticons,0,new int [emoticons.length]);       
        
        answer[0] = maxpersonans;
        answer[1] = maxpurchase;
        return answer;
    }
    
    public void dojob(int [][] users,int [] emoticons, int depth, int [] rateval)
    {
        if (depth == emoticons.length)
        {
            calculate(users,emoticons,rateval);
            return;
        }
        
        for (int onerate : rate)
        {
            rateval[depth] = onerate;
            dojob(users,emoticons,depth+1,rateval);
        }
    }
    
    public void calculate(int [][] users,int [] emoticons, int [] rateval)
    {
        int total = 0 ;
        int maxperson = 0;
        
        for (int i = 0 ; i<users.length; i++)
        {
            int sum = 0;
            for (int j = 0 ; j<emoticons.length; j++)
            {
                if (100 - rateval[j] >= users[i][0])
                {
                    sum += emoticons[j]*rateval[j]/100;
                }
            }
            
            if (users[i][1] <= sum)
            {
                sum = 0 ;
                maxperson+=1;
            }
            
            total += sum;
        }
        
        if (maxpersonans < maxperson)
        {
            maxpersonans = maxperson;
            maxpurchase = total;
        } else if (maxpersonans == maxperson)
        {
            if (total > maxpurchase)
            {
                maxpurchase = total;
            }
        }
        
    }
}
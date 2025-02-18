class Solution {
    
    public int n;
    public int [][] cost = new int [][] { {1,1,1},{5,1,1},{25,5,1}};
    public int answer = Integer.MAX_VALUE ;
    
    public int solution(int[] picks, String[] minerals) {
        n = minerals.length;
        
        job(picks,minerals,0,0);        
        return answer;
    }
    
    public void job(int [] picks, String [] minerals, int beforeMineralIdx, int cnt)
    {
        //depth
        if(beforeMineralIdx == n)
        {
            answer=  Math.min(answer,cnt);
            return;
        }
        
        boolean picksEmpty = false;
        for (int i = 0 ; i<picks.length; i++)
        {
            if (picks[i] != 0)
            {
                picksEmpty= true;
                //쓸 수 있다면
                int beforecnt = cnt;
                picks[i] -=1;
                int j = beforeMineralIdx;
                while (j< Math.min(beforeMineralIdx+5, n))
                {
                    int idx = covertFromStrToIdx(minerals[j]);
                    cnt +=cost[i][idx];
                    j+=1;
                }
                
                job(picks,minerals,j,cnt);
                
                picks[i]+=1;
                cnt = beforecnt;
            }
        }
        
        if(!picksEmpty)
        {
            answer=  Math.min(answer,cnt);
        }
        
        return;
    }
    
    public int covertFromStrToIdx(String str)
    {
        if(str.equals("diamond"))
        {
            return 0;
        } else if (str.equals("iron"))
        {
            return 1;
        } else {
            return 2;
        }
    }
}
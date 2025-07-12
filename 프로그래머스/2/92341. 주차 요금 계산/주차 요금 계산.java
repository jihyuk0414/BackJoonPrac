import java.util.*;

class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public Map<Integer, Integer> timemap = new HashMap<>();
    public int maxtime = 23*60+59;
    public int[] solution(int[] fees, String[] records) {
        
        for (int i = 0 ; i<records.length; i++)
        {
            String [] line = records[i].split(" ");
            String [] startarr = line[0].split(":");
            int time = Integer.parseInt(startarr[0])*60 + Integer.parseInt(startarr[1]);
            int carnum = Integer.parseInt(line[1]);
            if(line[2].equals("IN"))
            {
                //차번호, 입차시간.
                map.put(carnum,time);
            }
            else
            {
                int newtime = time-map.getOrDefault(carnum,0);
                timemap.put(carnum,newtime+timemap.getOrDefault(carnum,0));
                map.remove(carnum);
            }
        }
        
        //출차 안된애들 확인
        
        
        
        if(!map.isEmpty())
        {
            //계산
            int [] answer = new int [map.keySet().size()];
            List<Integer> notfinish = new LinkedList<>(map.keySet());
            
            for(Integer carnum : notfinish)
            {
                int newtime = maxtime-map.getOrDefault(carnum,0);
                timemap.put(carnum,newtime+timemap.getOrDefault(carnum,0));
                map.remove(carnum);
            }
        }
        
        //계산
        int [] answer = new int [timemap.keySet().size()];
        List<Integer> keylist = new LinkedList<>(timemap.keySet());
        
        Collections.sort(keylist);
        
        int idx = 0 ;
        for(Integer carnum : keylist)
            {
                int time = timemap.get(carnum);
                int val = 0 ;
                
                if (time<=fees[0])
                {
                    answer[idx] = fees[1];
                } 
                else
                {
                    answer[idx] = fees[1] + (int)Math.ceil((double)(time-fees[0])/fees[2])*fees[3];
                }
                idx +=1;
            }
        
        return answer;
    }
}
import java.util.*; 

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> mymap = new HashMap<>(); //차 번호, 분
         Map<String, Integer> minutemap = new HashMap<>(); //차 번호, 분
        
        for (int i =0  ; i<records.length; i++)
        {
            String [] oneline = records[i].split(" ");
            String [] starttime = oneline[0].split(":");
            int minute = Integer.parseInt(starttime[0])*60+Integer.parseInt(starttime[1]);
            
            String car = oneline[1];
            String whattodo = oneline[2];
            
            if (whattodo.equals("IN"))
            {
                mymap.put(car, minute);
            } else {
                //분만 일단 넣자
                
                //이미 있다면 + 
                if (minutemap.keySet().contains(car))
                {
                    int inminute = mymap.get(car);
                    minutemap.put(car,minutemap.get(car)+ (minute-inminute));
                }else {
                    int inminute = mymap.get(car);
                    minutemap.put(car,minute-inminute);
                }
                mymap.remove(car);
            }
            
        }
        
        //안나온애들
        if (!mymap.isEmpty())
        {
            for (String car : mymap.keySet())
            {
                 if (minutemap.keySet().contains(car))
                {
                    int inminute = mymap.get(car);
                    minutemap.put(car,minutemap.get(car)+ (1439-inminute));
                }else {
                    int inminute = mymap.get(car);
                    minutemap.put(car,1439-inminute);
                }
            }
        }
        
        List<String> sortcar = new ArrayList<>(minutemap.keySet());
        List<Integer> answerlist = new ArrayList<>();
        Collections.sort(sortcar);
        
        for (String car : sortcar)
        {
            int minute = minutemap.get(car);
            int cost=  0 ;
            if (minute<=fees[0])
            {
                cost = fees[1];
            } else {
                cost = fees[1] + (int) Math.ceil((double) (minute-fees[0])/fees[2])*fees[3];
            }
            answerlist.add(cost);
        }
        System.out.println(minutemap);
        
        int [] answer = new int [answerlist.size()];
        
        for (int i = 0 ; i< answerlist.size() ; i++)
        {
            answer[i] = answerlist.get(i);
        }
        
        
        return answer;
    }
}
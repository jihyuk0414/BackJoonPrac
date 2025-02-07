import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerlist = new ArrayList<>();
        
        List<Integer> mylist = new ArrayList<>();
        for (int i = 0 ; i<progresses.length; i++)
        {
            mylist.add(progresses[i]);
        }
        
        int checkidx = 0;

        while (true)
        {
            //모든 애들이 배포 끝났나 check 
            if (mylist.size() ==0 )
            {
                break;
            }
            //모든 list+ speeds
            for (int i = 0 ; i<mylist.size(); i++)
            {
                mylist.set(i,mylist.get(i)+speeds[i+checkidx]);
            }
            
            //가장 앞에 내용이 >=100이라면, 해당 내용들 모두 제거 + idx 변경
            if (mylist.get(0) >=100)
            {
                System.out.println(mylist.get(0)+"가 100을넘음");
                int localcnt = 0 ;
                while (mylist.size() >0 )
                {
                    if (mylist.get(0) >= 100)
                    {
                        localcnt +=1;
                        checkidx +=1;
                        mylist.remove(0);
                        continue;
                    } else {
                        break;
                    }
                }
                answerlist.add(localcnt);
            }
        }
        
        int [] answer = new int[answerlist.size()];
        for (int i = 0 ; i<answerlist.size(); i++)
        {
            answer[i] = answerlist.get(i);
        }
        
        
        return answer;
    }
}
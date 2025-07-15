import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
           
        //order랑 똑같은거 만들어서 넣기
        int [] neworder = new int [order.length];
        
        for (int i = 0 ; i<order.length; i++)
        {
            neworder[order[i]-1] = i;
        }
        
        Queue<Integer> container = new LinkedList<>();
        for (int i = 0 ; i<neworder.length; i++)
        {
            container.add(neworder[i]); //삐뽀
        }
        
        Stack<Integer> subcontainer = new Stack<>();
        
        int target= 0;
        while(!container.isEmpty())
            {
                int containerval = container.peek();
                if(containerval == target)
                {
                    target+=1;
                    answer+=1;
                    container.poll();
                }
                else
                {
                    //컨테이너 젤 앞께 다르다. 
                    if(!subcontainer.isEmpty() && subcontainer.peek() == target)
                    {
                        target+=1;
                        answer+=1;
                        subcontainer.pop();
                        continue;
                    }
                    else
                    {
                        //없으면 일단 넣어
                        subcontainer.push(container.poll());
                    }
                }
            }
            
            while(!subcontainer.isEmpty())
            {
                if(subcontainer.peek() != target)
                {
                    return answer;
                }
                else
                {
                    target+=1;
                    answer+=1;
                    subcontainer.pop();
                }
            }
            
            return answer;
            
        }
        
}
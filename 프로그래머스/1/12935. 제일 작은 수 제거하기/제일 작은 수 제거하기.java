import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> comparearr = new ArrayList<>(); 
        
        int minnum = 123456789;
        int minindex = 0 ;
        
        for (int i=0;i<arr.length; i++)
        {
            if (arr[i]<=minnum)
            {
                minnum = arr[i];
                minindex = i;
            }
        } // 최소 찾기
        
                
        for (int i=0;i<arr.length; i++)
        {
            if (i == minindex)
            {
                continue;
            }
            else
            {
                comparearr.add(arr[i]);
            }
        } // 최소 가 아닐때, 넣기 . 
        
        if (comparearr.size() == 0)
        {
            int []answer = {-1};
            return answer;
        }
        else
        {
            int []answer = new int[comparearr.size()] ;
            for (int i =0; i<comparearr.size(); i++)
            {
                answer[i] = comparearr.get(i);
            }
            return answer;
        }

    }
}
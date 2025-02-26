import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<Map<String,Integer>> mylist = new ArrayList<>();
        for (int i = 0 ; i<data.length; i++)
        {
            int [] now = data[i];
            Map<String,Integer> mymap = new HashMap<>();
            mymap.put("code", now[0]);
            mymap.put("date", now[1]);
            mymap.put("maximum", now[2]);
            mymap.put("remain", now[3]);
            mylist.add(mymap);
            
        }
        
        //ext가 val_ext보다 작은 데이터만 뽑는다.
        
        boolean [] filter = new boolean[mylist.size()];
        for (int i = 0 ; i<filter.length; i++)
        {
            filter[i] = true;
        }
          //정렬
        Collections.sort(mylist, (a,b) -> {
            return a.get(sort_by) - b.get(sort_by);
        });
        
        for (int i = 0 ; i<mylist.size(); i++)
        {
            Map<String,Integer> now = mylist.get(i);
            if (now.get(ext) >= val_ext)
            {
                filter[i] = false;
            }
        }
        
      
        
        int answersize = 0 ;
        for (int i = 0 ; i<filter.length; i++)
        {
            if (filter[i])
            {
                answersize +=1;
            }
        }
        
        int ansidx = 0 ;
        int [][] answer = new int [answersize][4];
        for (int i = 0 ; i<filter.length; i++)
        {
            if(filter[i])
            {
                int [] newarr = new int[4];
                newarr[0]=mylist.get(i).get("code");
                newarr[1]=mylist.get(i).get("date");
                newarr[2]=mylist.get(i).get("maximum");
                newarr[3]=mylist.get(i).get("remain");
                answer[ansidx] = newarr;
                ansidx+=1;
            }
        }
        
        return answer;
    }
}
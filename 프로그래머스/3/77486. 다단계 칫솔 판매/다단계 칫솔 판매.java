import java.util.*;

class Solution {
    
    public int n ;
    public HashMap<String,Integer> costMap = new HashMap<>();
    public HashMap<String,String> parentMap = new HashMap<>();
        
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        //각 직원 별 이익 HashMap
        
        // 자식 : 부모의 Map이 존재 (이걸 타고 올라갈거임
        
        n = enroll.length;
        
        for (int i = 0; i<n; i++ )
        {
            String name = enroll[i];
            String parent = referral[i];
            
            costMap.put(name,0);
            
            //부모가 없는 경우도 있음
            parentMap.put(name,parent);
            
        }
        
        for (int i = 0 ;i<seller.length; i++)
        {
            String sellerName=  seller[i];
            
            //여기서, 올라가면서 계산.
            recursion(sellerName,amount[i]*100);
        }
        
        
        
        int [] answer = new int [costMap.keySet().size()];
        
        for (int i = 0 ; i<n ; i++)
        {
            String name = enroll[i];
            answer[i] = costMap.get(name);
        }
        
        
        
        // 타고 올라가기 logn , 계산 n
        
        
        return answer;
    }
    
    public void recursion(String seller, int cost)
    { 
        //중단 조건
        if (seller.equals("-") || cost <1)
        {
            return;
        } else {
            //본인 거에 값 추가
            costMap.put(seller,costMap.get(seller)+ cost-(cost/10));
        }
        
        
        recursion(parentMap.get(seller), (int) (cost/10));
        
        return;
        
        
    }
}
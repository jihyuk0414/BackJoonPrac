import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int m = enemy.length;
        
        if (k >= enemy.length) {
            return enemy.length;
        }
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //큰 수 부터
        
        long enemycnt = 0;
        
        for (int i = 0 ; i<m ; i++)
        {
            pq.add(enemy[i]);
            enemycnt += enemy[i];
            
            //다 바로바로 처리 가능하다면
            if (enemycnt <=n)
            {
                continue;
            } else {
                //힌트를 써야만 가능하다면 
                if (k>0)
                {
                    enemycnt -= pq.poll();
                    k--;
                } else {
                    //k가 더 이상 쓸 수 없다
                    return i;
                }
            }
        }
        
        return m;
        
    }
}
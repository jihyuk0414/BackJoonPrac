import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        //1. 노드,비용으로 이루어진 list
        List<List<int[]>> costlist = new ArrayList<>();
        
        for (int i = 0 ; i<N; i++)
        {
            List<int []> addlist = new ArrayList<>();
            costlist.add(addlist);
        }
        
        for (int i = 0  ; i<road.length; i++)
        {
            int [] now = road[i] ; //다음노드, 비용
            int [] one = new int [] {now[1]-1,now[2]};
            int [] two = new int [] {now[0]-1,now[2]};
            costlist.get(now[0]-1).add(one);
            costlist.get(now[1]-1).add(two);
        }
        
        //2. 최단 거리 배열
        
        int [] mincost = new int [N];
        for (int i = 1 ; i<N ; i++)
        {
            mincost[i] = Integer.MAX_VALUE;
        }
        //2-1. 방문 배열
        boolean [] visited= new boolean[N];
        //3. 시작 노드에서 부터, 현재 최단 거리를 확인하고 돈다. 
        
        while (true)
        {
            
            int minindex = -1 ;
            int compare = Integer.MAX_VALUE;
            
            
            for (int i = 0 ; i<N ; i++)
            {
                if (!visited[i] && mincost[i]<compare)
                {
                    //가장 짧은 곳 부터 
                    minindex = i;
                    compare = mincost[i];
                }
            }
                        //더이상 갈수없다
            if (minindex == -1 || compare == Integer.MAX_VALUE) {
                break; // 더 이상 방문할 노드가 없음
            }
            visited[minindex] = true;

            
            List<int []> nowlist = costlist.get(minindex);
            for (int i = 0 ; i<nowlist.size(); i++)
            {
                int [] nowarr = nowlist.get(i);
                if (compare+nowarr[1] < mincost[nowarr[0]])
                {
                    //지금까지 + 다음 < 다음까지 값
                    mincost[nowarr[0]] = compare+nowarr[1];
                }
            }
            
        }
        
        for (int i = 0 ; i<N ; i++)
        {
            if (mincost[i] <= K)
            {
                answer +=1;
            }
        }
        
        return answer;
    }
    
}
class Solution {
    
    int answer = 0;
    int N ; 
    boolean [] visited;
    
    public int solution(int k, int[][] dungeons) {
 
        N = dungeons.length ; 
        
        visited = new boolean[N];
        
        DFS(0,k,dungeons);
        
        return answer;
    }
    
    public void DFS(int depth, int leftenergy,int[][] dungeons)
    {
        for (int i = 0 ; i<N ; i++)
        {
            if(visited[i] == false && dungeons[i][0] <= leftenergy)
            {
                answer = Math.max(answer,depth+1);
                visited[i] = true;
                DFS(depth+1, leftenergy - dungeons[i][1],dungeons);
             visited[i] = false;
            }
        }
    }
}
import java.util.*;
class Solution {
    public int N,M ; 
    public int [][] map;
    public boolean[][] visited;
    public int[] dx = {0,1,0,-1};
    public int[] dy = {1,0,-1,0};
    public int[] xval;
    
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        map = land;
        visited = new boolean[N][M];
        xval = new int[M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            answer = Math.max(answer, xval[i]);
        }
        return answer;
    }
    
    public void BFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> cols = new HashSet<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        cols.add(startY);
        int areaSize = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    cols.add(ny);
                    areaSize++;
                }
            }
        }
        
        for (int col : cols) {
            xval[col] += areaSize;
        }
    }
}
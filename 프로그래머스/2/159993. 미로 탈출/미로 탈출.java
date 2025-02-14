import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = -1;
        
        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};        
        char [][] map = new char[maps.length][maps[0].length()];
        
        int N = maps.length;
        int M = maps[0].length();
        
        Deque<int []> q = new ArrayDeque<>();
        
        int startx = 0;
        int starty = 0;
        
        // 맵 초기화 및 시작점 찾기
        for (int i = 0; i < N; i++) {
            String oneline = maps[i];
            for (int j = 0; j < M; j++) {
                map[i][j] = oneline.charAt(j);
                if(oneline.charAt(j) == 'S') {
                    startx = i;
                    starty = j;
                }
            }
        }
        
        // 시작점에서 레버까지의 BFS
        boolean [][] visited = new boolean[N][M];
        visited[startx][starty] = true;
        q.addFirst(new int[]{startx, starty, 0});
        
        int levelx = 0;
        int levely = 0;
        int levelcnt = 0;
        boolean escape = false;
        
        while (!q.isEmpty()) {
            int [] now = q.pollFirst();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        if (map[nx][ny] == 'L') {
                            levelx = nx;
                            levely = ny;
                            levelcnt = cnt + 1;
                            escape = true;
                            break;
                        }
                        int [] newarr = new int[]{nx, ny, cnt + 1};
                        q.addLast(newarr);
                    }
                }
            }
            if (escape) {
                break;
            }
        }
        
        // 레버를 찾지 못한 경우
        if (!escape) {
            return -1;
        }
        
        // 레버에서 출구까지의 BFS
        q = new ArrayDeque<>();
        visited = new boolean[N][M];
        visited[levelx][levely] = true;
        q.addFirst(new int[]{levelx, levely, levelcnt});
        
        while (!q.isEmpty()) {
            int [] now = q.pollFirst();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        if (map[nx][ny] == 'E') {
                            return cnt + 1;
                        }
                        visited[nx][ny] = true;
                        int [] newarr = new int[]{nx, ny, cnt + 1};
                        q.addLast(newarr);
                    }
                }
            }
        }
        
        return answer;
    }
}
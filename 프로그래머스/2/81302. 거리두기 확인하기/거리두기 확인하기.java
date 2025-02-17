import java.util.*;
class Solution {
    public char[][] map;   
    public int n; 
    public int m;
    public int[] solution(String[][] places) {
        n = places.length;   
        m = 5; 
        
        int[] answer = new int[n];
        Arrays.fill(answer, 1);  
        
        for (int room = 0; room < n; room++) {
            map = new char[5][5];
            List<int[]> plist = new ArrayList<>();
            
            for (int i = 0; i < 5; i++) {
                String row = places[room][i];
                for (int j = 0; j < 5; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == 'P') {
                        plist.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < plist.size(); i++) {
                for (int j = i + 1; j < plist.size(); j++) {
                    int[] p1 = plist.get(i);
                    int[] p2 = plist.get(j);
                    
                    int len = manHatenLength(p1[0], p1[1], p2[0], p2[1]);
                    
                    if (len <= 2) {
                        boolean safe = check(p1[0], p1[1], p2[0], p2[1]);
                        if (!safe) {
                            answer[room] = 0; 
                            i = plist.size();  
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public int manHatenLength(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    
    public boolean check(int x1, int y1, int x2, int y2) {
        if (manHatenLength(x1, y1, x2, y2) == 1) {
            return false;
        }
        
        if (x1 == x2) {
            return map[x1][(y1 + y2) / 2] == 'X';
        }
        
        if (y1 == y2) {
            return map[(x1 + x2) / 2][y1] == 'X';
        }
        
        return map[x1][y2] == 'X' && map[x2][y1] == 'X';
    }
}
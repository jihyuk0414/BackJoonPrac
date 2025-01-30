import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
   static int N, L, R;
   static int[][] map;
   static int[] dx = {0, 1, 0, -1};
   static int[] dy = {1, 0, -1, 0};
   static boolean[][] cango;
   static boolean[][] visited;
   static List<int[]> pathlist;
   static int howmany;
   static int totalcnt;

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       String[] nline = br.readLine().split(" ");
       N = Integer.parseInt(nline[0]);
       L = Integer.parseInt(nline[1]);
       R = Integer.parseInt(nline[2]);
       
       map = new int[N][N];
       for (int i = 0; i < N; i++) {
           String[] oneline = br.readLine().split(" ");
           for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(oneline[j]);
           }
       }
       
       int answer = 0;
       while (true) {
           cango = new boolean[N][N];
           visited = new boolean[N][N];
           boolean canMove = open();
           
           if (!canMove) {
               bw.write(answer + "");
               bw.close();
               return;
           }
           
           boolean anyonemove = false;
           for (int i = 0; i < N; i++) {
               for (int j = 0; j < N; j++) {
                   if (cango[i][j] && !visited[i][j]) {
                       pathlist = new ArrayList<>();
                       howmany = 0;
                       totalcnt = 0;
                       if (DFS(i, j)) {
                           anyonemove = true;
                           dojob(totalcnt / howmany);
                       }
                   }
               }
           }
           
           if (!anyonemove) {
               bw.write(answer + "");
               bw.close();
               return;
           }
           answer++;
       }
   }

   public static boolean open() {
       boolean flag = false;
       for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++) {
               int now = map[i][j];
               for (int z = 0; z < 4; z++) {
                   int nx = i + dx[z];
                   int ny = j + dy[z];
                   if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                       int diff = Math.abs(now - map[nx][ny]);
                       if (L <= diff && diff <= R) {
                           cango[i][j] = true;
                           cango[nx][ny] = true;
                           flag = true;
                       }
                   }
               }
           }
       }
       return flag;
   }

   public static boolean DFS(int x, int y) {
       howmany += 1;
       totalcnt += map[x][y];
       visited[x][y] = true;
       pathlist.add(new int[]{x, y});
       
       for (int z = 0; z < 4; z++) {
           int nx = x + dx[z];
           int ny = y + dy[z];
           if (0 <= nx && nx < N && 0 <= ny && ny < N) {
               if (!visited[nx][ny] && cango[nx][ny]) {
                   if (L <= Math.abs(map[x][y] - map[nx][ny]) && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                       DFS(nx, ny);
                   }
               }
           }
       }
       return howmany > 1;
   }

   public static void dojob(int val) {
       for (int[] pos : pathlist) {
           map[pos[0]][pos[1]] = val;
       }
   }
}
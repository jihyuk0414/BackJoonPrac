import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,H; 
    static int [] down;
    static int [] up;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        H = Integer.parseInt(oneline[1]);
        down = new int [N/2];
        up = new int[N/2];
        
        for (int i = 0; i < N; i++) {
            if (i%2 == 0) {
                down[i/2] = Integer.parseInt(br.readLine());
            } else {
                up[i/2] = Integer.parseInt(br.readLine());
            }
        }
        
        Arrays.sort(down);
        Arrays.sort(up);
        
        int minObstacles = N;  // 최대 장애물 수로 초기화
        int count = 0;
        
        for (int height = 1; height <= H; height++) {
            int obstacles = countObstacles(height);
            
            if (obstacles < minObstacles) {
                minObstacles = obstacles;
                count = 1;
            } else if (obstacles == minObstacles) {
                count++;
            }
        }
        
        bw.write(minObstacles + " " + count);
        bw.close();
    }
    
    // 특정 높이에서 부딪히는 총 장애물 수 계산
    private static int countObstacles(int height) {
        return countDown(height) + countUp(height);
    }
    
    private static int countDown(int height) {
        int left = 0;
        int right = N/2;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (down[mid] >= height) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return N/2 - left;
    }

    private static int countUp(int height) {
        int left = 0;
        int right = N/2;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (up[mid] >= H - height + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return N/2 - left;
    }
}
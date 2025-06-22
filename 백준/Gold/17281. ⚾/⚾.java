import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static List<int[]> pointlist = new ArrayList<>();
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] oneline = br.readLine().split(" ");
            int[] pointarr = new int[9];
            for (int j = 0; j < 9; j++) {
                pointarr[j] = Integer.parseInt(oneline[j]);
            }
            pointlist.add(pointarr);
        }

        makehitlist(new int[]{0,1,2,3,4,5,6,7,8}, 0, new ArrayList<Integer>(), new boolean[9]);

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static void makehitlist(int[] numberarr, int depth, List<Integer> hitonelist, boolean[] visited) {
        if (depth == 9) {
            int totalScore = calculateScore(hitonelist);
            answer = Math.max(answer, totalScore);
            return;
        }

        if (depth == 3) {
            visited[0] = true;
            hitonelist.add(numberarr[0]);
            makehitlist(numberarr, depth + 1, hitonelist, visited);
            hitonelist.remove(hitonelist.size() - 1);
            visited[0] = false;
        } else {
            for (int i = 1; i < 9; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    hitonelist.add(numberarr[i]);
                    makehitlist(numberarr, depth + 1, hitonelist, visited);
                    hitonelist.remove(hitonelist.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static int calculateScore(List<Integer> batting_order) {
        int totalScore = 0;
        int hitidx = 0;
        
        for (int inning = 0; inning < N; inning++) {
            boolean[] base = new boolean[3];
            int out = 0;
            int[] nowpoint = pointlist.get(inning);
            
            while (out < 3) {
                int hit = nowpoint[batting_order.get(hitidx)];
                
                if (hit == 0) {
                    out++;
                } else if (hit == 1) {
                    if (base[2]) totalScore++;
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = true;
                } else if (hit == 2) {
                    if (base[2]) totalScore++;
                    if (base[1]) totalScore++;
                    base[2] = base[0];
                    base[1] = true;
                    base[0] = false;
                } else if (hit == 3) {
                    if (base[2]) totalScore++;
                    if (base[1]) totalScore++;
                    if (base[0]) totalScore++;
                    base[2] = true;
                    base[1] = false;
                    base[0] = false;
                } else if (hit == 4) {
                    if (base[2]) totalScore++;
                    if (base[1]) totalScore++;
                    if (base[0]) totalScore++;
                    totalScore++;
                    base[2] = false;
                    base[1] = false;
                    base[0] = false;
                }
                
                hitidx = (hitidx + 1) % 9;
            }
        }
        
        return totalScore;
    }
}
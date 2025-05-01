import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<int[]> Nlist = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String[] oneline = br.readLine().split(" ");
            int duration = Integer.parseInt(oneline[0]);
            int cost = Integer.parseInt(oneline[1]);

            // 작업의 시작 시간, 종료 시간, 비용
            int start = i;
            int end = start + duration - 1;

            Nlist.add(new int[]{start, end, cost});
        }

        // 종료 시간을 기준으로 작업 정렬
        Nlist.sort((a, b) -> a[1] - b[1]);

        // 깊이 우선 탐색을 통해 최대 수익 계산
        dfs(0, -1, 0);  // 현재까지 수익, 마지막 끝난 시간, 총 수익

        bw.write(String.valueOf(answer));
        bw.close();
    }

    // dfs(depth, lastEnd, currentSum)
    public static void dfs(int idx, int lastEnd, int currentSum) {
        // 최대 수익 갱신
        answer = Math.max(answer, currentSum);

        // 모든 작업을 시도
        for (int i = idx; i < N; i++) {
            int[] job = Nlist.get(i);
            int start = job[0];
            int end = job[1];
            int cost = job[2];

            // 현재 작업을 선택할 수 있는지 확인
            if (start > lastEnd) {
                dfs(i + 1, end, currentSum + cost);  // 다음 작업 선택
            }
        }
    }
}

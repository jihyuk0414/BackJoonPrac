import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<int []> Nlist = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Nlist.add(new int[] {0, 0, 0});  // 첫 번째 더미 작업 추가 (인덱스 맞추기 위해)
        for (int i = 1; i <= N; i++) {
            String[] oneline = br.readLine().split(" ");
            int duration = Integer.parseInt(oneline[0]);  // 작업 기간
            int cost = Integer.parseInt(oneline[1]);     // 작업 수익

            int[] newarr = new int[3];
            newarr[0] = i; // 시작 날짜 (작업 번호)
            newarr[1] = i + duration - 1; // 끝 날짜
            newarr[2] = cost; // 수익

            Nlist.add(newarr);
        }

        // DFS 시작
        dojob(1, 0, 1);  // 1번 작업부터 시작, 현재 수익은 0, 시작 시간은 1

        bw.write(String.valueOf(answer));
        bw.close();
    }

    // DFS 함수: depth(현재 작업 번호), cnt(현재까지 수익), nowtime(현재까지 작업 종료 시간)
    public static void dojob(int depth, int cnt, int nowtime) {
        if (depth == N + 1) {
            answer = Math.max(answer, cnt);  // 더 이상 진행할 작업이 없다면 최대값 갱신
            return;
        }

        int[] now = Nlist.get(depth);

        // 이 작업을 선택하는 경우: 현재 작업이 가능한지 확인
        if (now[0] >= nowtime) {  // 현재 작업의 시작 시간이 현재까지의 시간보다 크거나 같으면 선택 가능
            dojob(depth + 1, cnt + now[2], now[1] + 1);  // 현재 작업을 선택하고, 종료 시간이 끝나는 시간 + 1부터 시작
        }

        // 이 작업을 선택하지 않는 경우
        dojob(depth + 1, cnt, nowtime);  // 작업을 선택하지 않고 넘어감
    }
}

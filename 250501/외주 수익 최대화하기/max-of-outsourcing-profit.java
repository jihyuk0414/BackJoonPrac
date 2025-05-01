import java.util.*;

public class Main {
    static int n;
    static int[][] tasklist;
    static int maxx = -10;

    // 입력을 받는 함수
    public static void getInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        tasklist = new int[n][2]; // [0] : 시간, [1] : 수익

        for (int i = 0; i < n; i++) {
            tasklist[i][0] = sc.nextInt();
            tasklist[i][1] = sc.nextInt();
        }
    }

    // 백트래킹을 사용한 dfs 함수
    public static void dfs(int day, int income) {
        // 일이 끝나는 날짜가 휴가기간 뒤라면 종료
        if (day >= n) {
            maxx = Math.max(maxx, income);
            return;
        }

        // 일을 하지 않은 경우
        dfs(day + 1, income);

        // 일을 한 경우
        if (day + tasklist[day][0] <= n) {
            dfs(day + tasklist[day][0], income + tasklist[day][1]);
        }
    }

    // 실제 실행 부분
    public static void main(String[] args) {
        getInput();
        dfs(0, 0);
        System.out.println(maxx);
    }
}

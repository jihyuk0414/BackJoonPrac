import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 입력 처리 (N의 크기와 Nlist)
        int N = scanner.nextInt();
        Set<Integer> Nset = new HashSet<>();
        for (int i = 0; i < N; i++) {
            Nset.add(scanner.nextInt());
        }

        // 두 번째 입력 처리 (M의 크기와 Mlist)
        int M = scanner.nextInt();
        int[] Mlist = new int[M];
        for (int i = 0; i < M; i++) {
            Mlist[i] = scanner.nextInt();
        }

        // Mlist의 각 요소가 Nset에 있는지 확인하고 출력
        StringBuilder sb = new StringBuilder();
        for (int i : Mlist) {
            if (Nset.contains(i)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        // 결과 출력
        System.out.print(sb.toString());

        scanner.close();
    }
}

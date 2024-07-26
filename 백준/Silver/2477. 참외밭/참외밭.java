import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] Nlist = new int[6][2];
        
        // 입력 데이터를 2차원 배열에 저장
        for (int i = 0; i < 6; i++) {
            Nlist[i][0] = scanner.nextInt();
            Nlist[i][1] = scanner.nextInt();
        }

        ArrayList<Integer> direction = new ArrayList<>();
        ArrayList<Integer> length = new ArrayList<>();

        // direction과 length 리스트에 값 추가
        for (int i = 0; i < 6; i++) {
            direction.add(Nlist[i][0]);
            length.add(Nlist[i][1]);
        }

        // 리스트를 두 배로 복제하여 순환 특성 처리
        direction.addAll(direction.subList(0, 6));
        length.addAll(length.subList(0, 6));

        ArrayList<Integer> maxBox = new ArrayList<>();
        ArrayList<Integer> minBox = new ArrayList<>();

        // 방향을 순환하면서 최대 길이와 최소 길이 계산
        for (int i = 1; i < 5; i++) {
            // 특정 방향이 2번 등장하면 처리
            if (Collections.frequency(direction, i) == 2) {
                int bigIndex = direction.indexOf(i); // 첫 등장 인덱스
                maxBox.add(length.get(bigIndex));    // 해당 길이를 최대 길이로 추가
                int smallIndex = bigIndex + 3;       // 3칸 뒤의 인덱스가 최소 길이
                minBox.add(length.get(smallIndex));  // 해당 길이를 최소 길이로 추가
            }
        }

        // 결과 계산 및 출력
        int result = (maxBox.get(0) * maxBox.get(1) - minBox.get(0) * minBox.get(1)) * N;
        System.out.println(result);

        scanner.close();
    }
}

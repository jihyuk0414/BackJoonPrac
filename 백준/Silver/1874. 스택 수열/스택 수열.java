import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // N을 입력 받음
        int N = Integer.parseInt(br.readLine());

        // 수열을 입력 받음
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            answerList.add(Integer.parseInt(br.readLine()));
        }

        int nownum = 1;
        int compareIndex = 0;

        Stack<Integer> myStack = new Stack<>();
        List<Character> correctList = new ArrayList<>();

        boolean isPossible = true;

        while (true) {
            if (compareIndex == N) {
                break;
            }

            if (nownum > N + 1) {
                isPossible = false;
                break;
            }

            if (myStack.isEmpty()) {
                myStack.push(nownum);
                nownum += 1;
                correctList.add('+');
            } else if (answerList.get(compareIndex).equals(myStack.peek())) {
                myStack.pop();
                compareIndex += 1;
                correctList.add('-');
            } else {
                myStack.push(nownum);
                nownum += 1;
                correctList.add('+');
            }
        }

        if (isPossible) {
            StringBuilder sb = new StringBuilder();
            for (char op : correctList) {
                sb.append(op);
                sb.append('\n'); // 각 연산 사이에 줄바꿈 추가
            }
            bw.write(sb.toString().trim()); // 최종 결과를 줄바꿈 없이 출력
        } else {
            bw.write("NO");
        }

        // BufferedWriter를 사용하여 결과를 출력하고 스트림을 닫음
        bw.flush();
        bw.close();
    }
}

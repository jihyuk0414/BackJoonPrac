import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];
        String[] oneline = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(oneline[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] answerarr = new int[N];
        
        Arrays.fill(answerarr, -1);

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && Narr[stack.peek()] <= Narr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answerarr[i] = Narr[stack.peek()];
            }
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            bw.write(answerarr[i] + " ");
        }

        bw.close();
    }
}

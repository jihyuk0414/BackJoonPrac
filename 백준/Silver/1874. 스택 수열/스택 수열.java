import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int start = 1; // push할 숫자
        boolean possible = true;
        
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            
            if (value >= start) {
                // start부터 value까지 push
                while (start <= value) {
                    stack.push(start++);
                    sb.append("+\n");
                }
                // value를 pop
                stack.pop();
                sb.append("-\n");
            } else {
                // 이미 스택에 value가 있어야 하는데 그렇지 않으면 NO
                if (stack.isEmpty() || stack.peek() != value) {
                    possible = false;
                    break;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        
        if (possible) {
            System.out.print(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}

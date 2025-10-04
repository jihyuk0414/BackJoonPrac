import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N = 0;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ;i<N; i++)
            {
                int N = Integer.parseInt(br.readLine());

                if(N == 0 )
                {
                    stack.pop();
                }
                else{
                    stack.push(N);
                }
            }

        while(!stack.isEmpty())
            {
                answer += stack.pop();
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
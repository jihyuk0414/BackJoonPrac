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

        StringBuilder sb = new StringBuilder();
        N= Integer.parseInt(br.readLine());
        String [] sarr = br.readLine().split(" ");
        int [] Narr = new int [N];
        for(int i= 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(sarr[i]);
            }
        int [] answerarr = new int[N];
        Stack<int [] > stack = new Stack<>();

        for (int x = 0 ; x<N; x++)
            {
                int idx = x;
                int val = Narr[x];

                while(!stack.isEmpty() && stack.peek()[1] < val)
                    {
                        stack.pop();
                    }

                if(stack.isEmpty())
                {
                    answerarr[idx] = 0;
                }
                else
                {
                    answerarr[idx] = stack.peek()[0]+1;
                }
                stack.push(new int [] {idx,val});
            }

        for (int i = 0 ; i<N; i++)
            {
                sb.append(answerarr[i]+" ");
            }

        bw.write(sb.toString());
        bw.close();
    }
}
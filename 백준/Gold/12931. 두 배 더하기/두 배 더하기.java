import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr = new int [N];

        String [] mline = br.readLine().split(" ");
        int [] Marr = new int [N];

        for (int i = 0 ; i<N; i++)
            {
                Marr[i] = Integer.parseInt(mline[i]);
            }

        int answer = 0;

        while (true)
            {
                //다 0인지부터
                boolean allZero = true;
                for (int i = 0 ; i<N ;i++)
                    {
                        if (Marr[i] != 0 )
                        {
                            allZero = false;
                            break;
                        }
                    }
                if(allZero)
                {
                    break;
                }

                //홀수
                for (int i = 0 ; i<N ;i++)
                    {
                        if (Marr[i] %2 !=0  )
                        {
                            Marr[i] -=1;
                            answer+=1;
                        }
                    }

                //나눌만한 수가 있는가 (0은 다시 체크해야됨 위에서 만들었으니까)
                boolean canDivide = false;
                for (int i = 0; i < N; i++) {
                    if (Marr[i] > 0) {
                        canDivide = true;
                        break;
                    }
                }

            // 2로 나누기
            if (canDivide) {
                for (int i = 0; i < N; i++) {
                    Marr[i] /= 2;
                }
                answer++;
            }
                
            }

        System.out.println(answer);

    }
}
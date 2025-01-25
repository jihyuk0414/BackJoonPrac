import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> candolist = new ArrayList<>();

        List<Integer> zerolist = new ArrayList<>();
        zerolist.add(7);
        candolist.add(zerolist);

        for (int i =1 ; i<= 9 ; i++)
            {
                List<Integer> newlist = new ArrayList<>();
                int left = i-1;
                int right = i +1;
                int up = i-3;
                int down = i+3;

                if (left >0 && (left%3 !=0))
                {
                    newlist.add(left);
                } 

                if ((right %3) != 1)
                {
                    newlist.add(right);
                } 
                if (up >0 )
                {
                    newlist.add(up);
                } 

                if (down < 10)
                {
                    newlist.add(down);
                }

                candolist.add(newlist);
            }
        candolist.get(7).add(0);

        int T = Integer.parseInt(br.readLine());

        int [][] dp = new int [1001][10];

        for (int j = 0; j<= 9; j++)
            {
                dp[1][j] = 1;
            }

        for (int i = 2 ; i<= 1000 ; i++)
            {
                for (int j = 0 ; j<=9 ; j++)
                    {
                        List<Integer> canbeforelist = candolist.get(j);
                        for (Integer canbefore : canbeforelist)
                            {
                                dp[i][j] += (dp[i-1][canbefore]) % 1234567;
                            }
                    }
            }


        for (int tc = 0; tc<T ; tc++)
            {
                //출력만하자

                int N = Integer.parseInt(br.readLine());

                if (N ==1 )
                {
                    bw.write("10"+"\n");
                    continue;
                }

                else {
                    int answer = 0 ;
                    for (int j = 0; j<=9; j++)
                        {
                            answer  = (answer + dp[N][j]) % 1234567;
                        }
                    bw.write(String.valueOf(answer%1234567)+"\n");
                }
            }
        bw.close();

    }
}
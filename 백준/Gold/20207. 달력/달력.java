import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] calaender = new int [366];
        //i가 날짜 j가 값

        for (int i = 0 ; i<N ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                int start = Integer.parseInt(oneline[0]);
                int end = Integer.parseInt(oneline[1]);

                for (int j = start ; j<=end ; j++)
                    {
                        calaender[j] +=1;
                    }
            }

        int answer = 0 ;

        int index = 1 ; 
        while (index<=365)
            {
                if (calaender[index] == 0 )
                {
                    index +=1;
                    continue;
                }

                else {
                    int start = index;
                    int end = index ; 
                    int high = calaender[index] ;
                    while(end <= 365 && calaender[end]!=0)
                        {
                            high = Math.max(high,calaender[end]);
                            end+=1;
                        }

                    answer += (end-start) * high;
                    index = end;
                }
            }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
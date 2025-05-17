import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int K,N ; 
    static int [] arr ; 
     
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        K= Integer.parseInt(oneline[0]);
        N= Integer.parseInt(oneline[1]);

        arr =new int [K];
        for (int i = 0; i< K; i++)
            {
                arr[i] = Integer.parseInt(br.readLine());
            }
        int totalsum = 0 ;
        for (int i = 0 ; i<K ;i++)
            {
                totalsum += arr[i];
            }
        Arrays.sort(arr);

        long start = 1;
        long end = arr[K-1];
        long answer = 0 ;

        while (start<=end)
            {
                long mid = (start+(end-start)/2); //가능한 1개의 값
                int cnt = 0;

                for (int i =0 ; i<K; i++)
                    {
                        cnt += arr[i]/mid;
                    }

                if (cnt >= N)
                {
                    //통과 시 
                    start = mid +1;
                    answer =Math.max(answer,mid);
                } else {
                    end = mid-1;
                }
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }

}
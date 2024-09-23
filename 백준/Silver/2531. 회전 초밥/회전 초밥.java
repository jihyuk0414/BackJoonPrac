import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputarr = br.readLine().split(" ");
        
        int N = Integer.parseInt(inputarr[0]);
        int d = Integer.parseInt(inputarr[1]);
        int k = Integer.parseInt(inputarr[2]);
        int c = Integer.parseInt(inputarr[3]);

        int [] originalarr = new int[N*2];
        
        for (int i = 0 ; i<N ; i++)
            {
                int oneinput = Integer.parseInt(br.readLine());
                originalarr[i] = oneinput;
                originalarr[i+N] = oneinput;
            }

        //계속 비교해갈 Queue
        Queue<Integer> originalq = new LinkedList<>();
        
        //최초k개
        for (int i = 0 ; i < k ; i++)
            {
                originalq.add(originalarr[i]);
            }

        int start = 0 ; 
        int end = k-1; 
        int answer = 0 ;
    
        while (start<N)
            {
                Set<Integer> myset = new HashSet<>(originalq);

                myset.add(c);

                answer = Math.max(answer,myset.size());

                start +=1 ;
                end+=1;

                originalq.poll();
                originalq.add(originalarr[end]);
                
            }

        bw.write(String.valueOf(answer));
        bw.close();
        
    }
}
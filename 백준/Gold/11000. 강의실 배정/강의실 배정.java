import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<int []> Nlist=  new ArrayList<>();

        for (int i = 0 ; i<N ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                int [] newarr = new int [] {Integer.parseInt(oneline[0]),Integer.parseInt(oneline[1])};
                Nlist.add(newarr);
            }
        
        Collections.sort(Nlist, (a,b) ->{
            if (a[0] == b[0])
            {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        PriorityQueue<Integer> endpq= new PriorityQueue<>();
        endpq.add(Nlist.get(0)[1]);
        int answer = 1;

        for (int i = 1; i <N ; i++)
            {
                int [] nowarr = Nlist.get(i);

                int start = nowarr[0];
                int end = nowarr[1];

                while(!endpq.isEmpty() && endpq.peek()<=start)
                    {
                        endpq.poll();
                    }
                endpq.add(end);
                answer= Math.max(answer,endpq.size());

            }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
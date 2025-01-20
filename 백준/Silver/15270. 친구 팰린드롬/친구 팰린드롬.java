import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N,M;
    static int answer =0 ;
    static List<List<Integer>> peoplelist = new ArrayList<>(); 
    static boolean [] visited ;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        visited = new boolean[N+1];

        for (int i = 0 ; i<=N; i++)
            {
                List<Integer> newlist = new ArrayList<>();
                peoplelist.add(newlist);
            }

        for (int i =0 ; i<M ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                int a = Integer.parseInt(oneline[0]);
                int b = Integer.parseInt(oneline[1]);

                peoplelist.get(a).add(b);
                peoplelist.get(b).add(a);
            }

        dojob(1,0);

        answer *= 2;

        if (answer<N)
        {
            answer+=1;
        }
        bw.write(answer+"");
        
            bw.close();

    }

 public static void dojob(int whodance, int cnt) {
    if (whodance > N) {
        answer = Math.max(answer, cnt);
        return;
    }

    if (!visited[whodance]) {
        for (int partner : peoplelist.get(whodance)) {
            if (!visited[partner]) {
                visited[whodance] = true;
                visited[partner] = true;

                dojob(whodance + 1, cnt + 1);

                visited[whodance] = false;
                visited[partner] = false;

            }
        }

    }
    
    dojob(whodance + 1, cnt);

}

}
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M; 
    static int [] narr;
    static int [] rank ;
    static int [] size;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
         N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        narr = new int [N+1];
            size = new int [N+1];
        rank = new int [N+1];

        for (int i = 1; i<=N ; i++)
            {
                narr[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }

        for (int i = 0; i<M ; i++)
            {
                String [] marr = br.readLine().split(" ");
                int a = Integer.parseInt(marr[0]);
                int b = Integer.parseInt(marr[1]);

                union(a,b);
            }

long answer = 1;
final int MOD = 1000000007;
for (int i = 1; i <= N; i++) {  
    if (narr[i] == i) {
        answer = (answer * size[i]) % MOD;
    }
}
bw.write(answer + "");
        bw.close();

        //이제 트리 갯수 찾아야지
    }

    public static void union(int x , int y )
    {
        x = find(x);
        y = find(y);

        if (x==y)
        {
            return;
        }

        if (rank[x]>rank[y])
        {
            narr[y] = x;
            size[x]+=size[y];
        } else if (rank[x] < rank[y]) {
            narr [x] = y;
            size[y] += size[x];
        } else if (rank[x] == rank[y])
        {
            narr[y] = x;
            rank[x]+=1;
            size[x]+=size[y];
        }
    }


    public static int find (int x)
    {
        if (narr[x] == x) {
            return x ;
        } else {
            return find (narr[x]) ;
        }
    }
}
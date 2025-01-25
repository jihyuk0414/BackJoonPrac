import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M,K;
    static int [] parent;
    static int [] size;
    
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int ts = 0 ; ts<T ; ts++)
        {
            sb.append("Scenario "+(ts+1)+":"+"\n");
            N = Integer.parseInt(br.readLine());
            parent = new int [N+1];  // N+1로 변경
            size = new int [N+1];    // N+1로 변경
            for (int i = 1 ; i<=N ; i++)  // 1부터 시작
                {
                    parent[i] = i;
                    size[i] = 1;
                }
            K = Integer.parseInt(br.readLine());
            for (int i = 0 ;i<K; i++)
                {
                    String [] kline = br.readLine().split(" ");
                    int a = Integer.parseInt(kline[0]);
                    int b = Integer.parseInt(kline[1]);
                    union(a,b);
                }
            M = Integer.parseInt(br.readLine());
            for (int i = 0 ; i<M; i++)
                {
                    String [] mline = br.readLine().split(" ");
                    int a = Integer.parseInt(mline[0]);
                    int b = Integer.parseInt(mline[1]);
                    String answer = (find(a) == find(b)) ? "1" : "0";  // find 메서드 사용
                    sb.append(answer+"\n");
                }
            if (ts != (T-1))
            {
                sb.append("\n");
            }
        }
    bw.write(sb.toString());
    bw.close();
    }
    public static int find(int index)
    {
        if (parent[index] == index)
        {
            return index;
        } else {
            return parent[index] = find(parent[index]);
        }
    }

    public static void union(int a, int b)
    {
        int parenta = find(a);
        int parentb = find(b);

        if (parenta == parentb)
        {
            return;
        } 

    if (size[parenta] < size[parentb]) {
        parent[parenta] = parentb;
        size[parentb] += size[parenta];
    } else {
        parent[parentb] = parenta;
        size[parenta] += size[parentb];
    }
    }
}
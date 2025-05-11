import java.util.*;
import java.io.*;

public class Main {

    public static List<int []> twolist = new ArrayList<>();
    public static List<int []> onelist = new ArrayList<>();
    public static int N,M;
    public static int [][] map ;
    public static int answer = Integer.MAX_VALUE ;
    

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);

        map = new int[N][N];
        for (int i = 0;i<N; i++)
        {
            String [] twoline = br.readLine().split(" ");
            for (int j = 0 ; j<N; j++)
            {
                map[i][j]= Integer.parseInt(twoline[j]);
            }
        }

        for (int i = 0;i<N; i++)
        {
            for (int j = 0 ; j<N; j++)
            {
                if (map[i][j] ==1 )
                {
                    onelist.add(new int [] {i,j});
                } else if (map[i][j] ==2)
                {
                    twolist.add(new int [] {i,j});
                }
            }
        }

        List<int [] > golist = new ArrayList<int [] > ();
        
        findcomb(0, golist,0);

        bw.write(String.valueOf(answer));
        bw.close();

    }

    public static void findcomb(int depth,List<int[]> golist , int before)
    {
        if (golist.size() == M)
        {
            int cnt = 0;
            for (int [] nowlist : onelist)
            {
                int smallest = Integer.MAX_VALUE;
                int onex = nowlist[0];
                int oney = nowlist[1];
                for (int [] nowtwolsit : golist)
                {
                    int twox = nowtwolsit[0];
                    int twoy = nowtwolsit[1];
                    smallest = Math.min(Math.abs(twox-onex)+Math.abs(twoy-oney),smallest); 
                }
                cnt += smallest;
            }
            answer = Math.min(cnt,answer);
            return;
        }

        for (int i = before ; i< twolist.size(); i++)
        {
            golist.add(twolist.get(i));
            findcomb(depth+1,golist,i+1);
            golist.remove(golist.size()-1);
        }

    }
}
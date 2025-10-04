import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int d = Integer.parseInt(oneline[1]);
        int k = Integer.parseInt(oneline[2]);
        int c = Integer.parseInt(oneline[3]);
        int answer= 0 ;
        int []  Nlist = new int [N*2];
        for (int i = 0 ; i<N; i++)
            {
                int go = Integer.parseInt(br.readLine());
                Nlist[i] = go;
                Nlist[N+i] = go;
            }

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i<k; i++)
            {
                map.put(Nlist[i],map.getOrDefault(Nlist[i],0)+1);
            }
       if (!map.containsKey(c)) {
        answer = map.size() + 1; 
        } 
       else {
            answer = map.size();
        }

        for (int i = k ; i<N+k ; i++)
            {
                map.put(Nlist[i],map.getOrDefault(Nlist[i],0)+1);
                map.put(Nlist[i-k],map.get(Nlist[i-k])-1);
                if(map.get(Nlist[i-k]) == 0)
                {
                    map.remove(Nlist[i-k]);
                }

                int cnt = map.keySet().size();
                if(!map.keySet().contains(c))
                {
                    cnt +=1;
                }
                 answer = Math.max(answer,cnt);
            }

        bw.write(String.valueOf(answer));
        bw.close();
        
        
    }
}
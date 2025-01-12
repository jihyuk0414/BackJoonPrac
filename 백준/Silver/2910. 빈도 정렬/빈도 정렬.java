import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");

        int N = Integer.parseInt(oneline[0]);
        int C = Integer.parseInt(oneline[1]);

        Map<Integer, Integer> nmap = new HashMap<>();
        Map<Integer, Integer> whoisfirst = new HashMap<>(); 
        String [] nline = br.readLine().split(" ");
        for (int i = 0 ; i<N ; i++)
            {
                int val = Integer.parseInt(nline[i]);
                nmap.put(val, nmap.getOrDefault(val,0)+1);

                if (!whoisfirst.containsKey(val))
                {
                    whoisfirst.put(val,i);
                }
            }

        List<Integer> vallist = new ArrayList<>(nmap.keySet());

        Collections.sort(vallist, (a,b) -> {
            int acnt = nmap.get(a);
            int bcnt = nmap.get(b);

            if (acnt == bcnt)
            {
                return whoisfirst.get(a)-whoisfirst.get(b);
            } else{
                return bcnt - acnt;
            }
        }); //이제 1,2,3이 정렬 완료 

        for (Integer val : vallist)
            {
                for (int i = 0 ; i<nmap.get(val); i++)
                    {
                        bw.write(val+" ");
                    }
            }
        
        bw.close();
    }
}
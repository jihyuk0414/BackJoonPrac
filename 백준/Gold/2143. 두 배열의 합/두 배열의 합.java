    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            Long T = Long.parseLong(br.readLine());
            int N = Integer.parseInt(br.readLine());
            String [] nstr = br.readLine().split(" ");
            int K = Integer.parseInt(br.readLine());
            String [] kstr = br.readLine().split(" ");

            int [] Narr = new int [N];
            int [] Karr = new int [K];

            Long answer = 0L;
            
            for (int i = 0 ; i<N; i++)
                {
                    Narr[i] = Integer.parseInt(nstr[i]);
                }
            for (int i = 0 ; i<K; i++)
                {
                    Karr[i] = Integer.parseInt(kstr[i]);
                }

            //한개씩 확인해보기
            Map<Long,Long> Nmap = new HashMap<>();
            Map<Long,Long> Kmap = new HashMap<>();

            for (int i = 0 ; i<N; i++)
                {
                    long val = Narr[i];
                    Nmap.put(val, Nmap.getOrDefault(val,0L)+1);
                    for (int j = i+1 ; j<N; j++)
                        {
                            val += Narr[j];
                            Nmap.put(val, Nmap.getOrDefault(val,0L)+1);
                        }
                }

            
            for (int i = 0 ; i<K; i++)
                {
                    long val = Karr[i];
                    Kmap.put(val, Kmap.getOrDefault(val,0L)+1);
                    for (int j = i+1 ; j<K; j++)
                        {
                            val += Karr[j];
                            Kmap.put(val, Kmap.getOrDefault(val,0L)+1);
                        }
                }
            for (long nkey : Nmap.keySet())
                {
                    long ncnt = Nmap.get(nkey);
                    long kval = T-nkey;

                    long kcnt = Kmap.getOrDefault(kval,0L);
                    answer += (ncnt*kcnt);
                }

            bw.write(String.valueOf(answer));
            bw.close();
        }
    }
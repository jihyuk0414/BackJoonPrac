import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static char [] chararr = new char [] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> Nlist = new ArrayList<>();
        for (int i= 0; i<N; i++)
            {
                Nlist.add(br.readLine());
            }

        int answer = 0;

        for (int i = 0 ; i<N; i++)
            {
                String nowa = Nlist.get(i);
                for (int j = i+1; j<N; j++)
                    {
                        String nowb = Nlist.get(j);
                        Map <Character, Integer> amap = new HashMap<>();
                        Map <Character, Integer> bmap = new HashMap<>();
                        boolean ok = true;
                        for (int where = 0; where<nowa.length(); where ++)
                            {
                                char a = nowa.charAt(where);
                                char b = nowb.charAt(where);

                                if(amap.keySet().contains(a) || bmap.keySet().contains(b))
                                {
                                        int aidx = amap.keySet().contains(a) ? amap.get(a) : -1;
                                    int bidx = bmap.keySet().contains(b) ? bmap.get(b) : -1;

                                    if (aidx == bidx)
                                    {
                                        amap.put(a,where);
                                        bmap.put(b,where);
                                    }
                                    else
                                    {
                                        ok = false;
                                    }
                                }
                                else
                                {
                                    amap.put(a,where);
                                    bmap.put(b,where);
                                }
                            }
                        if(ok)
                        {
                            answer +=1;
                        }
                    }
            }

        bw.write(String.valueOf(answer));
        bw.close();
        
    }
}
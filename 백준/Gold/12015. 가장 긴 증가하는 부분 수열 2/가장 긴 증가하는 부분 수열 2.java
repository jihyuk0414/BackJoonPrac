import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N ; 
    static List<Integer> Nlist = new ArrayList<>();
    static int [] Narr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String [] nstr = br.readLine().split(" ");
        Narr = new int[N];

        for (int i = 0 ; i < N ; i++)
            {
                Narr[i] = Integer.parseInt(nstr[i]);
            }

        Nlist.add(Narr[0]);

        for (int i = 1 ; i<N ; i++)
            {
                int currentval = Nlist.get(Nlist.size()-1);
                if (currentval < Narr[i])
                {
                    Nlist.add(Narr[i]);
                } else {
                    findlocation(0,Nlist.size(),Narr[i]);
                }

            }


        bw.write(String.valueOf(Nlist.size()));
        bw.close();

        
    }

    public static void findlocation(int start, int end, int findval)
    {
        int mid = 0;
        while (start<end)
            {
                mid = (start+end)/2;
                if(findval <= Nlist.get(mid))
                {
                    end = mid;
                } else{
                    start = mid +1;
                }
            }
        Nlist.set(end, findval);
        
    }

}
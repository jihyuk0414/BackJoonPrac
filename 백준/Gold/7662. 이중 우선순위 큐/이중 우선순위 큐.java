import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int z = 0; z<T ; z++)
            {
                int k = Integer.parseInt(br.readLine());

                TreeMap<Integer,Integer> tree = new TreeMap<>();

                for (int j = 0 ; j<k; j++)
                    {
                        String [] oneline = br.readLine().split(" ");

                        char I = oneline[0].charAt(0);

                        if (I == 'I')
                        {
                            tree.put(Integer.parseInt(oneline[1]), tree.getOrDefault(Integer.parseInt(oneline[1]),0)+1);
                        } else {
                            if(tree.size() == 0 )
                            {
                                continue;
                            }

                             int num = Integer.parseInt(oneline[1]);
                            
                             int key = num == 1 ? tree.lastKey() : tree.firstKey();
                            int cnt = tree.get(key);
                    
                            if (cnt == 1) {
                        tree.remove(key);
                            } else {
                        tree.put(key, cnt - 1);
                        }
                        }
                    }

                if (tree.size() == 0 )
                {
                    bw.write("EMPTY");
                } else{
                    
                    bw.write(tree.lastKey() + " " + tree.firstKey());
                }

                if(z != T-1)
                {
                    bw.write("\n");
                }
            }
        bw.close();
    }
}
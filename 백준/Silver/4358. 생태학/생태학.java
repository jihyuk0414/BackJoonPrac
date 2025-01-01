import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String tree ; 
        Map<String,Integer> treeset = new HashMap<>();

        while((tree = br.readLine())!=null)
            {
                treeset.put(tree,treeset.getOrDefault(tree,0)+1);
            }

        int total = 0;

        for(String treekey : treeset.keySet())
            {
                total+= treeset.get(treekey);
            }

        //정렬 해야 된다.. List를 써먹자
        List<String> treelist = new ArrayList<>(treeset.keySet());
        Collections.sort(treelist);

        StringBuilder sb = new StringBuilder();

        for(String treekey : treelist)
            {
                sb.append(String.format("%s %.4f%n", treekey, (double)treeset.get(treekey)/total*100));
            }
        bw.write(sb.toString());
        bw.close();
    }
}
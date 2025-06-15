import java.util.*;
import java.lang.*;
import java.io.*; 




// The main method must be in a class named "Main".
class Main {

    static List<List<Integer>> graph = new LinkedList<>();

    static int r,c,k;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        r = Integer.parseInt(firstline[0])-1;
        c = Integer.parseInt(firstline[1])-1;
        k = Integer.parseInt(firstline[2]);
        for (int i = 0 ; i<3; i++)
            {
                List<Integer> newlist = new ArrayList<>();
                String [] oneline  = br.readLine().split(" ");
                for (int j = 0 ; j<oneline.length; j++)
                    {
                        newlist.add(Integer.parseInt(oneline[j]));
                    }
                graph.add(newlist);
            }

        int time = 0 ;

        while (time <=100)
            {
                if(graph.size() > r && graph.get(r).size() >c)
                {
                    if(graph.get(r).get(c) == k )
                    {
                        bw.write(String.valueOf(time));
                        bw.close();
                        return;
                    }
                }

                int rcnt = graph.size();
                int ccnt = graph.get(0).size();

                if (rcnt>=ccnt)
                {
                    
                    List<List<Integer>> newgraph = new LinkedList<>();
                    int maxcnt = 0;
                    //행연산
                    for (List<Integer> onelinelist : graph)
                        {
                            Map<Integer, Integer> checkmap = new HashMap<>();
                            for (int i = 0 ; i<onelinelist.size(); i++)
                                {
                                    if (onelinelist.get(i) != 0 )
                                    {
                                        checkmap.put(onelinelist.get(i), checkmap.getOrDefault(onelinelist.get(i),0)+1);
                                    }
                                }

                            List<int []> keylist = new ArrayList<>();
                            for (Integer key : checkmap.keySet())
                                {
                                    keylist.add(new int [] {key,checkmap.get(key)});
                                }

                            Collections.sort(keylist, (a,b) -> {
                                if (a[1] == b[1])
                                {
                                    return a[0]-b[0];
                                }
                                return a[1]-b[1];
                            });

                            //만든 list 돌면서 onelinenewlist 만들고, newgraph에 하나씩 추가

                            List<Integer> onelinenewlist = new ArrayList<>();
                            newgraph.add(onelinenewlist);
                            for (int[] pair : keylist) {
                                onelinenewlist.add(pair[0]);
                                onelinenewlist.add(pair[1]);
                            }
                            maxcnt = Math.max(onelinenewlist.size(), maxcnt);
                        }

                    //갯수 맞춰서 0 넣어주기
                    for (List<Integer> newonelinelist : newgraph)
                        {
                            if (newonelinelist.size() < maxcnt)
                            {
                                int gomax = maxcnt-newonelinelist.size();
                                for (int j = 0; j<gomax; j++)
                                    {
                                        newonelinelist.add(0);
                                    }
                            }
                        }

                    graph = newgraph;

                }else
{
    // 열연산
    int rowCount = graph.size();
    int colCount = graph.get(0).size();
    
    List<List<Integer>> newgraph = new LinkedList<>();
    int maxcnt = 0;
    
    // 각 열에 대해 연산
    for (int col = 0; col < colCount; col++)
    {
        Map<Integer, Integer> checkmap = new HashMap<>();
        
        // 해당 열의 모든 행에서 값 추출
        for (int row = 0; row < rowCount; row++)
        {
            int val = graph.get(row).get(col);
            if (val != 0)
            {
                checkmap.put(val, checkmap.getOrDefault(val, 0) + 1);
            }
        }
        
        List<int []> keylist = new ArrayList<>();
        for (Integer key : checkmap.keySet())
        {
            keylist.add(new int [] {key,checkmap.get(key)});
        }
        
        Collections.sort(keylist, (a,b) -> {
            if (a[1] == b[1])
            {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        List<Integer> onelinenewlist = new ArrayList<>();
        for (int[] pair : keylist) {
            onelinenewlist.add(pair[0]);
            onelinenewlist.add(pair[1]);
        }
        
        newgraph.add(onelinenewlist);
        maxcnt = Math.max(onelinenewlist.size(),maxcnt);
    }
    
    // 갯수 맞춰서 0 넣어주기
    for (List<Integer> newonelinelist : newgraph)
    {
        if (newonelinelist.size() < maxcnt)
        {
            int gomax = maxcnt-newonelinelist.size();
            for (int j = 0; j<gomax; j++)
            {
                newonelinelist.add(0);
            }
        }
    }
    
    int firscnt = newgraph.get(0).size();
    int first2cnt = newgraph.size();
    
    graph = new LinkedList<>();
    for (int i = 0 ; i<firscnt; i++)
    {
        graph.add(new LinkedList<>());
    }
    
    for (int i = 0 ; i< graph.size(); i++)
    {
        List<Integer> now = graph.get(i);
        for (int j = 0 ; j< first2cnt; j++)
        {
            now.add(newgraph.get(j).get(i));
        }
    }
}

                time ++;

                
            }


                        bw.write("-1");
                        bw.close();
        return;
    }
}
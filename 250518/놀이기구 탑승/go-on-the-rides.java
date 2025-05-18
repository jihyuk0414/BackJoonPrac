import java.util.*;
import java.io.*;

public class Main {

    public static int n;
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static int [][] graph;
    static Map <Integer,List<Integer>> map = new HashMap<>(); // 나, 좋아하는 4개
    static List<Integer> melist = new ArrayList<>();
    static int [] correctarr = new int [] {0,1,10,100,1000};

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Please write your code here.

        n = Integer.parseInt(br.readLine());
        int answer = 0 ;
        graph = new int [n][n];

        for (int i = 0 ; i < n*n ; i++)
        {
            String [] oneline = br.readLine().split(" ");
            int me = Integer.parseInt(oneline[0]);
            melist.add(me);
            List<Integer> friendlist = new ArrayList<>();
            for (int j = 1 ; j <5; j++)
            {
                friendlist.add(Integer.parseInt(oneline[j]));
            }
            map.put(me,friendlist);
        }

        for (Integer me : melist)
        {
            // 상하 좌우 중 좋아하는 수, 비어있는 수, 행 번호, 열 번호를 list에 담기
            List<int []> findlist = new ArrayList<>(); 
            for (int i = 0 ; i<n ; i++)
            {
                for (int j = 0 ; j<n; j++)
                {                    
                    if(graph[i][j] !=0)
                    {
                        continue;
                    }
                    int likecnt = 0 ;
                    int emptycnt = 0 ;

                    for (int z = 0 ; z<4; z++)
                    {
                        int nx = i+dx[z];
                        int ny = j+dy[z];

                        if (0<=nx && nx<n && 0<=ny && ny<n)
                        {
                            if(map.get(me).contains(graph[nx][ny]))
                            {
                                likecnt +=1;
                            }

                            if (graph[nx][ny] == 0 )
                            {
                                emptycnt +=1;
                            }
                        }
                    }

                    int [] find = new int [] {likecnt,emptycnt,i,j};
                    findlist.add(find);
                }
            }

            //정렬
            Collections.sort(findlist, (a,b) -> 
            {
                if (a[0] == b[0])
                {
                    if (a[1] == b[1])
                    {
                        if (a[2] == b[2])
                        {
                            return a[3] - b[3];
                        }

                        return a[2]-b[2];

                    }

                    return b[1]-a[1];

                }

                else 
                {
                    return b[0] -a[0];
                }
            });

            graph[findlist.get(0)[2]][findlist.get(0)[3]] = me;
        }

           for (int i = 0 ; i<n ; i++)
            {
                for (int j = 0 ; j<n; j++)
                {                    
                    int likecnt = 0 ;
                    int me = graph[i][j];

                    for (int z = 0 ; z<4; z++)
                    {
                        int nx = i+dx[z];
                        int ny = j+dy[z];

                        if (0<=nx && nx<n && 0<=ny && ny<n)
                        {
                            if(map.keySet().contains(me) && map.get(me).contains(graph[nx][ny]))
                            {
                                likecnt +=1;
                            }
                        }
                    }

                    answer += correctarr[likecnt];
                }
            }

        bw.write(String.valueOf(answer));
        bw.close();


    }
}
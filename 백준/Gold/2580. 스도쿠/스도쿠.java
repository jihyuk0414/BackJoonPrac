import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int [] [] map = new int [9][9];
    static int [] [] answermap = new int [9][9];
    static List<int []> zerolist = new LinkedList<>();
    static boolean finish = false;
    public static void main(String[] args) throws IOException {

        for (int i = 0 ; i<9 ; i++)
            {
                String [] oneline = br.readLine().split(" ");
                for (int j = 0 ; j<9 ; j++)
                    {
                        map[i][j] = Integer.parseInt(oneline[j]);
                    }
            }

        for (int i = 0 ; i<9 ; i++)
            {
                for (int j = 0 ; j<9 ; j++)
                    {
                        if(map[i][j] ==0 )
                        {
                            int [] zeroarr = {i,j};
                            zerolist.add(zeroarr);
                        }
                    }
            }

        dfs(0);
        for (int i = 0 ;i<9; i++)
            {
                for (int j = 0 ; j<9; j++)
                    {
                        bw.write(String.valueOf(map[i][j])+" ");
                    }
                bw.write("\n");
            }
        bw.close();

        
        
    }

    public static boolean dfs (int depth)
    {
        if (depth == zerolist.size())
        {
            return true;
        }

        int x = zerolist.get(depth)[0];
        int y = zerolist.get(depth)[1];

        for (int i = 1; i <= 9; i++) {
            if (checkmap(x, y, i)) {
                map[x][y] = i;
                if (dfs(depth + 1)) {
                    return true;
                }
                map[x][y] = 0;
            }
        }
        return false;
    }

    public static boolean checkmap(int x, int y, int val)
    {
        for (int i = 0 ; i<9 ;i++)
            {
                if(map[x][i] == val)
                {
                    return false;
                }
            }
        
        for (int i = 0 ; i<9 ;i++)
            {
                if(map[i][y] == val)
                {
                    return false;
                }
            }

        int xstart = x -(x%3);
        int ystart = y -(y%3);

        for (int i = xstart ; i<xstart+3; i++)
            {
                for (int j = ystart ; j<ystart+3; j++)
                    {
                        if(map[i][j] == val)
                        {
                            return false;
                        }
                    }
            }

        return true;

    }


}

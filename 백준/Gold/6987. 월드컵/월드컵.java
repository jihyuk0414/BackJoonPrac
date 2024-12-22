import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int [][] map = new int [6][3];
    static int [][] game = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
    static int [][] gameresult ;
    static boolean [] [] visited;
    static int answer = -1;

    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int x= 0 ; x<4 ; x++)
            {
                String [] oneline = br.readLine().split(" ");
                int onelinecheck = 0 ;

                gameresult = new int[6][3];
        
                for (int i = 0 ;i< 6; i++)
                    {
                        for (int j = 0 ; j<3; j++)
                        {
                            map[i][j] = Integer.parseInt(oneline[onelinecheck]);
                            onelinecheck+=1;
                        }
                    }

                bw.write(dfs(0) ? "1 " : "0 ");
                
            }
        bw.close();

       
    }

    public static boolean check()
    {
        for (int i = 0 ; i<6 ; i++)
            {
                for (int j = 0; j<3 ; j++)
                    {
                        if(gameresult[i][j]!=map[i][j])
                        {
                            return false;
                        }
                    }
            }
        return true;
    }

    public static boolean dfs(int depth)
    {
        if (depth == 15)
        {
            return check();
        }

        int team1 = game[depth][0];
        int team2 = game[depth][1];

        //1팀 승
        gameresult[team1][0] +=1;
        gameresult[team2][2] +=1 ;
        if (dfs(depth+1))
        {
            return true;
        }
        gameresult[team1][0] -=1;
        gameresult[team2][2] -=1 ;

        //무승부
        gameresult[team1][1] +=1;
        gameresult[team2][1] +=1 ;
        if (dfs(depth+1))
        {
            return true;
        }
        gameresult[team1][1] -=1;
        gameresult[team2][1] -=1 ;

        //2팀 승
        gameresult[team2][0] +=1;
        gameresult[team1][2] +=1 ;
        if (dfs(depth+1))
        {
            return true;
        }
        gameresult[team2][0] -=1;
        gameresult[team1][2] -=1 ;  

        return false;
        
    }

    
}
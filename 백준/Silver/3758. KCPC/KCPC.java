import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int z = 0; z<T  ; z++)
            {
                String [] oneline = br.readLine().split(" ");
                int n = Integer.parseInt(oneline[0]);
                int k = Integer.parseInt(oneline[1]);
                int myteam = Integer.parseInt(oneline[2]);
                int m = Integer.parseInt(oneline[3]);

                int [][] answerarr = new int [k+1][2]; //점수(젤높은거),어떤 팀인지지
                
                int [][] teamanswer = new int [n+1][4]; //팀 별 점수, 팀 별 풀이수, 팀 별 가장 최근 제출 시간,팀명
                for (int i = 1; i<= n ; i++)
                    {
                        teamanswer[i][3] = i;
                    }
                int[][] teamScore = new int[n+1][k+1];  


for (int i = 0; i < m; i++) {
    String[] twoline = br.readLine().split(" ");
    int teamid = Integer.parseInt(twoline[0]);
    int question = Integer.parseInt(twoline[1]);
    int localpoint = Integer.parseInt(twoline[2]);
    teamanswer[teamid][1] += 1;  
    teamanswer[teamid][2] = i;   
    teamScore[teamid][question] = Math.max(teamScore[teamid][question], localpoint);
}

for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= k; j++) {
        teamanswer[i][0] += teamScore[i][j];
    }
}

                for (int i =1 ; i<=k; i++)
                    {
                        int whoteam = answerarr[i][1];
                        teamanswer[whoteam][0]+= answerarr[i][0];
                    }

                

                Arrays.sort(teamanswer,1,n+1, (a,b) -> {
                    if (a[0] == b[0])
                    {
                        if(a[1] ==b[1])
                        {
                            return a[2]-b[2];
                        } else{
                            return a[1]-b[1];
                        }
                    } else {
                        return b[0]-a[0];
                    }
                });

                for (int i =1 ; i<= n ; i++)
                    {
                        if(teamanswer[i][3] == myteam)
                        {
                            bw.write(String.valueOf(i));
                        }
                    }
                if(z != T-1)
                {
                    bw.write("\n");
                }
            }


        bw.close();
    }
}
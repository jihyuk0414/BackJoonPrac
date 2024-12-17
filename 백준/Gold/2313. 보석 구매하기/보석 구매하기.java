import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int N = Integer.parseInt(br.readLine());
       
       long realanswer = 0;
       int[][] answerarr = new int[N][2];
       for(int x = 0; x < N; x++) {
           int L = Integer.parseInt(br.readLine());
           int[] Llist = new int[L+1];
           String[] oneline = br.readLine().split(" ");
           for(int i = 1; i <= L; i++) {
               Llist[i] = Integer.parseInt(oneline[i-1]);
           }
           
           long[] dp = new long[L+1];
           dp[1] = Llist[1];
           
           long answer = dp[1];
           int jewelcnt = 1;
           int arrwhere = 1;
           int start = 1;
           
           for(int i = 2; i <= L; i++) {
               if(Llist[i] >= dp[i-1] + Llist[i]) {
                   dp[i] = Llist[i];
                   start = i;
               } else {
                   dp[i] = dp[i-1] + Llist[i];
               }
               
               if(dp[i] > answer) {
                   answer = dp[i];
                   jewelcnt = i - start + 1;
                   arrwhere = i;
               } else if(dp[i] == answer) {
                   int newJewelcnt = i - start + 1;
                   if(jewelcnt > newJewelcnt) {
                       jewelcnt = newJewelcnt;
                       arrwhere = i;
                   } else if(jewelcnt == newJewelcnt) {
                       boolean needupdate = false;
                       for(int k = 0; k < jewelcnt; k++) {
                           if(Llist[start+k] < Llist[arrwhere-jewelcnt+1+k]) {
                               needupdate = true;
                               break;
                           }
                           else if(Llist[start+k] > Llist[arrwhere-jewelcnt+1+k]) {
                               break;
                           }
                       }
                       if(needupdate) {
                           arrwhere = i;
                           start = start;
                       }
                   }
               }
           }
           
           realanswer += answer;
           answerarr[x][0] = (arrwhere-jewelcnt+1);
           answerarr[x][1] = arrwhere;
       }
       bw.write(String.valueOf(realanswer)+"\n");
       for(int i = 0; i < N; i++) {
           bw.write(answerarr[i][0] + " " + answerarr[i][1]+"\n");
       }
       bw.close();
   }
}
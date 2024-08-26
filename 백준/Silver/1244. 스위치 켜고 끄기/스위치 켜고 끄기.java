import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N =  Integer.parseInt(br.readLine());

        String[] Nstr= br.readLine().split(" ");

        int [] Nlist = new int[N];
        for (int i = 0 ; i < N ; i++)
            {
                Nlist[i] = Integer.parseInt(Nstr[i]);
            }

        int children = Integer.parseInt(br.readLine());

        for (int i =0 ; i<children; i++)
            {
                String[] inputarr = br.readLine().split(" ");
                int gender= Integer.parseInt(inputarr[0]);
                int num = Integer.parseInt(inputarr[1])-1;

                if(gender == 1)
                {
                    for (int j = num; j < N; j += (num + 1)) {
                    Nlist[j] = Nlist[j] == 1 ? 0 : 1;
                }
                }else{
                    //여자라면
                    Nlist[num] = (Nlist[num] == 1) ? 0 : 1;
                    int left= num-1;
                    int right= num+1;
                    while (left>=0 && right <N && (Nlist[left] == Nlist[right])) {
                        Nlist[left] = (Nlist[left]== 1)? 0 : 1 ;
                        Nlist[right] = (Nlist[right] == 1)? 0 : 1 ;
                        left-=1;
                        right+=1;
                        continue;
                        }
         
                    }
                }

                //출력 
        for (int i =0 ; i<N ; i++)
            {
                bw.write(Nlist[i]+" ");
                if((i+1) % 20 == 0 )
                {
                    bw.write("\n");
                }
            }

        bw.flush();
        br.close();
        bw.close();
        }
    


}

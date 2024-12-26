import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Integer> button = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());
        String targetstr = String.valueOf(target);
        int N = Integer.parseInt(br.readLine());

        if (N > 0) {  
            String[] oneline = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                Integer val = Integer.parseInt(oneline[i]);
                button.remove(val);
            }
        }
        
        int answer = Math.abs(target-100);//암것도 안하고 가만히 있을때

        for (int i = 0; i<=999999 ; i++)
            {               
                if(possible(i))
                {
                    int cnt = 0 ;
                    cnt += Math.abs(target-i);
                    cnt += String.valueOf(i).length();
                    answer = Math.min(answer,cnt);
                }
            }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static boolean possible(int i )
    {
        if (i ==0)
        {
            return button.contains(0);
        }
        
        while(i > 0)
            {
                if (!button.contains(i%10))
                {
                    return false;
                } else {
                    i /= 10;
                }
            }
        return true;
    }

}
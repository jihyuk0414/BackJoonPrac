import java.util.*;
import java.io.*;

public class Main {

    static int k ;
    static int [][] Narr = new int [4][8];

    public static void main(String[] args)  throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0 ; i<4; i++)
        {
            Narr[i] = new int [8];
            String oneline = br.readLine();
            for (int j = 0 ; j<oneline.length(); j++)
            {
                Narr[i][j] = Character.getNumericValue(oneline.charAt(j));
            }
        }

        k = Integer.parseInt(br.readLine());

        //1. 회전
       for (int run = 0; run < k; run++) {
    String[] oneline = br.readLine().split(" ");
    int next = Integer.parseInt(oneline[0])-1;
    int direction = Integer.parseInt(oneline[1]);
    
    //2. 마주보는게 다르다면 회전할 애들 다 정해놓고
    List<int[]> findidx = new ArrayList<>();
    
    // 시작 톱니바퀴도 리스트에 추가
    int[] startGear = new int[2];
    startGear[0] = next;
    startGear[1] = direction;
    findidx.add(startGear);
    
    findidx(findidx, direction, next);
    
    for (int[] nextarr : findidx) {
        int nextgo = nextarr[0];
        int nextdir = nextarr[1];
        
        roll(nextdir, nextgo);
    }
}

        int answer = 0 ;

        for (int i = 0; i < 4; i++) {
            answer += Narr[i][0] * Math.pow(2, i);  // 첫 번째 톱니바퀴의 값을 기준으로 계산
        }
        bw.write(answer+"");
        bw.close();
    }

    public static void roll (int direction, int which)
    {
        if (direction== 1)
        {
            int save = Narr[which][7];
            //시계방향 회전 
            int [] newarr = new int[8];
            for (int i = 0 ; i<7; i++)
            {
                newarr[i+1] = Narr[which][i];
            }
            newarr[0] = save;
            Narr[which] = newarr;
        } else 
        {
            int save = Narr[which][0];
            // 반시계방향 회전 
            int [] newarr = new int[8];
            for (int i = 0 ; i<7; i++)
            {
                newarr[i] = Narr[which][i+1];
            }
            newarr[7] = save;
            Narr[which] = newarr;
        }
    }

   public static void findidx(List<int[]> list, int direction, int startidx) {
    int leftDirection = direction;
    
    // 왼쪽 방향 처리
    for (int i = startidx - 1; i >= 0; i--) {
        if (Narr[i][2] != Narr[i+1][6]) {
            leftDirection = -leftDirection; // 방향 전환
            int[] newline = new int[2];
            newline[0] = i;
            newline[1] = leftDirection;
            list.add(newline);
        } else {
            break; // 더 이상 회전이 전달되지 않음
        }
    }
    
    int rightDirection = direction;
    
    // 오른쪽 방향 처리
    for (int i = startidx + 1; i < 4; i++) {
        if (Narr[i-1][2] != Narr[i][6]) {
            rightDirection = -rightDirection; // 방향 전환
            int[] newline = new int[2];
            newline[0] = i;
            newline[1] = rightDirection;
            list.add(newline);
        } else {
            break; // 더 이상 회전이 전달되지 않음
        }
    }
}
}
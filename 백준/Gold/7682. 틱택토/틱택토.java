import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static char[][] map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true)
            {
                String oneline = br.readLine();
                if (oneline.equals("end"))
                {
                    bw.close();
                    return;
                }

                map = new char[3][3];
                int inputcheckindex=  0 ;
                
                for (int i = 0 ; i <3 ; i++)
                    {
                        for (int j = 0 ; j<3 ; j++)
                            {
                                map[i][j] = oneline.charAt(inputcheckindex);
                                inputcheckindex+=1;
                            }
                    }

                if (check()) {
                    bw.write("valid");
                } else {
                    bw.write("invalid");
                }
                bw.write("\n");
            }
        
    }

public static boolean check() {
    int zerowin = 0;
    int xwin = 0;
    
    for (int i = 0; i < 3; i++) {
        if (map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
            if (map[i][0] == 'O') zerowin++;
            else if (map[i][0] == 'X') xwin++;
        }
    }
  
    for (int i = 0; i < 3; i++) {
        if (map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
            if (map[0][i] == 'O') zerowin++;
            else if (map[0][i] == 'X') xwin++;
        }
    }
    

    if (map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
        if (map[0][0] == 'O') zerowin++;
        else if (map[0][0] == 'X') xwin++;
    }
    
    if (map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
        if (map[0][2] == 'O') zerowin++;
        else if (map[0][2] == 'X') xwin++;
    }
    
    // X와 O의 개수 세기
    int xcnt = 0, ocnt = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (map[i][j] == 'X') xcnt++;
            else if (map[i][j] == 'O') ocnt++;
        }
    }
    
    // 게임 상태 검증
    if (xcnt < ocnt || xcnt > ocnt + 1) return false;
    
    // X가 이긴 경우
    if (xwin > 0 && zerowin == 0) {
        return xcnt == ocnt + 1;
    }
    
    // O가 이긴 경우
    if (zerowin > 0 && xwin == 0) {
        return xcnt == ocnt;
    }
    
    // 무승부인 경우
    if (xwin == 0 && zerowin == 0) {
        return xcnt + ocnt == 9; // 보드가 가득 찬 경우만 유효
    }
    
    return false; // 둘 다 이긴 경우 등 나머지 모든 경우는 무효
}
    public static boolean checkfull()
    {
        for (int i = 0 ; i<3 ; i++)
            {
                for (int j=0 ; j<3 ; j++)
                    {
                        if(map[i][j] == '.')
                        {
                            return false;
                        }
                    }
            }
        return true;
    }

    public static boolean whoismuch()
    {
        int ocnt = 0 ;
        int xcnt = 0 ;
        for (int i = 0 ; i<3 ; i++)
            {
                for (int j=0 ; j<3 ; j++)
                    {
                        if(map[i][j] == 'O')
                        {
                            ocnt+=1;
                        } else if (map[i][j] == 'X')
                        {
                            xcnt+=1;
                        }
                    }
            }

        return ((xcnt-1 == ocnt) || xcnt == ocnt) ;
    }
}

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] firstline = br.readLine().split(" ");
        int N = Integer.parseInt(firstline[0]);
        int K = Integer.parseInt(firstline[1]);
        int Q = Integer.parseInt(firstline[2]);
        int M = Integer.parseInt(firstline[3]);
        
        // 기상하지 않는 사람들
        Set<Integer> sleepingList = new HashSet<>();
        String[] twoline = br.readLine().split(" ");
        for(String s : twoline) {
            sleepingList.add(Integer.parseInt(s));
        }
        
        // 기상시키는 사람들
        String[] threeline = br.readLine().split(" ");
        List<Integer> startmember = new ArrayList<>();
        for(String s : threeline) {
            startmember.add(Integer.parseInt(s));
        }
        
        boolean[] personlist = new boolean[N + 3];
        // 기상시키기
        for(Integer nowmember : startmember) {
            if(sleepingList.contains(nowmember)) continue;
            for(int i = nowmember; i <= N + 2; i += nowmember) {
                if(!sleepingList.contains(i)) {
                    personlist[i] = true;
                }
            }
        }
        
        // 누적 합 배열 생성
        int[] prefix = new int[N + 3];
        for(int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i-1];
            if(!personlist[i]) {
                prefix[i]++;
            }
        }
        
        // 쿼리 처리
        for(int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            int start = Integer.parseInt(query[0]);
            int end = Integer.parseInt(query[1]);
            bw.write(String.valueOf(prefix[end] - prefix[start-1]));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
    }
}
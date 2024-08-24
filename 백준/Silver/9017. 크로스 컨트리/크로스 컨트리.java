import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int trash = Integer.parseInt(br.readLine());
            String[] Nlist = br.readLine().split(" ");
            HashMap<Integer, Integer> moresixHash = new HashMap<>();

            // 팀별 주자 수 세기
            for (int j = 0; j < trash; j++) {
                int team = Integer.parseInt(Nlist[j]);
                moresixHash.put(team, moresixHash.getOrDefault(team, 0) + 1);
            }

            List<Integer> nolist = new ArrayList<>();
            // 6명 미만인 팀 구하기
            for (Integer intval : moresixHash.keySet()) {
                if (moresixHash.get(intval) < 6) {
                    nolist.add(intval);
                }
            }

            HashMap<Integer, int[]> NHash = new HashMap<>();
            int nowrank = 1;

            // 점수 계산
            for (String s : Nlist) {
                int nextteam = Integer.parseInt(s);
                if (!nolist.contains(nextteam)) {
                    if (NHash.containsKey(nextteam)) {
                        int[] data = NHash.get(nextteam);
                        if (data[0] < 4) {
                            data[0] += 1;
                            data[1] += nowrank;
                        } else if (data[0] == 4) {
                            data[0] += 1;
                            data[2] = nowrank;
                        }
                        NHash.put(nextteam, data); // 변경된 배열 값 업데이트
                    } else {
                        NHash.put(nextteam, new int[]{1, nowrank, 0}); // 새 팀 추가
                    }
                    nowrank += 1;
                }
            }

            // 최적의 팀 찾기
            int bestTeam = -1;
            int minSum = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            // 모든 팀을 순회하며 최적의 팀을 결정
            for (Integer key : NHash.keySet()) {
                int[] tmp = NHash.get(key);
                int sum = tmp[1];
                int fifth = tmp[2];
                
                if (sum < minSum || (sum == minSum && fifth < minFifth)) {
                    minSum = sum;
                    minFifth = fifth;
                    bestTeam = key;
                }
            }

            bw.write(bestTeam + "\n");
        }

        bw.flush();
        bw.close();
        br.close(); // BufferedReader 닫기
    }
}
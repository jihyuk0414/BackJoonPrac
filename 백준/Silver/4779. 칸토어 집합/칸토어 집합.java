import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputstr;
        while ((inputstr = br.readLine()) != null) {
            int N = Integer.parseInt(inputstr);
            int threeN = (int) Math.pow(3, N); // 3^N 계산
            String[] answerstr = new String[threeN];
            for (int i = 0; i < threeN; i++) {
                answerstr[i] = "-";
            }
            dojob(N, 0, answerstr, 0, threeN, N);
            
            // 결과 출력
            for (String s : answerstr) {
                bw.write(s);
            }
            bw.write("\n");
        }

        bw.flush(); // 남아있는 내용을 모두 출력합니다.
        bw.close(); // BufferedWriter를 닫습니다.
    }

    public static void dojob(int N, int depth, String[] answerstr, int start, int end, int realendN) {
        if (depth == realendN) {
            return; 
        }

        // 가운데 자르기
        for (int i = start; i < end; i++) {
            if (i >= (int) (Math.pow(3, N - 1) + start) && i < (int) (Math.pow(3, N - 1) * 2 + start)) {
                answerstr[i] = " ";
            }
        }

        dojob(N - 1, depth + 1, answerstr, start, (int) Math.pow(3, N - 1) + start, realendN);
        dojob(N - 1, depth + 1, answerstr, (int) (Math.pow(3, N - 1) * 2 + start), end, realendN);
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       List<String> otherlist = new ArrayList<>();
       int N = Integer.parseInt(br.readLine()); 
       String answerstr = br.readLine();
       int realans = 0;
       
       for (int z = 0; z < N-1; z++) {
           String line = br.readLine();
           otherlist.add(line);
       } 
       
       for(String nowstr : otherlist) {
           if(samegusang(answerstr, nowstr)) {
               realans += 1;
           }
       }
       
       bw.write(String.valueOf(realans));
       bw.close();
   }
   
   public static boolean samegusang(String answer, String compare) {
       // 길이 차이가 1보다 크면 false
       if (Math.abs(answer.length() - compare.length()) > 1) {
           return false;
       }
       
       Map<Character,Integer> answermap = new HashMap<>();
       Map<Character,Integer> comparemap = new HashMap<>();
       
       for (int i = 0; i < answer.length(); i++) {
           answermap.put(answer.charAt(i), answermap.getOrDefault(answer.charAt(i),0)+1);
       }
       
       for (int i = 0; i < compare.length(); i++) {
           comparemap.put(compare.charAt(i), comparemap.getOrDefault(compare.charAt(i),0)+1);
       }

       Set<Character> totalset = new HashSet<>();
       totalset.addAll(answermap.keySet());
       totalset.addAll(comparemap.keySet());
       
       // 길이가 같은 경우와 다른 경우를 구분
       if (answer.length() == compare.length()) {
           int diffCount = 0;
           for (Character c : totalset) {
               int answermany = answermap.getOrDefault(c,0);
               int comparemany = comparemap.getOrDefault(c,0);
               diffCount += Math.abs(answermany - comparemany);
           }
           return diffCount <= 2;  // 최대 한 문자만 다를 수 있음 (바꾸기는 2개의 차이를 만듦)
       } else {
           // 길이가 다른 경우
           int simillar = 1;
           for (Character onekey : totalset) {
               int answermany = answermap.getOrDefault(onekey,0);
               int comparemany = comparemap.getOrDefault(onekey,0);
               if (answermany == 0 || comparemany == 0) {
                   simillar -= 1;
               } else {
                   int diff = Math.abs(answermany-comparemany);
                   simillar -= diff;
               }
           }
           return simillar >= 0;
       }
   }
}
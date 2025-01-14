import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String original = br.readLine();
        String bomb = br.readLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            result.append(original.charAt(i));

            if (result.length() >= bomb.length() && result.substring(result.length() - bomb.length()).equals(bomb)) {
                result.delete(result.length() - bomb.length(), result.length());
            }
        }

        String answer = result.length() != 0 ? result.toString() : "FRULA";
        bw.write(answer);
        bw.close();
    }
}

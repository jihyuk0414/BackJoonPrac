import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char test;
        String output = "";

        for (int i = 0; i < a.length(); i++) {
            test = a.charAt(i);

            if (65 <= test && test <= 90) {
                output += (char)(test + 32); // 대문자를 소문자로 변환
            } else if (97 <= test && test <= 122) {
                output += (char)(test - 32); // 소문자를 대문자로 변환
            } else {
                output += test;
            }
        }
        System.out.println(output);
    }
}
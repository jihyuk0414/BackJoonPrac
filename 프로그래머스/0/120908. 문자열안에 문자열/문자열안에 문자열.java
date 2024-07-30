class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        int str2Length = str2.length();

        for (int i = 0; i <= str1.length() - str2Length; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                boolean istrue = true;
                for (int j = 1; j < str2Length; j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        istrue = false;
                        break;
                    }
                }
                if (istrue) {
                    answer =1;
                }
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        List<String> dolist = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
            dolist.add(sb.toString());
        }
        
        for (String str : dolist) {
            if (check(str)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char last = stack.peek();
                if ((c == ']' && last == '[') ||
                    (c == ')' && last == '(') ||
                    (c == '}' && last == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
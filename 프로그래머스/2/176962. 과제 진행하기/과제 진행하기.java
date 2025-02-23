import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        int [][] plan_int = new int[plans.length][3];
        
        for (int i = 0; i < plans.length; i++) {
            String[] start_one = plans[i][1].split(":");
            int start_time = Integer.parseInt(start_one[0]) * 60 
                           + Integer.parseInt(start_one[1]);
            int duration = Integer.parseInt(plans[i][2]); 
            plan_int[i] = new int[] {i, start_time, duration};
        }
        
        Arrays.sort(plan_int, (a,b) -> a[1] - b[1]);
        
        Stack<int[]> stopStack = new Stack<>();
        List<String> answerlist = new ArrayList<>();
        
        for (int i = 0; i < plan_int.length - 1; i++) {
            // 현재 작업 추가
            int currentStart = plan_int[i][1];
            int nextStart = plan_int[i + 1][1];
            int timeUntilNext = nextStart - currentStart;
            
            if (timeUntilNext >= plan_int[i][2]) {
                // 현재 작업 완료 가능
                answerlist.add(plans[plan_int[i][0]][0]);
                timeUntilNext -= plan_int[i][2];
                
                // 남은 시간으로 중단된 작업 처리
                while (timeUntilNext > 0 && !stopStack.isEmpty()) {
                    int[] stopped = stopStack.peek();
                    if (timeUntilNext >= stopped[2]) {
                        stopStack.pop();
                        answerlist.add(plans[stopped[0]][0]);
                        timeUntilNext -= stopped[2];
                    } else {
                        stopped[2] -= timeUntilNext;
                        break;
                    }
                }
            } else {
                // 현재 작업 중단
                plan_int[i][2] -= timeUntilNext;
                stopStack.push(plan_int[i]);
            }
        }
        
        // 마지막 작업 추가
        answerlist.add(plans[plan_int[plan_int.length-1][0]][0]);
        
        // 중단된 작업들 역순으로 처리
        while (!stopStack.isEmpty()) {
            answerlist.add(plans[stopStack.pop()[0]][0]);
        }
        
        return answerlist.toArray(new String[0]);
    }
}
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();  
        Queue<Integer> waittruck = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waittruck.add(truck_weights[i]);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        
        while (!waittruck.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();  
            if (currentWeight + waittruck.peek() <= weight) {
                int truck = waittruck.poll();
                bridge.add(truck);
                currentWeight += truck;
            } else {
                bridge.add(0);
            }
        }

        return time + bridge_length;
    }
}
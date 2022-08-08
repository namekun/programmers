package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
//        int solution = solution(2, 10, new int[]{7, 4, 5, 6});
        int solution = solution(100, 100, new int[]{10});
//        int solution = solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        System.out.println(solution);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightSum = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int truck : truck_weights){
            while (true){
                if(queue.isEmpty()){ // 다리가 빈 경우
                    queue.add(truck);
                    weightSum += truck;
                    answer++;
                    break;
                } else if(queue.size() == bridge_length){ // 다리가 꽉 찬 경우, 비워준다.
                    weightSum -= queue.poll();
                } else {
                    if(weightSum + truck <= weight){ // 새로웉 트럭을 올려도 weight를 넘기지 않으면?
                        queue.add(truck);
                        weightSum += truck;
                        answer++;
                        break;
                    } else {
                        // 이미 트럭이 올라가있는데, 큐가 안찼으면.. 0으로 넣어서 보내준다.
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }

        // 마지막 트럭은 다리길이만큼 보내준다.
        answer+= bridge_length;

        return answer;
    }
}

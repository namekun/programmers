package lv2;

import java.util.*;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        롤케이크자르기 test = new 롤케이크자르기();
        test.solution(new int[]{1, 2, 3, 1, 4});
    }

    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> olderBrothrerMap = new HashMap<>();
        Arrays.stream(topping).forEach(i -> olderBrothrerMap.put(i, olderBrothrerMap.getOrDefault(i, 0) + 1));
        Set<Integer> youngerBrother = new HashSet<>();
        for (int i : topping) {
            youngerBrother.add(i);

            if (olderBrothrerMap.containsKey(i)) {
                if (olderBrothrerMap.get(i) != 1) {
                    olderBrothrerMap.put(i, olderBrothrerMap.get(i) - 1);
                } else {
                    olderBrothrerMap.remove(i);
                }
            }

            if (youngerBrother.size() == olderBrothrerMap.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }

    public int solution2(int [] topping){
        int answer = 0;



        return answer;
    }
}

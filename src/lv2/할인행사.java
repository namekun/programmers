package lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        할인행사 test = new 할인행사();
        int solution = test.solution(want, number, discount);
        System.out.println(solution);
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // sliding window
        int needNum = Arrays.stream(number).sum();
        Deque<String> deque = new LinkedList<>(Arrays.asList(discount).subList(0, needNum));

        for (int i = needNum; i <= discount.length; i++) {
            boolean pass = IntStream.range(0, want.length)
                    .noneMatch(j -> Collections.frequency(deque, want[j]) != number[j]);

            if (pass) {
                answer += 1;
            }

            // 조건문 없으면 index 초과.
            if (i < discount.length) {
                deque.pollFirst();
                deque.addLast(discount[i]);
            }
        }

        return answer;
    }
}

package lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        연속부분수열합의개수 test = new 연속부분수열합의개수();
        int solution = test.solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(solution);
    }

    public int solution(int[] elements) {
        Set<Integer> answerSet = new HashSet<>();

        int[] doubleElements = new int[elements.length * 2];
        IntStream.range(0, elements.length).forEach(i -> {
            doubleElements[i] = elements[i];
            doubleElements[elements.length + i] = elements[i];
        });

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                answerSet.add(Arrays.stream(doubleElements, j, j + i).sum());
            }
        }

        return answerSet.size();
    }
}

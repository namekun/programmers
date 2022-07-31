package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int[] solution = solution(8, 1);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0 && (yellow / i + 2) * (i + 2) == sum) {
                answer[0] = Math.max(yellow / i + 2, i + 2);
                answer[1] = Math.min(yellow / i + 2, i + 2);
                return answer;
            }
        }

        return answer;
    }
}


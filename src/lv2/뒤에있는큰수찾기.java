package lv2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        뒤에있는큰수찾기 test = new 뒤에있는큰수찾기();
        int[] solution = test.solution(new int[]{9, 1, 5, 3, 6, 2});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            while (!stack.isEmpty()) {
                if (stack.peek()[1] < number) {
                    answer[stack.pop()[0]] = number;
                } else break;
            }
            stack.push(new int[]{i, number});
        }

        return answer;
    }
}

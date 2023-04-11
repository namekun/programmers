package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {
    public static void main(String[] args) {
        숫자변환하기 test = new 숫자변환하기();
        int solution = test.solution(2, 5, 4);
        System.out.println(solution);
    }

    public int solution(int x, int y, int n) {

        if (x == y) return 0;
        int[] memory = new int[y+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            int[] temp = new int[3];
            temp[0] = num + n;
            temp[1] = num * 2;
            temp[2] = num * 3;

            for (int operationResult : temp) {
                if (operationResult > y) {
                    continue;
                }

                if (memory[operationResult] == 0
                        || memory[operationResult] > memory[num] + 1) {
                    memory[operationResult] = memory[num] + 1;
                    queue.add(operationResult);
                }
            }
        }

        return memory[y] != 0 ? memory[y] : -1;
    }
}

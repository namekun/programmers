package lv1;

import java.util.Stack;

public class 크레인인형뽑기 {
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i : moves) {
			for (int[] ints : board) {
				if (ints[i - 1] != 0) {
					if (!stack.isEmpty() && stack.peek() == ints[i - 1]) {
						stack.pop();
						answer++;
					} else {
						stack.add(ints[i - 1]);
					}
					ints[i - 1] = 0;
					break;
				}
			}
		}
		return answer * 2;
	}
}

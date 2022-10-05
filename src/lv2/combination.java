package lv2;

import java.util.Stack;

public class combination {
	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "D"};
		Stack<String> stack = new Stack<>();
		stackCombination(arr, stack, 0, 2);
	}

	public static void stackCombination(String[] arr, Stack<String> stack, int start, int r) {
		if (stack.size() == r) {
			System.out.println(stack);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			stack.push(arr[i]);
			stackCombination(arr, stack, i + 1, r);
			stack.pop();
		}
	}
}

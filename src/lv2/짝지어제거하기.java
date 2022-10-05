package lv2;

import java.util.Stack;

public class 짝지어제거하기 {
	public static void main(String[] args) {
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		stack.push(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			if (stack.isEmpty()) {
				stack.push(chars[i]);
				continue;
			}

			if (!stack.peek().equals(chars[i])) {
				stack.push(chars[i]);
			} else {
				stack.pop();
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}
}

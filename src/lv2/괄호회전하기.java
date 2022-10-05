package lv2;

import java.util.LinkedList;
import java.util.Stack;

public class 괄호회전하기 {
	public static void main(String[] args) {
		solution("}]()[{");
	}

	public static int solution(String s) {
		if (s.length() % 2 == 1) return 0;

		char[] chars = s.toCharArray();
		LinkedList<Character> queue = new LinkedList<>();
		for (char c : chars) queue.add(c);

		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isRight(queue)) cnt++;
			queue.addLast(queue.poll());
		}

		return cnt;
	}

	public static boolean isRight(LinkedList<Character> q) {
		Stack<Character> stack = new Stack<>();

		if (q.getFirst() == ')' || q.getFirst() == '}' || q.getFirst() == ']') {
			return false;
		}

		for (char c : q) {
			if (c == '(' || c == '{' || c == '[') stack.push(c);
			else if (stack.size() > 0) {
				if (c == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (c == ']' && stack.peek() == '[') {
					stack.pop();
				} else if (c == '}' && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}
}

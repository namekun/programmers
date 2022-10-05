package lv2;

import java.util.Stack;

public class 올바른괄호 {
	public static void main(String[] args) {
//        System.out.println(solution("(())()"));
		System.out.println(solution(")()("));
	}

	public static boolean solution(String s) {

		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();

		if (charArray[0] == ')') return false;

		for (char c : charArray) {
			if (c == '(') stack.push(c);
			if (stack.size() > 0 && c == ')') stack.pop();
		}

		return stack.size() == 0;
	}
}

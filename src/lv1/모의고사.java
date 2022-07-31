package lv1;

import java.util.Arrays;
import java.util.ArrayList;

class 모의고사{
	// 1번 : 1, 2, 3, 4, 5 의 반복
// 2번 : 2, 1, 2, 3, 2, 4, 2, 5 의 반복
// 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 의 반복
	public static void main(String[] args) {
		int[] answer = {1, 3, 2, 4, 2};
		System.out.println(Arrays.toString(solution(answer)));
	}

	public static Integer[] solution(int[] answers) {
		int[] personA = {1, 2, 3, 4, 5};
		int[] personB = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int a = checkScore(answers, personA);
		int b = checkScore(answers, personB);
		int c = checkScore(answers, personC);

		return compare(a, b, c);
	}

	static int checkScore(int[] answers, int[] compareArr) {
		int result = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == compareArr[i % compareArr.length]) result++;
		}

		return result;
	}

	static Integer[] compare(int a, int b, int c) {
		ArrayList<Integer> list = new ArrayList();

		if (a > b && a > c) {
			list.add(1);
		} else if (b > a && b > c) {
			list.add(2);
		} else if (c > a && c > b) {
			list.add(3);
		} else if (a == b && a > c) {
			list.add(1);
			list.add(2);
		} else if (b == c && b > a) {
			list.add(2);
			list.add(3);
		} else if (a == c && a > b) {
			list.add(1);
			list.add(3);
		} else if (a == b && b == c) {
			list.add(1);
			list.add(2);
			list.add(3);
		}

//		int max = Math.max(a, Math.max(b, c));
//		if (a == max && b != max && c != max) list.add(a);
//		if (b == max && a != max &&)

		return list.stream().map(x -> x.intValue()).toArray(Integer[]::new);
	}
}

package toss;

import java.util.Arrays;

public class 적당히어려운문제 {
	public static void main(String[] args) {
		solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
	}

	public static int solution(int[] levels) {
		int answer;
		Arrays.sort(levels);
		int i = (int) Math.floor(levels.length * 0.25);
		if (i == 0) return -1;
		// 뒤에서 i번째 숫자 꺼내기.
		answer = levels[levels.length - i];

		return answer;
	}
}

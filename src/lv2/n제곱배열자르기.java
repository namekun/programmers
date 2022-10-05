package lv2;

public class n제곱배열자르기 {
	public static void main(String[] args) {
		solution(3, 2, 5);
	}

	public static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left) + 1];

		for (long i = left; i < right + 1; i++) {
			answer[(int) (i - left)] = (int) Math.max(i / n, i % n) + 1;
		}

		return answer;
	}
}

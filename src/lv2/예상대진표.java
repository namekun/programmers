package lv2;

public class 예상대진표 {
	public static void main(String[] args) {
		int solution = solution(8, 4, 5);
		System.out.println(solution);
	}

	public static int solution(int n, int a, int b) {
		int answer = 1;

		while (a % 2 == 1 ? b != a + 1 : b != a - 1) {
			a = check(a);
			b = check(b);
			answer += 1;
		}

		return answer;
	}

	public static int check(int a) {
		if (a % 2 == 1) {
			return (a + 1) / 2;
		} else {
			return a / 2;
		}
	}
}

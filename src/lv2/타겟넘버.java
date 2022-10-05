package lv2;

public class 타겟넘버 {
	static int answer = 0;

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		solution(numbers, 3);
	}

	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return answer;
	}

	/**
	 * 깊이 우선 탐색
	 *
	 * @param numbers : 주어지는 배열
	 * @param target  : 원하는 사칙연산 결과의 값
	 * @param sum     : 현재까지의 사칙연산의 결과 ( 더하기가 되었던 빼기가 되었건 간에..)
	 * @param depth   : 현재 탐색중인 깊이
	 */
	public static void dfs(int[] numbers, int target, int sum, int depth) {
		// 만약에 깊이가 numbers 배열의 길이와 같다면, 해당 탐색이 끝에 도달했다는 소리이기에 결과를 비교하면 된다.
		if (depth == numbers.length) {
			if (target == sum) {
				answer++;
			}
		} else {
			// 결과값에 더하기를 해주는 것과 빼기를 해주는 모든 경우를 체크해본다.
			dfs(numbers, target, sum + numbers[depth], depth + 1);
			dfs(numbers, target, sum - numbers[depth], depth + 1);
		}
	}

}

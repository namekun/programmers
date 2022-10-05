package lv2;

import java.util.HashSet;

public class 소수찾기 {

	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		int solution = solution("002");
		System.out.println(solution);
	}

	public static int solution(String numbers) {
		int answer = 0;
		char[] chars = numbers.toCharArray();
		for (int i = chars.length; i > 0; i--) {
			permutation(chars, new char[chars.length], new boolean[chars.length], 0, i);
		}

		for (int num : set) {
			if (isPrimeNum(num)) {
				answer += 1;
			}
		}

		return answer;
	}

	// 소수 판단
	public static boolean isPrimeNum(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

	// 순열
	public static void permutation(char[] arr, char[] out, boolean[] visited, int depth, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for (char num : out) {
				sb.append(num);
			}

			if (sb.toString().trim().length() > 0 && Integer.parseInt(sb.toString().trim()) > 1) {
				set.add(Integer.parseInt(sb.toString().trim()));
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = arr[i];
				permutation(arr, out, visited, depth + 1, r);
				visited[i] = false;
			}
		}
	}

}

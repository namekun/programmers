package lv2;

public class 큰수만들기 {
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		String solution = solution("4177252841", 4);
		System.out.println(solution);
	}

	public static String solution(String number, int k) {
//        int n = number.length() - k;
//        char[] chars = number.toCharArray();
//        Combination(chars, new boolean[chars.length], 0, n);

		return greedy(number, k);
	}

	public static void Combination(char[] arr, boolean[] visited, int depth, int r) {
		if (r == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) sb.append(arr[i]);
			}

			max = Math.max(max, Integer.parseInt(sb.toString().trim()));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				Combination(arr, visited, depth + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	public static String greedy(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int n = number.length() - k; // 뽑아야하는 숫자의 수
		int start = 0;

		while (start < number.length() && answer.length() != n) {
			int leftNum = k + answer.length() + 1;
			int max = 0;
			for (int i = start; i < leftNum; i++) {
				int charAtNum = number.charAt(i) - '0';
				if (max < charAtNum) {
					max = charAtNum;
					start = i + 1;
				}
			}
			answer.append(max);
		}
		return answer.toString();
	}
}

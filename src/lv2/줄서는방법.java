package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄서는방법 {
	static long cnt = 0;
	static int[] result;

	public static void main(String[] args) {
		int[] solution = solution(3, 5);
		System.out.println(Arrays.toString(solution));
	}

	public static int[] solution(int n, long k) {
//        int[] arr = new int[n];
//        for (int i = 1; i <= n; i++) {
//            arr[i - 1] = i;
//        }
//
//        permutation(arr, new int[n], new boolean[n], 0, n, k);

		return regularity(n, k);
	}

	static int[] regularity(int n, long k) {
		int[] answer = new int[n];

		ArrayList<Integer> people = new ArrayList<>();
		long factorial = 1;
		int index = 0;

		for (int i = 1; i <= n; i++) {
			factorial *= i;
			people.add(i);
		}

		k--;
		while (n > 0) {
			factorial /= n;
			int value = (int) (k / factorial);
			answer[index++] = people.get(value);
			people.remove(value);

			k %= factorial;
			n--;
		}

		return answer;
	}

	// 효율성에서 나가리
//    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int r, long k) {
//        if (depth == r) {
//            cnt++;
//            if (cnt == k) {
//                result = output.clone();
//                return;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                output[depth] = arr[i];
//                permutation(arr, output, visited, depth + 1, r, k);
//                visited[i] = false;
//            }
//        }
//    }
}

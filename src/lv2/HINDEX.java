package lv2;

import java.util.Arrays;

public class HINDEX {
	public static void main(String[] args) {
		int solution = solution(new int[]{3, 0, 5, 1, 5});
		System.out.println(solution);
	}

	public static int solution(int[] citations) {
		Arrays.sort(citations);
		int answer = 0;
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;

			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
}

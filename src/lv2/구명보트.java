package lv2;

import java.util.Arrays;

public class 구명보트 {
	public static void main(String[] args) {
		int solution = solution(new int[]{70, 80, 50}, 100);
		System.out.println(solution);
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);

		int right = people.length - 1;
		int left = 0;

		while (right >= left) {
			if (people[left] + people[right] <= limit) {
				left++;
			}
			answer++;
			right--;
		}

		return answer;
	}
}

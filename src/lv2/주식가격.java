package lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		solution(prices);
	}

	public static int[] solution(int[] prices) {
		ArrayList<Integer> answer = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int i : prices) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			int standard = queue.poll();
			int cnt = 0;
			for (int i : queue) {
				if (standard > i) {
					cnt++;
					break;
				} else {
					cnt++;
				}
			}
			answer.add(cnt);
		}


		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}

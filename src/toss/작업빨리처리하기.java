package toss;

import java.util.HashMap;

public class 작업빨리처리하기 {
	public static void main(String[] args) {
		solution(new int[]{4, 1, 1, 2, 3, 3, 2, 2});
	}

	public static int solution(int[] tasks) {
		int answer = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : tasks) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		for (int i : map.keySet()) {
			int taskCnt = map.get(i);
			if (taskCnt % 2 != 0 && taskCnt % 3 != 0) return -1;

			if (taskCnt % 3 == 0) {
				answer += taskCnt / 3;
			} else {
				answer += taskCnt / 2;
			}
		}

		return answer;
	}

}

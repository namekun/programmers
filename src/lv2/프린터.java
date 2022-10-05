package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		int[] priorities = {2, 4, 8, 2, 9, 3, 3};
		int location = 2;

		solution2(priorities, location);
	}

	public static int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> idxQ = new LinkedList<>();
		ArrayList<Integer> finalIdxList = new ArrayList<>();

		for (int i = 0; i < priorities.length; i++) {
			queue.add(priorities[i]);
			idxQ.add(i);
		}

		while (!queue.isEmpty()) {
			int t = queue.poll();
			boolean isBiggest = true;
			for (int i : queue) {
				if (t < i) {
					queue.add(t);
					idxQ.add(idxQ.poll());
					isBiggest = false;
					break;
				}
			}

			if (isBiggest) {
				finalIdxList.add(idxQ.poll());
			}
		}

		return finalIdxList.indexOf(location) + 1;
	}

	public static int solution2(int[] priorities, int location) {
		int answer = 0;
		int l = location;

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i : priorities) {
			que.add(i);
		}

		Arrays.sort(priorities);
		int size = priorities.length - 1;

		while (!que.isEmpty()) {
			Integer i = que.poll();
			if (i == priorities[size - answer]) {
				answer++;
				l--;
				if (l < 0) break;
			} else {
				que.add(i);
				l--;
				if (l < 0) l = que.size() - 1;
			}
		}

		return answer;
	}
}

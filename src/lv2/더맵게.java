package lv2;

import java.util.PriorityQueue;

public class 더맵게 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville, k));
	}

	public static int solution(int[] scoville, int k) {
		int cnt = 0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int i : scoville) {
			priorityQueue.offer(i);
		}
		return hot(priorityQueue, cnt, k);
	}

	public static int hot(PriorityQueue<Integer> queue, int cnt, int k) {
		if (queue.size() == 1) return -1;

		while (queue.size() != 1) {
			cnt++;
			int first = queue.poll();
			int second = queue.poll();
			queue.add(first + (second * 2));
			if (queue.peek() > k) break;
		}

		if (queue.size() == 1 && queue.peek() < k) return -1;

		return cnt;
	}
}

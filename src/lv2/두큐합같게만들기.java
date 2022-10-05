package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
	public static void main(String[] args) {
		int[] a = {3, 2, 7, 2};
		int[] b = {4, 6, 5, 1};
		int[] c = {1, 2, 1, 2};
		int[] d = {1, 10, 1, 2};
		int[] e = {1, 1};
		int[] f = {1, 5};
//        solution(a, b);
		int solution = solution(e, f);
		System.out.println(solution);
	}

	public static int solution(int[] queue1, int[] queue2) {
		LinkedList<Integer> q1 = new LinkedList<>();
		LinkedList<Integer> q2 = new LinkedList<>();

		// initialize
		for (int i = 0; i < queue1.length; i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		int cnt = 0;
		long sum1 = getSum(q1);
		long sum2 = getSum(q2);
		// 큐 한쪽이 작으면 큰 쪽에서 뽑아서 넣기.
		while (cnt < (queue1.length * 3)) {
			if (sum1 > sum2) {
				Integer poll = q1.poll();
				q2.add(poll);
				sum1 -= poll;
				sum2 += poll;
			} else if (sum2 > sum1) {
				Integer poll = q2.poll();
				q1.add(poll);
				sum2 -= poll;
				sum1 += poll;
			} else {
				return cnt;
			}
			cnt++;
		}

		return -1;
	}

	public static long getSum(Queue<Integer> queue) {
		long sum = 0;

		for (int node : queue) {
			sum += node;
		}

		return sum;
	}
}

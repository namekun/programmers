package lv2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class 택배상자 {
	public static void main(String[] args) {
		int[] order = new int[]{4, 3, 1, 2, 5};
		int[] order2 = new int[]{5,4,3,2,1};
		int solution = solution(order);
		System.out.println(solution);
	}

	public static int solution(int[] order) {

		Deque<Integer> container = new LinkedList<>();
		IntStream.rangeClosed(1, order.length).forEach(container::push);
		Deque<Integer> tmpContainer = new LinkedList<>();

//		int answer = 0;
//		for (int i : order) {
//			boolean isExist = container.contains(i);
//
//			if (isExist) {
//				while (!container.isEmpty()) {
//					if (i == container.getLast()) {
//						container.removeLast();
//						answer++;
//						break;
//					} else {
//						tmpContainer.push(container.pollLast());
//					}
//				}
//			} else {
//				if (!tmpContainer.isEmpty()) {
//					if (tmpContainer.peek() != i){
//						return answer;
//					} else {
//						tmpContainer.pop();
//						answer++;
//					}
//				}
//			}
//		}

		int cnt = 0;
		while (!container.isEmpty()){
			if(order[cnt] != container.getLast()){
				if(!tmpContainer.isEmpty() && order[cnt] == tmpContainer.peek()){
					cnt+=1;
					tmpContainer.pop();
				} else {
					tmpContainer.push(container.pollLast());
				}
			} else {
				cnt+=1;
				container.removeLast();
			}
		}

		while (!tmpContainer.isEmpty()){
			if(order[cnt] == tmpContainer.peek()){
				cnt+=1;
				tmpContainer.pop();
			} else break;
		}

		return cnt;
	}
}

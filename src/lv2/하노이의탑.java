package lv2;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
	private static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) {
		solution(2);
	}

	public static int[][] solution(int n) {
		hanoi(n, 1, 2, 3);
		return list.toArray(new int[list.size()][]);
	}

	public static void hanoi(int n, int from, int by, int to) {
		if ( n != 0 ) {
			hanoi(n - 1, from, to, by);
			list.add(new int[]{from, to});
			hanoi(n - 1, by, from, to);
		}
	}
}

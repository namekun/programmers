package lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class 로또의최고순위와최저순위 {
	public static void main(String[] args) {

	}

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int zeroCount = 0;
		int matchCount = 0;

		List<Integer> list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

		for (int num : lottos) {
			if (list.contains(num)) {
				matchCount++;
			}

			if (num == 0) {
				zeroCount++;
			}
		}

		answer[0] = getResult(matchCount, zeroCount);
		answer[1] = getResult(matchCount, 0);

		return answer;
	}

	public int getResult(int matchCnt, int zeroCnt) {
		if (zeroCnt + matchCnt < 2) {
			return 6;
		} else {
			return 7 - (matchCnt + zeroCnt);
		}
	}
}

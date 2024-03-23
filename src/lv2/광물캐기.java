package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 광물캐기 {
	public static void main(String[] args) {
		광물캐기 test = new 광물캐기();

//		[1, 1, 0], ["iron", "iron", "iron", "iron", "iron", "diamond", "diamond", "diamond", "diamond", "diamond"]
//		int[] picks = {1,1,0} ,String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"}
		int solution = test.solution(new int[]{1,1,0}, new String[] {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"});
		System.out.println(solution);
	}

	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		int totalPick = Arrays.stream(picks).sum() * 5;

		if (minerals.length > totalPick) minerals = Arrays.copyOfRange(minerals, 0, totalPick);

		List<int[]> costs = new ArrayList<>();
		int[] cost = new int[3];
		for (int i = 0; i < minerals.length; i++) {
			String mineral = minerals[i];

			if (mineral.equals("diamond")) {
				cost[0] += 1;
				cost[1] += 5;
				cost[2] += 25;
			}

			if (mineral.equals("iron")) {
				cost[0] += 1;
				cost[1] += 1;
				cost[2] += 5;
			}

			if (mineral.equals("stone")) {
				cost[0] += 1;
				cost[1] += 1;
				cost[2] += 1;
			}

			if ((i + 1) % 5 == 0) {
				costs.add(cost);
				cost = new int[3];
			} else if (i == minerals.length - 1) {
				costs.add(cost);
			}
		}


		Collections.sort(costs, (o1, o2) -> {
			if (o1[2] > o2[2]) {
				return -1;
			} else if (o1[2] < o2[2]) {
				return 1;
			} else {
				if (o1[1] > o2[1]) return -1;
				else if (o1[1] < o1[1]) return 1;
				else {
					if (o1[0] > o2[0]) return -1;
					else if (o1[0] < o1[0]) return 1;
					else return 0;
				}
			}
		});


		for (int i = 0; i < costs.size(); i++) {
			if (picks[0] > 0) {
				answer += costs.get(i)[0];
				picks[0] -= 1;
			} else if (picks[1] > 0) {
				answer += costs.get(i)[1];
				picks[1] -= 1;
			} else if (picks[2] > 0) {
				answer += costs.get(i)[2];
				picks[2] -= 1;
			} else {
				break;
			}
		}

		return answer;
	}
}


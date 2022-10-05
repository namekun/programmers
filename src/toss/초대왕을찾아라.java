package toss;

import java.util.*;

public class 초대왕을찾아라 {
	public static void main(String[] args) {
		long[][] arr = new long[][]{{1, 2}, {1, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}};
		long[][] arr2 = new long[][]{{3, 4}, {1, 2}};
		long[][] arr3 = new long[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}, {4, 6}, {4, 7}};

		long[] solution = solution(arr2);
		System.out.println(Arrays.toString(solution));

	}

	public static long[] solution(long[][] invitationPairs) {
		Map<Long, ArrayList<Long>> map = new HashMap<>();
		ArrayList<Long> invitList = new ArrayList<>();

		for (long[] arr : invitationPairs) {
			if (map.containsKey(arr[0])) {
				ArrayList<Long> longs = map.get(arr[0]);
				longs.add(arr[1]);
			} else {
				ArrayList<Long> list = new ArrayList<>();
				list.add(arr[1]);
				map.put(arr[0], list);
			}

			invitList.add(arr[0]);
		}

		HashMap<Long, Integer> scoreBoard = new HashMap<>();

		for (Long key : map.keySet()) {
			int score = 0;
			score += map.get(key).size() * 10;

			for (Long value : map.get(key)) {
				// 내가 초대한 사람이 초대한 사람이 있다면
				if (map.containsKey(value)) {
					score += map.get(value).size() * 3;

					// 내가 초대한 사람이 초대한 사람이 초대한 사람
					for (Long valByVal : map.get(value)) {
						if (map.containsKey(valByVal)) {
							score += map.get(valByVal).size();
						}
					}
				}
			}

			scoreBoard.put(key, score);
		}

		// sort by score
		List<Map.Entry<Long, Integer>> list = new ArrayList<>(scoreBoard.entrySet());
		list.sort((o1, o2) -> {
			if (o2.getValue() - o1.getValue() == 0) {
				// 점수가 같으면 마지막 초대가 더 먼저인 키가 우선
				return invitList.lastIndexOf(o1.getKey()) - invitList.lastIndexOf(o2.getKey());
			}

			return o2.getValue() - o1.getValue();

		});

		int x = Math.min(scoreBoard.size(), 3);
		long[] answer = new long[x];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).getKey();
		}

		return answer;
	}
}

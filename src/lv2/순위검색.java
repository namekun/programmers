package lv2;

import java.util.*;

public class 순위검색 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution1(String[] info, String[] query) {
		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {
			int cnt = 0;
			String[] splited = query[i].split(" and ");
			String standardScore = splited[splited.length - 1].split(" ")[1];
			splited[splited.length - 1] = splited[splited.length - 1].split(" ")[0];
			for (String information : info) {
				String[] split = information.split(" ");
				if (Integer.parseInt(split[split.length - 1]) >= Integer.parseInt(standardScore)) {
					for (int j = 0; j < split.length - 1; j++) {
						if (!split[j].equals(splited[j]) && !splited[j].equals("-")) break;
						else if (j == 3) cnt++;
					}
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		Map<String, ArrayList<Integer>> map = new HashMap<>();
		for (String q : info) {
			String[] s = q.split(" ");
			for (String i : new String[]{s[0], "-"}) {
				for (String j : new String[]{s[1], "-"}) {
					for (String k : new String[]{s[2], "-"}) {
						for (String l : new String[]{s[3], "-"}) {
							if (map.containsKey(i + j + k + l)) {
								ArrayList<Integer> arrayList = map.get(i + j + k + l);
								arrayList.add(Integer.parseInt(s[s.length - 1]));
								map.put(i + j + k + l, arrayList);
							} else {
								ArrayList<Integer> arrayList = new ArrayList<>();
								arrayList.add(Integer.parseInt(s[s.length - 1]));
								map.put(i + j + k + l, arrayList);
							}
						}
					}
				}
			}
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		for (int i = 0; i < query.length; i++) {
			String[] splited = query[i].split(" and ");
			String key = splited[0] + splited[1] + splited[2] + splited[3].split(" ")[0];
			ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
			answer[i] = list.size() - lowerBound(list, Integer.parseInt(splited[3].split(" ")[1]));
		}

		return answer;
	}

	public static int lowerBound(ArrayList<Integer> list, int value) {
		int low = 0;
		int high = list.size();
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (value <= list.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}
}

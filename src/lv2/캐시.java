package lv2;

import java.util.LinkedList;

public class 캐시 {
	public static void main(String[] args) {

	}

	public int solution(int cachesize, String[] cities) {
		int answer = 0;

		if (cachesize == 0) return cities.length * 5;

		LinkedList<String> cache = new LinkedList<>();

		for (String city : cities) {

			city = city.toLowerCase();

			if (cache.contains(city)) {
				cache.remove(city);
				cache.addFirst(city);
				answer += 1;
			} else {

				if (cache.size() == cachesize) {
					cache.pollLast();
				}

				cache.addFirst(city);
				answer += 5;
			}
		}

		return answer;
	}
}

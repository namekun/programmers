package lv2;

public class 최대값과최솟값 {
	public static void main(String[] args) {
		solution("1 2 3 4");
		solution("-1 -2 -3 -4");
		solution("-1 -1");
	}

	public static String solution(String s) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		String[] splited = s.split(" ");

		for (String split : splited) {
			max = Math.max(max, Integer.parseInt(split));
			min = Math.min(min, Integer.parseInt(split));
		}

		return min + " " + max;
	}
}

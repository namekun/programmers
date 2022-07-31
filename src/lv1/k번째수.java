package lv1;

import java.util.Arrays;

class k번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int i = 0;
		for(int[] arr : commands){
			int[] copyOfRange = Arrays.copyOfRange(array, arr[0] -1  , arr[1]);
			Arrays.sort(copyOfRange);
			answer[i] = copyOfRange[arr[2] - 1];
			i++;
		}

		return answer;
	}
}
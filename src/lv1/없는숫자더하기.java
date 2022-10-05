package lv1;

//https://programmers.co.kr/learn/courses/30/lessons/86051
public class 없는숫자더하기 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
		int answer = solution(numbers);
		System.out.println(answer);
	}


	public static int solution(int[] numbers) {
		int answer = 45;

		for (int number : numbers) {
			answer = answer - number;
		}

		return answer;
	}
}

package lv1;

public class 키패드누르기 {
	public static void main(String[] args) {
		int[] arr = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		solution(arr, "left");

	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		int left = 10;
		int right = 12;

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				answer.append("L");
				left = number;
			} else if (number == 3 || number == 6 || number == 9) {
				answer.append("R");
				right = number;
			} else {
				//  2, 5, 8, 0
				// 해당 번호와 현재 letf와 right 간의 거리를 구한다.
				// 키패드의 숫자와 좌표간의 규칙성을 구한다.
				if (number == 0) number = 11;
				int leftInstance = getInstance(number, left);
				int rightInstance = getInstance(number, right);

				System.out.println(leftInstance + ", " + rightInstance);

				if (leftInstance < rightInstance) {
					answer.append("L");
					left = number;
				} else if (leftInstance == rightInstance) {
					if (hand.equals("left")) {
						answer.append("L");
						left = number;
					} else {
						answer.append("R");
						right = number;
					}
				} else {
					answer.append("R");
					right = number;
				}
			}
			System.out.println(answer);
		}

		return answer.toString();
	}

	public static int getInstance(int number, int lastNum) {
		int x = Math.abs(((lastNum - 1) / 3) - ((number - 1) / 3));
		int y = Math.abs(((lastNum - 1) % 3) - ((number - 1) % 3));
		return x + y;
	}


}


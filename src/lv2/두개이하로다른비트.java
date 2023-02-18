package lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 두개이하로다른비트 {
	public static void main(String[] args) {

		두개이하로다른비트 test = new 두개이하로다른비트();
//		System.out.println(Arrays.toString(test.solution(new long[]{2, 7})));

		System.out.println(Long.MAX_VALUE > Math.pow(10, 15));
	}

	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			answer[i] = checkMinBitNum(numbers[i]);
		}

		return answer;
	}

	public long checkMinBitNum(long a) {
		boolean isEven = a % 2 == 0;
		String binaryString = Long.toBinaryString(a);

		char[] charArray = binaryString.toCharArray();
		if (isEven) {
			charArray[charArray.length - 1] = '1';
			return Long.parseLong(String.valueOf(charArray), 2);
		}

		// 홀수인 경우 모든 수가 1인 경우가 있다.
		// 이런 경우는 맨 앞에 0을 더해서 확인한다.
		if(!binaryString.chars().mapToObj(c -> (char)c).collect(Collectors.toList()).contains('0')){
			binaryString = "0" + binaryString;
		}

		charArray = binaryString.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			char c = charArray[i];
			if (c == '0') {
				charArray[i] = '1';
				if(i != charArray.length -1){
					charArray[i + 1] = '0';
				}
				break;
			}
		}

		return Long.parseLong(String.valueOf(charArray), 2);
	}
}

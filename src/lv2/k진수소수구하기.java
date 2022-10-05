package lv2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class k진수소수구하기 {
	public static void main(String[] args) {
		solution(110011, 10);
	}

	public static int solution(int n, int k){
		Deque<Integer> deque = new LinkedList<>();
		// k 진수로 변경
		while (n != 0){
			deque.push(n % k);
			n = n / k;
		}

		String chanegedNumber = deque.stream().map(Objects::toString).collect(Collectors.joining());

		// 변경된 수에서 소수 찾기
		String[] split = chanegedNumber.split("0");
		int result = 0;
		for(String s : split){
			if(s.length() > 0 && !s.equals("1") && isPrime(Long.parseLong(s))){
				result+=1;
			}
		}

		// 추출된 숫자가 소수인가?
		return result;
	}

	private static boolean isPrime(long n){
		for(int i = 2; i <= (long) Math.sqrt(n); i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
}

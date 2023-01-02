package lv2;

public class N개의최소공배수 {
	public static void main(String[] args) {
		N개의최소공배수 test = new N개의최소공배수();

		int[] a = {3, 4, 9, 16};
		int solution = test.solution(a);
		System.out.println(solution);
	}

	public int solution(int[] arr) {
		int lcm = arr[0];

		for (int i = 1; i < arr.length; i++) {
			lcm = lcm / getGcd(lcm, arr[i]) * arr[i];
		}

		return lcm;
	}

	private int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}


	// 18 , 14 두 수를 넣으면
	// 18 % 14 = 4
	// 14 % 4 = 2
	// 4 % 2 = 0
	// if( b == 0 ) return b
}

package lv2;

public class 멀쩡한사각형 {
	public static void main(String[] args) {
		solution(5, 4);
	}

	public static long solution(int w, int h) {
		return (long) w * h - (w + h - getGcd(w, h));
	}

	public static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return getGcd(a, a % b);
		}
	}
}

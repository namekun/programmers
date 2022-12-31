package lv2;

public class 숫자의표현 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;

        숫자의표현 expression = new 숫자의표현();

        // n이 연속된 숫자의 합인 경우를 구하여라.
        for (int i = 1; i <= n; i++) {
            answer = expression.recursive(i, 0, n, answer);
        }

        return answer;
    }

    public int recursive(int i, int sum, int target, int answer) {
        if (i + sum > target) {
            return answer;
        }

        if (i + sum == target) {
            return answer + 1;
        }

        if (i + sum < target) {
            return recursive(i + 1, sum + i, target, answer);
        }

        return answer;
    }
}

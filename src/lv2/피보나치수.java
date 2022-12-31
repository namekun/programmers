package lv2;

public class 피보나치수 {
    public static void main(String[] args) {
        System.out.println(solution(1500));
    }

    public static int solution(int n) {
        return fibonacci(n);
    }

    // dynamic programming
    public static int fibonacci(int n) {
        int[] memory = new int[n + 1];
        memory[0] = 0;
        memory[1] = 1;

        for (int i = 2; i <= n; i++) {
            memory[i] = (memory[i - 1] + memory[i - 2]) % 1234567; //
        }

        return memory[n];
    }

    // recursive - time over.
//    public static int fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
}

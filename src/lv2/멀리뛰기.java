package lv2;

public class 멀리뛰기 {
    public static void main(String[] args) {
        멀리뛰기 test = new 멀리뛰기();
        long solution = test.solution(4);
        System.out.println(solution);
    }

    //dfs
    public long solution(int n) {
        long answer = 0;

        for (int i = 1; i <= 2; i++) {
            answer = dfsWithRecursive(n, i, answer);
        }

        return answer;
    }

    public long dfsWithRecursive(int n, int jump, long answer) {
        if (n - jump < 0) {
            return answer;
        }

        if (n - jump == 0) {
            return (answer + 1) % 1234567;
        }

        for (int i = 1; i <= 2; i++) {
            answer = dfsWithRecursive(n - jump, i, answer);
        }

        return answer;
    }

    public long dynamicProgramming(int n) {
        long[] memory = new long[2001];

        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;

        // f[n] = f[n-1] + f[n-2]?
        for (int i = 3; i <= n; i++) {
            memory[i] = (memory[i - 1] + memory[i - 2]) % 1234567;
        }

        return memory[n];
    }
}

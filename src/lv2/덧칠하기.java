package lv2;

public class 덧칠하기 {
    public static void main(String[] args) {
        덧칠하기 test = new 덧칠하기();
        int solution = test.solution(8, 4, new int[]{2, 3, 6});
        int solution1 = test.solution(4, 1, new int[]{1, 2, 3, 4});
        int solution2 = test.solution(5, 4, new int[]{1, 3});

        System.out.println(solution);
        System.out.println(solution1);
        System.out.println(solution2);
    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;

        for (int emptyWall : section) {
            if (emptyWall < max) {
                continue;
            }

            answer += 1;
            max = emptyWall + m;
        }

        return answer;
    }
}

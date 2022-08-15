package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망나누기 {
    static int[][] arr;

    public static void main(String[] args) {
        int solution = solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}});
        System.out.println(solution);
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 인접 행렬을 만들고,
        arr = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        for (int[] wire : wires) {
            // 선을 차례대로 끊으면서
            arr[wire[0]][wire[1]] = 0;
            arr[wire[1]][wire[0]] = 0;

            // bfs로 탐색한다.
            answer = Math.min(answer, bfs(wire[0], n));

            // 탐색이 끝나면 선은 복구한다.
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        return answer;
    }

    // 왼쪽의 숫자를 기준으로 탐색
    public static int bfs(int left, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(left);

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            visited[tmp] = true;
            for (int i = 1; i < n + 1; i++) {
                if (arr[tmp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    cnt++;
                }
            }
        }

        // cnt = 왼쪽이 연결된 전선망 개수
        // n - cnt = 오른쪽이 연결된 전선망 개수
        // 최종 리턴 값 : n - cnt - cnt 의 절대값

        return Math.abs(n - (2 * cnt));
    }


}

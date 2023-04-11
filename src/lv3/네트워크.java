package lv3;

public class 네트워크 {
    public static void main(String[] args) {
        네트워크 test = new 네트워크();
//        int solution = test.solution(2, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
//        int solution = test.solution(2, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        int solution = test.solution(3, new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}});
        System.out.println(solution);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, visited, computers);
                answer += 1;
            }
        }

        return answer;
    }

    private void dfs(int i, int n, boolean[] visited, int[][] computers) {
        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, n, visited, computers);
            }
        }
    }
}

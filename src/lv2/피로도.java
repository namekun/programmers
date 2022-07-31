package lv2;

import java.util.ArrayList;

public class 피로도 {
    static int answer = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = solution(k, dungeons);
        System.out.println(solution);
    }

    public static int solution(int k, int[][] dungeons) {
        dfs(k, 0, new boolean[dungeons.length], dungeons);
        return answer;
    }

    public static void dfs(int k, int depth, boolean[] visited, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k){ // 방문하지 않았고, 해당 던전의 최소필요 피로도가 남아있는 k보다 적을 때 연산을 진행한다.
                visited[i] = true;
                dfs(k - dungeons[i][1], depth + 1, visited, dungeons); // 현재 피로도는 지나간 던전의 소모피로도를 빼주고, 그 다음에 depth를 늘린다.
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth); // 반복문이 끝나면, depth는 이번 경로에서는 몇 개의 던전을 탐색했는지가 된다.
    }
}

package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	public static int min;

	public static void main(String[] args) {
		int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
		int[][] map2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
		solution(map);
		solution(map2);
	}

	public static int solution(int[][] maps) {
//        min = maps.length * maps[0].length;
//        dfs(maps, 0, 0, 0);
//        if (min == maps.length * maps[0].length) min = -1;
//        System.out.println(min);

		int bfs = bfs(maps);
		System.out.println(bfs);

		return min;
	}

	public static int bfs(int[][] maps) {
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};
		int n = maps.length;
		int m = maps[0].length;

		boolean[][] visit = new boolean[n][m];
		int answer = Integer.MAX_VALUE;

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 1));
		while (!q.isEmpty()) {
			Pos temp = q.poll();

			if (temp.y == n - 1 && temp.x == m - 1) {
				answer = Math.min(answer, temp.cnt);
				continue;
			}

			for (int dir = 0; dir < 4; dir++) {
				int ny = dy[dir] + temp.y;
				int nx = dx[dir] + temp.x;

				if (ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx]) continue;
				if (maps[ny][nx] == 0) continue;

				visit[ny][nx] = true;
				int cnt = temp.cnt + 1;
				q.add(new Pos(ny, nx, cnt));
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	static class Pos {
		int y, x, cnt;

		public Pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}


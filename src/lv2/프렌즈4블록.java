package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        프렌즈4블록 test = new 프렌즈4블록();
        int solution = test.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF" });
        System.out.println(solution);
    }

    static boolean[][] v;   // 체크 배열

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        // String 배열은 변경이 어려움. char 배열로 복사해서 사용
        char[][] copy = new char[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = board[i].toCharArray();
        }

        boolean flag = true; // 중복 탐색할 것이 남았는지에 대한 flag
        while (flag) {
            v = new boolean[m][n];
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (copy[i][j] == '#') continue; // #은 빈칸을 의미
                    if (check(i, j, copy)) {    // 2*2 체크
                        v[i][j] = true;
                        v[i][j + 1] = true;
                        v[i + 1][j] = true;
                        v[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer += sortingArr(m, n, copy);
            v = new boolean[m][n];
        }
        return answer;
    }

    public static boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        return ch == board[x][y + 1] && ch == board[x + 1][y] && ch == board[x + 1][y + 1];
    }

    public static int sortingArr(int m, int n, char[][] board) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[i][j])
                    board[i][j] = '.';
            }
        }

        // 큐를 통해서 2차원 배열 정렬
        for (int i = 0; i < n; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (board[j][i] == '.') {
                    cnt++;  // 지우는 블록 카운트
                } else {
                    q.add(board[j][i]);
                }
            }
            int idx = m - 1;
            // 삭제한 블록 위의 블록들 내리기
            while (!q.isEmpty()) {
                board[idx--][i] = q.poll();
            }
            // 빈칸 채우기
            for (int j = idx; j >= 0; j--) {
                board[j][i] = '#';
            }
        }

        return cnt;
    }
}

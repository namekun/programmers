package lv2;

public class 거리두기확인하기 {
    public static void main(String[] args) {
       String [][] arr = {
               {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
               {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
               {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
               {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
               {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
       };
       solution(arr);
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[][] arr = new String[5][5];
            for (int j = 0; j < places[i].length; j++) {
                String[] splited = places[i][j].split("");
                arr[j] = splited;
            }
            answer[i] = check(arr);
        }

        return answer;
    }

    static int check(String[][] arr) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("X")) continue;
                // 1. 만약에 i, j가 o인 경우
                if (arr[i][j].equals("O")) {
                    int cnt = 0;
                    for (int k = 0; k < dx.length; k++) {
                        if (i + dx[k] >= 0 && j + dy[k] >=0 && i + dx[k] < 5 && j + dy[k] < 5) {
                            if(arr[i + dx[k]][j + dy[k]].equals("P")) cnt++;
                        }
                    }

                    if (cnt >= 2) return 0;
                }

                // 2. 만약에 i, j가 p인 경우
                if (arr[i][j].equals("P")) {
                    for (int k = 0; k < dx.length; k++) {
                        if (i + dx[k] >= 0 && j + dy[k] >=0 && i + dx[k] < 5 && j + dy[k] < 5) {
                            if(arr[i + dx[k]][j + dy[k]].equals("P"))return 0;
                        }
                    }
                }
            }
        }

        return 1;
    }
}

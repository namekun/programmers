package lv2;

import java.util.Arrays;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] solution = solution(1, 2, picture);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int areaCnt = 0;

        // 문제가 원본배열에 수정을 가하면 틀리다고 나온다.
        int[][] copy = new int[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) { // 반복문 + ArrayCopy
            System.arraycopy(picture[i], 0, copy[i], 0, copy[i].length);
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] != 0) {
                    areaCnt = getAreaCnt(copy, i, j, copy[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaCnt);
                    if (areaCnt != 0) numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int getAreaCnt(int[][] arr, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || arr[i][j] != color) return 0;
        arr[i][j] = 0; // 다음 탐색시에 카운팅되면 안되니까..
        return 1 + getAreaCnt(arr, i - 1, j, color)
                + getAreaCnt(arr, i + 1, j, color)
                + getAreaCnt(arr, i, j + 1, color)
                + getAreaCnt(arr, i, j - 1, color);
    }
}

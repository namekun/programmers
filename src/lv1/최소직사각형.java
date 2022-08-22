package lv1;

// 완전 탐색
public class 최소직사각형 {
    public static int solution(int[][] sizes) {
        int wide = 0;
        int height = 0;

        for(int[] arr : sizes){
            int a = Math.max(arr[0], arr[1]);
            int b = Math.min(arr[0], arr[1]);

            wide = Math.max(wide, a);
            height = Math.max(height, b);
        }

        return wide*height;
    }
}

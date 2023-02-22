package lv2;

public class 쿼드압축후개수세기 {
    public static void main(String[] args) {
        int [][] ex = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        쿼드압축후개수세기 test = new 쿼드압축후개수세기();
        test.solution(ex);
    }

    static int[] answer = new int[2];
    public int[] solution(int[][] arr){
        backTracking(arr, 0, 0, arr.length);
        return answer;
    }

    public void backTracking(int[][] arr, int x, int y, int quadSize){
        if(checkNum(arr, x, y, quadSize, arr[x][y])){
            if(arr[x][y] == 1){
                answer[1]++;
                return;
            }

            answer[0]++;
            return;
        }

        backTracking(arr, x, y, quadSize/2);
        backTracking(arr, x + quadSize/2, y, quadSize/2);
        backTracking(arr, x, y + quadSize/2, quadSize/2);
        backTracking(arr, x + quadSize / 2, y + quadSize / 2, quadSize / 2);
    }

    public boolean checkNum(int [][] arr, int x, int y, int quadSize, int standard){
        // quadSize만큼만 정사각형 탐색
        for (int i = x; i < x + quadSize; i++) {
            for (int j = y; j < y + quadSize; j++) {
                if (arr[i][j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}

package lv2;

public class n제곱배열자르기 {
    public static void main(String[] args) {
        solution(3, 2, 5);
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for(int i = 0; i < answer.length; i ++){
            answer[i] = Math.max((int) ((i + left) / n), (int) ((i + left) % n)) + 1;
        }

        return answer;
    }
}

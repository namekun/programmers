package lv2;

import java.util.Arrays;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        int[] solution = solution("110010101001");
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int length;
        int cnt = 0;
        int deleteZeroCnt = 0;

        while (s.length() != 1) {
            int originLength = s.length();
            s = s.replaceAll("0", "");
            length = s.length();
            deleteZeroCnt += originLength - length;
            s = Integer.toBinaryString(length);
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = deleteZeroCnt;
        return answer;
    }
}

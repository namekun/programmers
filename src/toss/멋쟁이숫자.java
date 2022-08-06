package toss;

public class 멋쟁이숫자 {
    public static void main(String[] args) {

        int solution = solution("111999333");
        System.out.println(solution);
    }

    public static int solution(String s) {
        int answer = -1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i + 2 >= charArray.length) break;

            if (charArray[i] == charArray[i + 1] && charArray[i + 1] == charArray[i + 2]) {
                StringBuilder sb = new StringBuilder();
                sb.append(charArray[i]).append(charArray[i + 1]).append(charArray[i + 2]);
                answer = Math.max(answer, Integer.parseInt(sb.toString()));
            }
        }
        return answer;
    }
}

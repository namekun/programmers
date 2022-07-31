package lv2;

public class 조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }

    public static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1; // 정방향으로 움직였을 때는 글자 길이의 -1 만큼 움직인다.
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 알파벳 변형에 얼마나 비용이 필요한가? 를 계산
            answer += getChangeCnt(chars[i]);

            // 해당 인덱스 뒤로 만약에 A가 연속적으로 있다면 그만큼 개수를 세어준다.
            int idx = i + 1;
            while (idx < chars.length && chars[idx] == 'A') {
                idx += 1;
            }

            move = Math.min(move, i * 2 + chars.length - idx); // 앞에서부터 돌고 그 다음에 뒤로가는게 더 적은 움직임을 갖게되는 경우 (BAAABB)
            move = Math.min(move, i + (chars.length - idx) * 2); // 뒤에서부터 돌고 다시 돌아오는 경우가 더 적은 움직임을 갖게되는 경우 (BBBAAAB)
        }

        return answer + move;
    }

    // 상하로 움직이는 경우 (알파벳을 바꿀떄 필요)
    public static int getChangeCnt(char a) {
        return Math.min(a - 'A', 'Z' - a + 1);
    }
}

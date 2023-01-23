package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 압축 {
    public static void main(String[] args) {
        압축 test = new 압축();
        test.solution("KAKAO");
    }

    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = init();

        recursive(dict, answer, msg);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<String> init() {
        return Arrays.stream("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")).collect(Collectors.toList());
    }

    private void recursive(List<String> dict, List<Integer> answer, String msg) {
        for (int i = 0; i < msg.length(); i++) {
            String subStr = msg.substring(0, i + 1);
            if (!dict.contains(subStr)) {
                dict.add(subStr);
                answer.add(dict.indexOf(msg.substring(0, i)) + 1);
                recursive(dict, answer, msg.substring(i));
                break;
            } else if (i + 1 == msg.length()) {
                answer.add(dict.indexOf(msg.substring(0, i + 1)) + 1);
                break;
            }
        }
    }

}

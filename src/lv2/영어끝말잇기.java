package lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        solution()
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> used = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            if (used.contains(words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            used.add(words[i]);
        }

        return answer;
    }
}

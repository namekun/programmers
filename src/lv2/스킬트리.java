package lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 스킬트리 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};
        스킬트리 test = new 스킬트리();
        int solution = test.solution(skill, skill_trees);
        System.out.println(solution);
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> standard = Arrays.stream(skill.split("")).collect(Collectors.toList());

        for (String skillTree : skill_trees) {
            int learned = -1;
            boolean isStandard = true;
            for (String s : skillTree.split("")) {
                if (standard.contains(s)) {
                    int index = standard.indexOf(s);
                    if (index < learned || index - learned > 1) {
                        isStandard = false;
                        break;
                    }
                    learned = index;
                }
            }
            if (isStandard) {
                answer++;
            }
        }

        return answer;
    }
}

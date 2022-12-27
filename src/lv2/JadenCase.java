package lv2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase {
    public static void main(String[] args) {
        String solution = solution("3people unFollowed me");
        System.out.println(solution);
    }

    public static String solution(String s) {
        String[] split = s.split("");
        split[0] = split[0].toUpperCase();
        for(int i = 1; i < split.length; i ++) {
            if(split[i-1].equals(" ")) {
                split[i] = split[i].toUpperCase();
            } else {
                split[i] = split[i].toLowerCase();
            }
        }

        return String.join("", split);
    }

}

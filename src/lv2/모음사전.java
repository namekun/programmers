package lv2;

import java.util.List;
import java.util.ArrayList;

public class 모음사전 {

    static String aeiou = "AEIOU";

    public static void main(String[] args) {
//        int aaae = solution("AAAE");
//        System.out.println(aaae);
        dfs("", 0);
        System.out.println(list.indexOf("AAAE"));
    }

    public static int solution(String word) {
        int answer = word.length();
        int[] increaseARR = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            answer += (aeiou.indexOf(word.charAt(i)) * increaseARR[i]);
        }

        return answer;
    }

    static List<String> list = new ArrayList<>();
    static void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for (int i = 0; i < 5; i++){
            dfs(str + "AEIOU".charAt(i), len + 1);
        }
    }
}

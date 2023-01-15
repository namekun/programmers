package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        뉴스클러스터링 test = new 뉴스클러스터링();
        int solution = test.solution("abab", "baba");
        System.out.println(solution);
    }

    public int solution(String str1, String str2) {
        int intersection = getIntersection(splitString(str1), splitString(str2));
        int union = getUnion(splitString(str1), splitString(str2), intersection);

        if(intersection == 0 && union == 0) {
            return 65536;
        }

        if(intersection == 0) {
            return 0;
        }

        double v = (double) intersection / union;

        return (int) (v * 65536);
    }

    private List<String> splitString(String str) {
        List<String> list;

        String[] splitString = str.split("");
        list = IntStream.range(0, splitString.length - 1)
                .filter(i -> checkMatch(splitString[i], splitString[i + 1]))
                .mapToObj(i -> (splitString[i] + splitString[i + 1]).toLowerCase())
                .collect(Collectors.toList());

        return list;
    }

    private boolean checkMatch(String str1, String str2) {
        return (str1.matches("[a-zA-Z]") && str2.matches("[a-zA-Z]"));
    }

    private int getIntersection(List<String> list1, List<String> list2){
        List<String> intersection = new ArrayList<>();

        list1.stream()
                .filter(list2::contains)
                .forEach(s -> {
                    intersection.add(s);
                    list2.remove(s);
                });

        return intersection.size();
    }

    private int getUnion(List<String> list1, List<String> list2, int intersectionSize){
        return list1.size() + list2.size() - intersectionSize;
    }
}

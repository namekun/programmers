package lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 튜플 {
    public static void main(String[] args) {
        튜플 test = new 튜플();
        int[] solution = test.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String s) {
        String[] splited = s.split("},");
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.stream(splited)
                .map(sp -> sp.replaceAll("[{}]", ""))
                .map(c -> c.split(","))
                .forEach(split -> Arrays.stream(split)
                        .forEach(x -> map.put(Integer.valueOf(x), 1 + map.getOrDefault(Integer.valueOf(x), 0)))
                );

        return map.keySet().stream()
                .sorted(Comparator.comparingInt(map::get).reversed())
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

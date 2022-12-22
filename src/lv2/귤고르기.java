package lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class 귤고르기 {
    public static void main(String[] args) {
        solution(4, new int[]{1, 2, 3, 4, 5, 1, 1, 1});
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> sizeMap = new HashMap<>();
        Arrays.stream(tangerine)
                .forEachOrdered(size -> {
                    sizeMap.put(size, sizeMap.getOrDefault(size, 0) + 1);
                });

        // 가장 적은 수의 종류를 뽑아내는 방법은, 애초에 많은 귤을 가진 사이즈를 기준으로 정렬해서 제거해나가면 된다.
        // 조건은 귤의 개수가 총 k가 되어야 함.
        List<Integer> sortedKeySet = sizeMap.keySet().stream()
                .sorted((o1, o2) -> sizeMap.get(o2) - sizeMap.get(o1))
                .collect(Collectors.toList());

        for (int key : sortedKeySet) {
            k -= sizeMap.get(key);
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }

}

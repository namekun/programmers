package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// greedy?
public class 체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println("solution(n, lost, reserve) = " + solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        List<Integer> lostList = Arrays.stream(lost).sorted().boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).sorted().boxed().collect(Collectors.toList());
        List<Integer> lenderList = new ArrayList<>();

        // 체육복을 잃어버리지 않은 상황황
       int cnt = n - lost.length;

        // 체육복 여분이 있는 사람이 체육복을 훔침당하는 경우의 수에 대한 체크
        for (int j : lost)
            if (reserveList.contains(j)) {
                lostList.remove((Integer) j);
                reserveList.remove((Integer) j);
                lenderList.add(j);
                cnt++;
            }

        for (int i : lostList) {
            if (reserveList.contains(i - 1) && !lenderList.contains(i - 1)) {
                    lenderList.add(i - 1);
                    cnt++;
            } else if (reserveList.contains(i + 1) && !lenderList.contains(i + 1)) {
                    lenderList.add(i + 1);
                    cnt++;
            }
        }

        return cnt;
    }
}

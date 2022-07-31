package lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class 실패율 {
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(solution(N, stages)));

        int x = 5;
        int[] stages2 = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(solution(x, stages2)));

        int m = 5;
        int[] stages3 = {6, 6, 6, 6};
        System.out.println(Arrays.toString(solution(m, stages3)));
    }

    public static Integer[] solution(int N, int[] stages) {

        HashMap<Integer, Integer> stageSurvivor = new HashMap<>();
        HashSet<FailRate> failRateSet = new HashSet<>();

        for (int i = 0; i < stages.length; i++) {
            if (stageSurvivor.containsKey(stages[i])) {
                stageSurvivor.put(stages[i], stageSurvivor.get(stages[i]) + 1);
            } else {
                stageSurvivor.put(stages[i], 1);
            }
        }

        int person = stages.length;
        for (int i = 1; i < N + 1; i++) {
            int survivor;

            if (stageSurvivor.containsKey(i)) {
                survivor = stageSurvivor.get(i);
                double failRate = (double) survivor / person;
                person -= stageSurvivor.get(i);
                failRateSet.add(new FailRate(i, failRate));
            } else {
                failRateSet.add(new FailRate(i, 0d));
            }
        }

        // 처음에 사용한 직접 Comparator 구현한 방법
//		Comparator<FailRate> comparator = (o1, o2) -> {
//			if (o1.failRate < o2.failRate) {
//				return 1;
//			} else if (o1.failRate == o2.failRate) {
//				if(o1.stage > o2.stage) return 1;
//				else return -1;
//			} else {
//				return -1;
//			}
//		};
//		Stream<FailRate> sorted = failRateSet.stream().sorted(comparator);
//		Integer[] answer = sorted.map(x -> x.stage).toArray(Integer[]::new);

        // stream의 thenComparing 사용한 코드
        Stream<FailRate> sortedByStreamCompare = failRateSet.stream().sorted(Comparator.comparing(FailRate::getFailRate, Comparator.reverseOrder()).thenComparing(FailRate::getStage));
        Integer[] answer = sortedByStreamCompare.map(x -> x.stage).toArray(Integer[]::new);

        return answer;
    }

    static class FailRate {
        int stage;
        double failRate;

        public FailRate(int stage, double failRate) {
            this.stage = stage;
            this.failRate = failRate;
        }

        public int getStage() {
            return stage;
        }

        public void setStage(int stage) {
            this.stage = stage;
        }

        public double getFailRate() {
            return failRate;
        }

        public void setFailRate(double failRate) {
            this.failRate = failRate;
        }
    }
}
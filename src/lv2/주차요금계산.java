package lv2;

import java.util.*;

public class 주차요금계산 {
    public static final int FINAL_TIME = 1439;

    public static void main(String[] args) {
        int[] fees = new int[]{1, 461, 1, 10};
        String[] records = new String[]{"00:00 1234 IN"};
        int[] solution = solution(fees, records);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        // 순서대로 시간, 차번호, 입출차 여부
        Arrays.stream(records).map(record -> record.split(" ")).forEachOrdered(recordArr -> {
            String recordTime = recordArr[0];
            int time = Integer.parseInt(recordTime.split(":")[0]) * 60 + Integer.parseInt(recordTime.split(":")[1]);
            if (recordArr[2].equals("IN")) {
                recordMap.put(recordArr[1], time);
            } else {
                if (resultMap.containsKey(recordArr[1])) {
                    resultMap.put(recordArr[1], resultMap.get(recordArr[1]) + (time - recordMap.get(recordArr[1])));
                } else {
                    resultMap.put(recordArr[1], time - recordMap.get(recordArr[1]));
                }
                recordMap.remove(recordArr[1]);
            }
        });

        if (recordMap.size() > 0) {
            recordMap.keySet().forEach(number -> resultMap.put(number, resultMap.getOrDefault(number, 0) + (FINAL_TIME - recordMap.get(number))));
        }

        List<Integer> resultFee = new ArrayList<>();
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        resultMap.keySet().stream().sorted().map(resultMap::get).forEachOrdered(sumOfTime -> {
            if (sumOfTime <= defaultTime) resultFee.add(defaultFee);
            else {
                resultFee.add(defaultFee + ((int) Math.ceil((sumOfTime - (double) defaultTime) / unitTime)) * unitFee);
            }
        });

        return resultFee.stream().mapToInt(Integer::intValue).toArray();
    }
}

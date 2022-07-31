package lv2;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] solution = solution(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> days = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) day += 1;
            days.add(day);
        }

        // init
        int standardDay = days.get(0);
        int deployCnt = 1;

        for (int i = 1; i < days.size(); i++) {
            if (days.get(i) <= standardDay) {
                deployCnt++;
            } else {
                answer.add(deployCnt);
                standardDay = days.get(i);
                deployCnt = 1;
            }

            if(i == days.size() - 1){
                answer.add(deployCnt);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

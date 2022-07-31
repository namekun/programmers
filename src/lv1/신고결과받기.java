// https://programmers.co.kr/learn/courses/30/lessons/92334

package lv1;

import java.util.Arrays;
import java.util.List;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] idList1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};


        String[] idList2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;

        System.out.println(Arrays.toString(solution(idList1, report1, k)));
        System.out.println(Arrays.toString(solution(idList2, report2, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {

        // 중복 제거
        report = Arrays.stream(report).distinct().toArray(String[]::new);


        int[] answer = new int[id_list.length];
        int[] reportedCnt = new int[id_list.length];
        for (String reported : report) {
            String[] s = reported.split(" ");
            int index = Arrays.asList(id_list).indexOf(s[1]);
            reportedCnt[index] += 1;
        }

        for (String reported : report) {
            String[] s = reported.split(" ");
            int index = Arrays.asList(id_list).indexOf(s[1]);
            if (reportedCnt[index] >= k) {
                answer[Arrays.asList(id_list).indexOf(s[0])] += 1;
            }
        }

        return answer;
    }
}
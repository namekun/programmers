package lv2;

import java.util.*;

public class 과제진행하기 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"korean", "11:40", "30"}, {"math", "12:30", "40"}, {"english", "12:10", "20"}};
        String[][] arr2 = new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        과제진행하기 test = new 과제진행하기();
        String[] solution = test.solution(arr2);
        System.out.println(Arrays.toString(solution));
    }

    public String[] solution(String[][] plans) {
        Stack<Plan> planStack = new Stack<>();
        List<Plan> planList = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        // 시간별 정렬
        for (String[] plan : plans) {
            String[] split = plan[1].split(":");
            int start = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            planList.add(new Plan(plan[0], start, Integer.parseInt(plan[2])));
        }

        planList.sort(Comparator.comparingInt(Plan::getStart));

        for (int i = 0; i < planList.size(); i++) {
            Plan plan = planList.get(i);

            if (i != planList.size() - 1) {
                int extraTime = planList.get(i + 1).getStart() - (plan.getStart() + plan.getPlaytime());

                // 다음 계획 시작시간보다 더 오래 걸리면
                if (extraTime < 0) {
                    plan.calc(plan.getPlaytime() - Math.abs(extraTime));
                    planStack.push(plan);
                }

                // 다음 계획 시작시간이 현재 계획이 끝난 뒤로도 진행된다면
                else {
                    answer.add(plan.getName());
                    while (!planStack.isEmpty()) {
                        // 만약 stack에 남은 계획이 남은 시간안에 다 끝난다면
                        if (planStack.peek().getPlaytime() <= extraTime) {
                            Plan pop = planStack.pop();
                            extraTime -= pop.getPlaytime();
                            answer.add(pop.getName());
                        }

                        // 남은 시간내로 계획이 끝나지 못한다면
                        else {
                            Plan pop = planStack.pop();
                            pop.calc(extraTime);
                            planStack.push(pop);
                            break;
                        }
                    }
                }
            } else {
                answer.add(plan.getName());
                while (!planStack.isEmpty()) {
                    answer.add(planStack.pop().getName());
                }
            }
        }
        return answer.toArray(String[]::new);
    }
}

class Plan {
    private final String name;
    private final int start;
    private int playtime;

    public Plan(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }

    public void calc(int useTime) {
        this.playtime -= useTime;
    }

    public int getStart() {
        return start;
    }

    public int getPlaytime() {
        return playtime;
    }

    public String getName() {
        return name;
    }
}
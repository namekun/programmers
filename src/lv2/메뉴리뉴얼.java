package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
    }

    public static String[] solution(String[] orders, int[] course) {

        HashMap<String, Integer> courseMap = new HashMap<>();
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            boolean[] visited = new boolean[chars.length];
            for (int i : course) {
                if(order.length() >= i) combination(chars, visited, courseMap, 0, i);
            }
        }

        ArrayList<String> courseList = new ArrayList<>();
        for(int i : course){
            int max = 0;
            for(String combi : courseMap.keySet()){
                if(combi.length() == i && courseMap.get(combi) > 1){
                    max = Math.max(max, courseMap.get(combi)) == courseMap.get(combi) ? courseMap.get(combi) : max;
                }
            }

            for(String combi : courseMap.keySet()){
                if(combi.length() == i){
                    if(courseMap.get(combi) == max) courseList.add(combi);
                }
            }
        }

        return courseList.stream().sorted().toArray(String[]::new);
    }

    static void combination(char[] arr, boolean[] visited, HashMap<String, Integer> courseMap, int start, int menuCnt) {
        if (menuCnt == 0) {
            StringBuilder combinationString = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) combinationString.append(arr[i]);
            }

            if(courseMap.containsKey(combinationString.toString())){
                courseMap.put(combinationString.toString(), courseMap.get(combinationString.toString()) + 1);
            } else {
                courseMap.put(combinationString.toString(), 1);
            }

            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, courseMap, i + 1, menuCnt - 1);
            visited[i] = false;
        }
    }
}

package lv2;

import java.util.Arrays;
import java.util.Stack;

public class 문자열압축 {
    public static void main(String[] args) {
        String a = "a";
        System.out.println(solution(a));
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int cuttingRange = 1;
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            Stack<String> stack = new Stack<>();
            StringBuilder resultString = new StringBuilder();
            StringBuilder slicedString = new StringBuilder();
            int cnt = 0; // 잘라내고 싶은 길이만큼 for 문을 돌았는지 확인하기 위한 변수
            char[] chars = s.toCharArray();
            for (int j = 0; j < s.length(); j++) {

                slicedString.append(chars[j]);
                cnt++;

                if (cnt == cuttingRange) {
                    if (stack.isEmpty() || stack.peek().equals(slicedString.toString())) {
                        stack.push(slicedString.toString());
                    } else {
                        int size = stack.size();
                        if (size > 1) {
                            resultString.append(size).append(stack.pop());
                        } else {
                            resultString.append(stack.pop());
                        }
                        // 로직이 끝났으면 비우고, 현재 갖고 있는 변수를 스택에 더한다.
                        stack.clear();
                        stack.push(slicedString.toString());
                    }
                    // 잘라내는 변수에 대해서는 초기화한다.
                    cnt = 0;
                    slicedString = new StringBuilder();
                }

                if (j == s.length() - 1) {
                    // for 문이 끝났지만, 아직 비우지 못한 stack 을 위해서.
                    int size = stack.size();
                    if (size > 1) {
                        resultString.append(size).append(stack.pop());
                    } else {
                        resultString.append(stack.pop());
                    }
                    // cuttingRange 가 커지면 커질수록, stack 에도 못들어가는 문자열이 발생하기에, 그런 문자열들은 다 더해준다.
                    if (slicedString.length() > 0) resultString.append(slicedString);
                }
            }
            answer = Math.min(answer, resultString.length());
            cuttingRange++; // 잘라내는 길이를 늘린다.
        }
        return answer;
    }
}

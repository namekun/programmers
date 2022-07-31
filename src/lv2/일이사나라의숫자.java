package lv2;

import java.util.Stack;

public class 일이사나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        getNum(n, stack);
        while (!stack.isEmpty()){
                answer.append(stack.pop());
        }
        return answer.toString();
    }

    public static void getNum(int n, Stack<Integer> stack) {
        int x = n / 3;
        int y = n % 3;
        if (y == 0) {
            y = 4;
            x -= 1;
        }

        stack.push(y);
        if(x >= 3){
            getNum(x, stack);
        } else {
            if(x > 0) {
                stack.push(x);
            }
        }
    }
}

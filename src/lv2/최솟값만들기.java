package lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최솟값만들기 {
    public static void main(String[] args) {

    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++){
            answer += (A[i] * B[B.length - i - 1]);
        }


//        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
//        PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i = 0; i < A.length; i++){
//            aQueue.add(A[i]);
//            bQueue.add(B[i]);
//        }
//
//        while (!aQueue.isEmpty()){
//            answer += aQueue.poll() * bQueue.poll();
//        }

        return answer;
    }
}

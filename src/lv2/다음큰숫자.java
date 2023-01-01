package lv2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 다음큰숫자 {
    public static void main(String[] args) {
        다음큰숫자 test = new 다음큰숫자();
        test.solution(78);
    }

    public int solution(int n) {
        // condition
        // n보다 다음 큰 숫자는 n보다 큰 자연수
        // n의 다음 큰 숫자와 n은 2진수로 변환했을때 1의 개수가 동일


        // 굳이 이렇게 할 필요없고, bitCount 함수를 사용해본다.
        //        String binaryString = Integer.toBinaryString(n);
        //        List<Character> characters = binaryString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        //        int frequency = Collections.frequency(characters, '1');
        int frequency = Integer.bitCount(n);


        for (int i = n + 1; ; i++) {
        //  List<Character> characterList = Integer.toBinaryString(i).chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        //  int nextFrequency = Collections.frequency(characterList, '1');

            if(frequency == Integer.bitCount(i)){
                return i;
            }
        }
    }
}

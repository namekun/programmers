package lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬 test = new 파일명정렬();
        test.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
    }

    public String[] solution(String[] files) {
        String[] answer = {};

        // 파일명을 3등분해서 3번 정렬을 해야 한다.
        // 알파벳 대문자 / 소문자는 차이 없음.
        List<FileName> fileList = new ArrayList<>();

        for (String file : files) {
            // 숫자가 나오기 전까지 카운팅
            StringBuilder stringBuilder = new StringBuilder();
            int memNum = 0;
            for (int i = 0; i < file.length(); i++) {
                if (Character.isDigit(file.charAt(i))) {
                    memNum = i;
                    break;
                }

                stringBuilder.append(file.charAt(i));
            }
            String head = stringBuilder.toString();

            stringBuilder = new StringBuilder();
            for (int i = memNum; i < file.length(); i++) {
                if (!Character.isDigit(file.charAt(i))) {
                    memNum = i;
                    break;
                }
                stringBuilder.append(file.charAt(i));
            }

            int number = Integer.parseInt(stringBuilder.toString());
            String tail = file.substring(memNum);
            fileList.add(new FileName(file, head, number, tail));
        }

        answer = fileList.stream()
                .sorted(Comparator.comparing((FileName fileName) -> fileName.getHead().toLowerCase()).thenComparing(FileName::getNumber))
                .map(FileName::getFileName).toArray(String[]::new);

        return answer;
    }
}

class FileName {
    private final String fileName;
    private final String head;
    private final int number;
    private final String tail;

    public FileName(String fileName, String head, int number, String tail) {
        this.fileName = fileName;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }

    public String getFileName() {
        return fileName;
    }

    public String getHead() {
        return head;
    }

    public int getNumber() {
        return number;
    }
}


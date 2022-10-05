// https://programmers.co.kr/learn/courses/30/lessons/72410

package lv1;

public class 신규아이디추천 {
	public static void main(String[] args) {
		solution("...!@BaT#*..y.abcdefghijklm");
		solution("=.=");
		solution("z-+.^.");
		solution("abcdefghijklmn.p");
	}

	public static String solution(String new_id) {
		// 1. 대문자 -> 소문자
		new_id = new_id.toLowerCase();

		// 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 나머지 제거
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

		// 3. 마침표가 2번 이상 연속되면 하나의 마침표로 치환한다.
		new_id = new_id.replaceAll("[.]+", ".");

		// 4. 마침표가 처음과 끝에 있다면, 제거한다.
		new_id = new_id.replaceAll("^[.]|[.]$", "");

		// 5. 해당 문자열이 빈 문자열이면 'a'를 넣어준다.
		if (new_id.length() == 0) new_id = "a";

		// 6. 문자열의 길이가 16자 이상이면, 15자를 제외한 글자는 모두 제거한다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (new_id.length() > 15) new_id = new_id.substring(0, 15).replaceAll("[.]$", "");

		// 7. 문자열의 길이가 2자 이하라면, 문자열의 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙인다.
		StringBuilder new_idBuilder = new StringBuilder(new_id);
		while (new_idBuilder.length() < 3) {
			new_idBuilder.append(new_idBuilder.substring(new_idBuilder.length() - 1));
		}
		new_id = new_idBuilder.toString();

		System.out.println(new_id);

		return new_id;
	}
}


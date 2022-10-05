package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		solution(record);
		System.out.println(Arrays.toString(solution(record)));
	}

	public static String[] solution(String[] record) {
		Map<String, String> nickNameMap = new HashMap<>();
		ArrayList<String> checkList = new ArrayList<>();
		for (String data : record) {
			String[] splitData = data.split(" ");
			if (splitData[0].equals("Enter") || splitData[0].equals("Change")) {
				nickNameMap.put(splitData[1], splitData[2]);
			}

			if (splitData[0].equals("Enter") || splitData[0].equals("Leave")) {
				checkList.add(data);
			}
		}

		String[] answer = new String[checkList.size()];
		for (int i = 0; i < checkList.size(); i++) {
			String[] splitData = checkList.get(i).split(" ");
			answer[i] = nickNameMap.get(splitData[1]) + getMsg(splitData[0]);
		}

		return answer;
	}

	public static String getMsg(String data) {
		if (data.equals("Enter")) {
			return "님이 들어왔습니다.";
		} else if (data.equals("Leave")) {
			return "님이 나갔습니다.";
		}
		return null;
	}
}

package lv2;

import java.util.HashSet;
import java.util.Set;

public class 방문길이 {
	public static void main(String[] args) {
		방문길이 test = new 방문길이();
//		int movement = test.solution("UUUUDUDUDUUU");
//		int movement = test.solution("ULURRDLLU");
		int movement = test.solution("LRL");
		System.out.println(movement);
	}

	public int solution(String dirs) {
		int x = 0;
		int y = 0;

		// up, down, right, left
		int[] xPoint = {0, 0, 1, -1};
		int[] yPoint = {1, -1, 0, 0};

		Set<String> MEM = new HashSet<>();

		String[] directions = dirs.split("");
		for (String direction : directions) {
			int move = move(direction);
			int movedX = x + xPoint[move];
			int movedY = y + yPoint[move];

			if (movedX > 5 || movedX < -5 || movedY > 5 || movedY < -5) {
				continue;
			}

			if(direction.equals("U") || direction.equals("R")){
				MEM.add(String.valueOf(x) + y + movedX + movedY);
			}

			if(direction.equals("D") || direction.equals("L")){
				MEM.add(String.valueOf(movedX) + movedY + x + y);
			}

			x = movedX;
			y = movedY;
		}

		return MEM.size();
	}

	private int move(String direction) {
		switch (direction) {
			case "U":
				return 0;
			case "D":
				return 1;
			case "R":
				return 2;
			case "L":
				return 3;
			default:
				throw new IllegalStateException("Unexpected value: " + direction);
		}
	}
}
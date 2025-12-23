package PT1;

public class SwitchCase {
	public static void main(String[] args) {
		int ranking = 2;
		String medalColor;
		
		switch (ranking) {
		case 1 : medalColor = "금메달";
				break;
		case 2 : medalColor = "은메달";
				break;
		case 3 : medalColor = "동메달";
				break;
		default:
				medalColor = "없음";
		}
		System.out.println(ranking + "등은 " + medalColor + " 입니다.");
		}
	}

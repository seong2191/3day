package SeongYun.submit13;

import java.util.ArrayList;



public class SoccerDB {
	private ArrayList<Soccer> playerList = new ArrayList<>();

	private static SoccerDB instance = new SoccerDB();

	private SoccerDB() {
		String korList = "조현우, 김영권, 김진수,김민재,김태환, 손흥민,이재성, 정우영,황희찬, 황의조, 권창훈";

		String[] korArray = korList.split(",");

		for (int i = 0; i < korArray.length; i++) {
			korArray[i] = korArray[i].trim();
		}

		for (int i = 0; i < korArray.length; i++) {
			playerList.add(new Soccer(playerList.size(), korArray[i]));
		}
	}

	public static SoccerDB getInstance() {
		return instance;
	}
	public ArrayList<Soccer> getSearchList(String keyword){
		ArrayList<Soccer> resultList = new ArrayList<>();
		for(Soccer soccer : playerList) {
			if(soccer.getName().indexOf(keyword) != -1) {
				resultList.add(soccer);
			}
		}
		return resultList;
	}

	public void showPlayerList() {
		for (Soccer soccer : playerList) {
			System.out.println(soccer);
		}
	}

}

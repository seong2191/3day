package ch08_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class PlayMap {

	public static void main(String[] args) {

		ArrayList<String> playList = new ArrayList<String>(Arrays.asList("INVU: 태연", "사랑은 늘 도망가: 임영웅", "취중고백: 멜로망스",
				"언제나 사랑해: 케이시", "듣고 싶을까: MSG워너비", "ELEVEN: IVE", "Step Back: GOT the beat", "abcdefu: GAYLE",
				"회전목마: sokodomo", "너, 너: 휘인", "SMILEY: YENA", "호랑수월가: 탑현", "리무진: 비오", "RUN2U: STAYC", "눈이 오잖아: 이무진",
				"Counting Stars: 비오", "신호등: 이무진", "어제처럼: 폴킴", "잊었니: 임영웅", "잊을 수 있을까: 노을", "HERO: 임영웅",
				"Can't Control Myself: 태연", "Next Level: aespa", "strawberry moon: 아이유", "겨울잠: 아이유", "끝사랑: 임영웅",
				"드라마: 아이유", "Bk Love: 임영웅", "만남은 쉽고 이별은 어려워: 베이식", "Weekend: 태연", "Savage: aespa", "Butter: 방탄소년단",
				"Dynamite: 방탄소년단", "OHAYO MY NIGHT: 디핵", "사랑인가 봐: 멜로망스", "라일락: 아이유", "Celebrity: 아이유", "낙하: 악동뮤지션",
				"Blueming: 아이유", "롤린: 브레이브걸스", "고백: 멜로망스", "그런 밤: 태연"));
		// 노래 제목은 key, 가수는 value로 하는 해쉬맵을 만들어 플레이르스트 테이블을 담아보자
		HashMap<String, String> playMap = new HashMap<>();
		for (int i = 0; i < playList.size(); i++) {
			String[] strArr = playList.get(i).split(": ");
			playMap.put(strArr[0], strArr[1]);
		}
		System.out.println(playMap);
		showPlayMap(playMap);

		System.out.println("\n=================================\n");

		// 검색
		HashMap<String, String> searchMap = searchSong("노래", "사랑", playMap);
		showPlayMap(searchMap);

		searchMap = searchSong("가수", "영웅", playMap);
		showPlayMap(searchMap);

	}// 메인 끝

	static HashMap<String, String> searchSong(String option, String keyword, HashMap<String, String> inputMap) {
		Set<String> keySet = inputMap.keySet();
		HashMap<String, String> resultMap = new HashMap<>();
		for (String key : keySet) {
			if (option.equals("노래")) {
				String song = key;
				if (song.contains(keyword)) {
					resultMap.put(key, inputMap.get(key));
				}
			} else if (option.equals("가수")) {
				String singer = inputMap.get(key);
				if (singer.contains(keyword)) {
					resultMap.put(key, inputMap.get(key));
				}
			}

			String singer = inputMap.get(key);
		}
		return resultMap;
	}

	static void showPlayMap(HashMap<String, String> inputMap) {
		Set<String> keySet = inputMap.keySet();
		// 10개 출력 할때마다 줄(syso) 그어주세요
		int count = 0;
		for (String key : keySet) {
			if (count % 10 == 0) {
				System.out.println();
				System.out.println(((count / 10) + 1) + " 페이지" + "==========================");
			}
			System.out.println(key + ": " + inputMap.get(key));
			count++;
		}

	}

}

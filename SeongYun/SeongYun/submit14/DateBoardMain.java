package SeongYun.submit14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {

		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 30개 삽입
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date datenow = new Date();

		for (int i = 0; i < 30; i++) {
			int randMonth = (int) (Math.random() * 5) + 1; // 1~5
			int randDay = (int) (Math.random() * 28) + 1; // 1~28
			Calendar cal = Calendar.getInstance();
			cal.set(2022, randMonth - 1, randDay);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard(i + "번째 생성된 글", strDate));
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		// 3번 날짜순으로 출력(최신순 내림차순)
		System.out.println("\n=========최신순=========");
		for (int j = 0; j < dbList.size(); j++) {
			for (int i = 0; i < dbList.size() - 1; i++) {
				Date dateone = sdf.parse(dbList.get(i).getDate());
				Date datetwo = sdf.parse(dbList.get(i + 1).getDate());
				if (dateone.getTime() < datetwo.getTime()) {
					DateBoard temp = dbList.get(i);
					dbList.set(i, dbList.get(i + 1));
					dbList.set(i + 1, temp);
				}
			}
		}
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		// i < i+1 내림차순
//		for (int j = 0; j < numArray.length; j++) {
//			for (int i = 0; i < numArray.length - 1; i++) {
//				if (numArray[i] < numArray[i + 1]) {
//					int tmp = numArray[i];
//					numArray[i] = numArray[i + 1];
//					numArray[i + 1] = tmp;
//				}
//			}
//		}

		// 3번 날짜순으로 출력(오름차순)
		System.out.println("\n=========오래된 순=========");
		for (int j = 0; j < dbList.size(); j++) {
			for (int i = 0; i < dbList.size() - 1; i++) {
				Date dateone = sdf.parse(dbList.get(i).getDate());
				Date datetwo = sdf.parse(dbList.get(i + 1).getDate());
				if (dateone.getTime() > datetwo.getTime()) {
					DateBoard temp2 = dbList.get(i);
					dbList.set(i, dbList.get(i + 1));
					dbList.set(i + 1, temp2);
				}

			}
		}
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		// 4번 최근 한달 내(오늘 기준 30일 전까지)
		System.out.println("\n==========4번===========");

		Date date = new Date();
		for (int i = 0; i < dbList.size(); i++) {
			long me = date.getTime() - sdf.parse(dbList.get(i).getDate()).getTime();
			if (me < (1000 * 60 * 60 * 24 * 30l)) {
				System.out.println(dbList.get(i));
			}
		}

	}
}

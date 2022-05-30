package SeongYun.submit14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 30개 삽입
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

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

		System.out.println("\n======================\n");

		// 날짜별로 정렬 후 출력
		System.out.println("최신순");
		for (int i = 0; i < dbList.size() - 1; i++) {
			for (int j = 0; j < dbList.size() - i - 1; j++) {
				// j번째 DateBoard와 j+1번째 DateBoard
				// 중 어느것이 더 날짜가 최신인지 판단

				Date prev = sdf.parse(dbList.get(j).getDate());
				Date post = sdf.parse(dbList.get(j + 1).getDate());

				// prev < post 면 최신순
				// prev > post 면 오래된순
				if (prev.getTime() < post.getTime()) {
					DateBoard temp = dbList.get(j);
					dbList.set(j, dbList.get(j + 1));
					dbList.set(j + 1, temp);
				}
			}
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		System.out.println("\n==========================\n");

		System.out.println("오래된 순");
		Collections.sort(dbList);

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		System.out.println("\n===========================\n");

		// 최근 한달 내 작성된 게시글만 출력

		System.out.println("한달 내 게시글");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);

		for (int i = 0; i < dbList.size(); i++) {
			Date data = sdf.parse(dbList.get(i).getDate());

			// 각각의 데이터를 밀리초로 나타낸 것이
			// 한달 전 데이터를 밀리초로 나타낸 것보다
			// 크면 한달 전 이내인 데이터이다.
			if (cal.getTime().getTime() < data.getTime()) {
				System.out.println(dbList.get(i));
			}
		}

		System.out.println("\n=========================\n");

		// 이번달 작성된 게시글
		System.out.println("이번달 작성된 게시글");
		Calendar calToday = Calendar.getInstance();
		int year = calToday.get(Calendar.YEAR);
		int month = calToday.get(Calendar.MONTH) + 1;

		System.out.println(month);

		for (int i = 0; i < dbList.size(); i++) {
			Date data = sdf.parse(dbList.get(i).getDate());
			Calendar temp = Calendar.getInstance();
			temp.setTime(data);

			int dataMonth = temp.get(Calendar.MONTH) + 1;
			int dataYear = temp.get(Calendar.YEAR);
			if (month == dataMonth && year == dataYear) {
				System.out.println(dbList.get(i));
			}
		}

		System.out.println("\n====================\n");

		System.out.println("2월에 작성된 게시글");

		for (int i = 0; i < dbList.size(); i++) {
			Date data = sdf.parse(dbList.get(i).getDate());
			Calendar temp = Calendar.getInstance();
			temp.setTime(data);

			int dataMonth = temp.get(Calendar.MONTH) + 1;
			int dataYear = temp.get(Calendar.YEAR);
			if (2 == dataMonth && 2022 == dataYear) {
				System.out.println(dbList.get(i));
			}
		}

		System.out.println("\n====================\n");

		System.out.println("특정 날짜에 해당하는 게시글");
		String fromStr = "2022.02.14";
		String toStr = "2022.03.21";
		sdf = new SimpleDateFormat("yyyy.MM.dd");

		Date fromDate = sdf.parse(fromStr);
		Date toDate = sdf.parse(toStr);

		for (int i = 0; i < dbList.size(); i++) {
			Date data = sdf.parse(dbList.get(i).getDate());

			if (fromDate.getTime() < data.getTime() && data.getTime() < toDate.getTime()) {
				System.out.println(dbList.get(i));
			}
		}

	}

}

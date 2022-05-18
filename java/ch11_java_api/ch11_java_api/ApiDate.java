package ch11_java_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDate {

	public static void main(String[] args) throws ParseException {

		// 현재 시간
		// 1. Date 클래스 사용
		Date dateToday = new Date();

		// Date 객체가 new Date() 로 생성되는 순간,
		// 해당 Date 객체(dateToday) 내부에 그 때의 시간이 세팅된다.
		System.out.println(dateToday);

		// 2022년 05월 18일 14시 05분 05초
		// 2022/05/18 14:05:05
		// 위와 같이 날짜 포맷 설정

		// 형식 2022년 05월 18일 14시 05분 05초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String strToday = sdf.format(dateToday);
		System.out.println(strToday);

		// 형식 2022/05/18 14:05:05
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		strToday = sdf.format(dateToday);
		System.out.println(strToday);

		System.out.println("\n=========================================\n");

		// 2. Calendar 클래스 사용
		// .getInstance() 이지만 싱글톤 패턴이 적용되어 있지 않음
		// new Date()와 마찬가지로 Calender.getInstance()가
		// 실행되는 그 시간이 세팅된 객체를 생성
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday);
		System.out.println(calToday.getTime());

		// 날짜 포맷 설정
		strToday = sdf.format(calToday.getTime());
		System.out.println(strToday);

		System.out.println("\n=========================================\n");

		// 3. System 클래스 사용
		// long longToday = System.currentTimeMillis(); -< 1652851381454(이런 형식)인데
		// 1970년 1월 1일 09시부터 현재까지의 경과된 시간을 밀리초 단위로 리턴 (굳이..)
		long longToday = System.currentTimeMillis();
		System.out.println(longToday);

		// 날짜 포맷 설정
		strToday = sdf.format(longToday);
		System.out.println(strToday);

		System.out.println("\n=========================================\n");

		// 다양한 날짜 타입 만들기
		// 1. 2022/05/18 14:27:30
		// 2. 2022-05-18 오후 02:27:30
		// 3. 수 오후 02:27:30
		// 4. 수요일 14:27:30
		// @. 2022-05-18 PM 02:27:30

		Date dateNow = new Date();

		System.out.println("\n====1====");
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		System.out.println("\n====2====");
		sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		System.out.println("\n====3====");
		sdf = new SimpleDateFormat("E a hh:mm:ss");
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		System.out.println("\n====4====");
		sdf = new SimpleDateFormat("E요일 kk:mm:ss");
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		System.out.println("\n====@====");
		sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss", Locale.US);
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		// 현재 미국 날짜는?
		sdf = new SimpleDateFormat("yyyy/MM/dd E a hh:mm:ss");
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
//		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		sdf.setTimeZone(timeZone);
		strToday = sdf.format(dateNow);
		System.out.println(strToday);

		System.out.println("\n=========================================\n");

		// 날짜(Date 타입) -> 문자열(String) 타입
		String strTomorrow = "2022-05-19 15:01:12";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTomorrow = sdf.parse(strTomorrow);

		System.out.println(dateTomorrow);

		// 연도 기본값은 1970년
		String strTime = "11:20:33";
		sdf = new SimpleDateFormat("HH:mm:ss");
		Date dateTime = sdf.parse(strTime);
		System.out.println(dateTime);

		// 시간 기본값은 00:00:00
		String strYear = "2022.04.18";
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date dateYear = sdf.parse(strYear);
		System.out.println(dateYear);

		System.out.println("\n=========================================\n");

		// 날짜 세팅하기
		Calendar cal = Calendar.getInstance();

		// Month의 경우 1월이 0, 2월이 1, 3월이 2, ...
//		cal.set(1996, 10, 10, 15, 30, 20);
		cal.set(1996, 9, 10, 15, 30, 20);

		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strCal = sdf.format(cal.getTime());
		System.out.println(strCal); // month 자리에 10을 입력했지만 출력은 11이 됐다.

		// Date 타입을 Calendar 타입으로 변환
		Date temp = new Date();
		Calendar calTemp = Calendar.getInstance();
		calTemp.setTime(temp);

		System.out.println("\n=========================================\n");

		// 날짜 꺼내기
		String anyTime = "2020.06.21 23:11:21";
		Date dateAnyTime = sdf.parse(anyTime);

		Calendar anyCal = Calendar.getInstance();
		anyCal.setTime(dateAnyTime);

		// 연도 꺼내기
		System.out.println(anyCal.get(Calendar.YEAR)); // 2020

		// 월 꺼내기
		System.out.println(anyCal.get(Calendar.MONTH) + 1); // +1을 안하면 5가 나옴 // 6

		// 일 꺼내기
		System.out.println(anyCal.get(Calendar.DATE)); // 21

		// 시간 꺼내기
		System.out.println(anyCal.get(Calendar.HOUR_OF_DAY)); // 23
//		System.out.println(anyCal.get(Calendar.HOUR)); // 12시간 표기인 11이 나옴

		// 분 꺼내기
		System.out.println(anyCal.get(Calendar.MINUTE)); // 11

		// 초 꺼내기
		System.out.println(anyCal.get(Calendar.SECOND)); // 21

		System.out.println("\n=========================================\n");

		// 날짜 연산
		String oneDay = "2022.05.17 12:34:56";
		String twoDay = "2022.05.19 14:23:11";

		// 먼저 문자열을 Date 타입으로 바꿔야함.
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date dateOneDay = sdf.parse(oneDay);
		Date dateTwoDay = sdf.parse(twoDay);
		
		// 둘 중 현재시간을 기준으로 좀 더 미래인 날짜는?
		System.out.println(dateOneDay.getTime()); // 롱타입 1652758496000 
		System.out.println(dateTwoDay.getTime()); // 1652937791000
		
		// 롱타입의 결과값(밀리초)이 더 클수록 미래다.
		long diffMillSec = dateTwoDay.getTime() - dateOneDay.getTime();
		System.out.println(diffMillSec); // 밀리초 차이 값이 출력
		
		// 초 차이
		long diffSec = diffMillSec / 1000;
		System.out.println(diffSec + "초 차이");
		
		// 분 차이
		long diffMin = diffSec / 60; // 60초로 나눈거
		System.out.println(diffMin + "분 차이");
		
		// 시간 차이
		long diffHour = diffMin / 60; // 60분으로 나눈거
		System.out.println(diffHour + "시간 차이");
		
		// 일수 차이
		long diffDate = diffHour / 24; // 24시간으로 나눈거
		System.out.println(diffDate + "일 차이");
		
		// 연도 차이
		long diffYear = diffDate / 365; // 24시간으로 나눈거
		System.out.println(diffYear + "년 차이");
		
		// 초 차이~ 연도 차이 까지 한 줄로
		long diff = diffMillSec / (1000*60*60*24); // 밀리초 / (초*분*시간*일)
		System.out.println(diff);
		
		System.out.println("\n=========================================\n");
		
		// 디데이 계산
		// 오늘 날짜 준비
		Date today = new Date();
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		strToday = sdf.format(today); // 문자열로 바뀜
		System.out.println(strToday); // 2022.05.18
		
		Date todate = sdf.parse(strToday);
		System.out.println(todate); // Wed May 18 00:00:00 KST 2022
		
		String dDay = "2022.06.01";
		Date dDate = sdf.parse(dDay);
//		System.out.println(dDay);
		
		diffMillSec = dDate.getTime() - todate.getTime(); // 밀리초로 출력
		diff = diffMillSec / (1000*60*60*24);
		System.out.println("지방선거까지 D-day는 " + diff + "일 남았습니다.");
		
		
		dDay = "2022.04.11";
		dDate = sdf.parse(dDay); // Date 객체로 바꿔줌
		diffMillSec = todate.getTime() - dDate.getTime(); // 밀리초로 출력
		diff = diffMillSec / (1000*60*60*24);
		System.out.println("교육 시작한 날부터 " + diff + "일 지났습니다.");
		
		System.out.println("\n=========================================\n");
		
		// 날짜 연산 Calendar
		// Calendar를 이용하는게 좋다.
		// 특정 날짜를 기준으로 날짜를 더하거나 뺄 때 유용
		
		Calendar toCal = Calendar.getInstance();
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(toCal.getTime()));
		
		// 3일 뒤
		toCal.add(Calendar.DATE, 3); // 현재 날짜의 3일 뒤
		System.out.println(sdf.format(toCal.getTime()));
		
		// 20일 뒤
		toCal.add(Calendar.DATE, 20); // 현재 날짜의 20일 뒤
		System.out.println(sdf.format(toCal.getTime()));
		
		// 7일 전
		toCal.add(Calendar.DATE, -7); // 현재 날짜의 7일 전
		System.out.println(sdf.format(toCal.getTime()));
		
		// 11개월 뒤
		toCal.add(Calendar.MONTH, 11); // 현재 날짜의 11개월 뒤
		System.out.println(sdf.format(toCal.getTime()));
		
		System.out.println("\n=========================================\n");
		
		// 달력 만들기
		int year = 2022;
		int month = 3;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, 1);
		System.out.println(sdf.format(calendar.getTime()));
		
		// 해당 달의 마지막 일자(DATE)를 얻기
		int lastDay = calendar.getActualMaximum(calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		
		// 해당 달의 시작 요일 얻기
		// 1: 일요일, 2: 월, 3: 화 ..., 7: 토
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay); // 3 -> 화요일
		
		
		System.out.println("==================" + year + "년 " + month + "월 달력" + "==================");
		System.out.println();
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// 42의 의미는 
		// 달력의 나올 수 있는 최대 줄 갯수(6) * 요일 수(7)
		// \t는 공백
		int currentDay = 1;
		for(int i = 1; i <= 42; i++) {
			if(i < startDay) {
				System.out.print("\t");
			}else {
				System.out.printf("%2d\t", currentDay);
				currentDay++;
				
				if(currentDay > lastDay) {
					break;
				}
			}
			if(i % 7 == 0) {
				System.out.println("");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

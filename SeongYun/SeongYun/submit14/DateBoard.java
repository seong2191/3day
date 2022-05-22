package SeongYun.submit14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBoard implements Comparable<DateBoard>{
	private String title;
	private String date;
	
	public DateBoard(String title, String date) {
		this.title = title;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "[글제목: " + title + ", 게시일: " + date + "]";
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int compareTo(DateBoard another) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		int result = 0;
		
		try {
			Date thisDate = sdf.parse(date);
			Date anotherDate = sdf.parse(another.getDate());
			
			// 오래된 순
			long diffMillSec = thisDate.getTime() - anotherDate.getTime();
			// 최신 순
//			long diffMillSec =  anotherDate.getTime() - thisDate.getTime();
			
			// compareTo가 궁금한건 현재 객체와 (this)
			// 파라미터로 들어온 다른 객체의(another)
			// 어떤 연산 결과가 양수인지 0인지 음수인지만 궁금
			if(diffMillSec > 0) {
				result =  1;
			}else if(diffMillSec < 0){
				result = 1;
			}else {
				result =  0;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
}
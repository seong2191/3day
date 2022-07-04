import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

public class Main {
	public static void main(String[] args) throws Exception {
		/*
		 * FreeBoardSearchVO searchVO=new FreeBoardSearchVO();
		 * searchVO.setSearchType("T");
		 * 
		 * String resource = "mybatis/mybatis-config.xml"; InputStream inputStream =
		 * Resources.getResourceAsStream(resource); // 1. mybatis-config.xml 파일 읽죠
		 * SqlSessionFactory sqlSessionFactory = new
		 * SqlSessionFactoryBuilder().build(inputStream);
		 * 
		 * // 2. 읽는 순간에 DB접속하고, mapper파일들을 Sqlsession에 저장 try (SqlSession session =
		 * sqlSessionFactory.openSession()) {
		 * 
		 * IFreeBoardDao freeBoardDao = session.getMapper(IFreeBoardDao.class); //3.
		 * SqlSession으로부터 mapper파일 열기 FreeBoardVO freeBoard = freeBoardDao.getBoard(66);
		 * 
		 * // 4. freeBoardDao.getBoard하는 순간 freeBoard.xml의 쿼리가 실행.(DaoOracle 실행x)
		 * System.out.println(freeBoard); }
		 */
		
		// 이것이 자바다 11.6 Class 클래스
		// 자바 reflection
		
		Class clazz = Class.forName("com.study.free.vo.FreeBoardVO");
		// Class '클래스'는 '클래스'들에 대한 정보를 가지고 있는 '클래스'
		// Class '클래스'타입의 객체 clazz는 FreeBoardVO '클래스'에 대한 정보를 가지고 있다.
		
		// 객체얻기
		// 필드에 대한 정보얻기, 메소드에 대한 정보얻기
		//boNo ~ boDelYn,		toString, getBoNo setBoNo ~~ getBoDelYn setBoDelYn
		
		// 객체얻기
		FreeBoardVO freeBoard=(FreeBoardVO)clazz.newInstance();
		
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("필드 이름: " + field.getName());
			System.out.println("필드 타입: " + field.getType().getTypeName());
		}
		
		System.out.println("-----------------------------");
		
		//메소드
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println("메소드 이름: " + method.getName());
			System.out.println("메소드 리턴 타입: " + method.getReturnType().getTypeName());
			
			if(method.getParameterCount()==1) {
				System.out.println("메소드 파라미터 타입" + method.getParameterTypes()[0].getTypeName());
			}
			System.out.println("-----------------------------");
		}
		
		System.out.println("모든 set메소드는 실행 전 : " + freeBoard);
		// 모든 set 메소드를 한번에 실행시켜 보자.
		for(Method method : methods) {
			if(method.getName().startsWith("set")) {
				if(! method.getParameterTypes()[0].getTypeName().equals("int")) {
					method.invoke(freeBoard, "abc");
				}
			}
		}
		System.out.println("모든 set메소드 실행 후 : " + freeBoard);
		
		
		
		
	}


}
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

public class Main {
	public static void main(String[] args) throws IOException {
		FreeBoardSearchVO searchVO=new FreeBoardSearchVO();
		searchVO.setSearchType("T"); 
	
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1. mybatis-config.xml 파일 읽죠
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 2. 읽는 순간에 DB접속하고, mapper파일들을 Sqlsession에 저장
		try (SqlSession session = sqlSessionFactory.openSession()) {
			
			IFreeBoardDao freeBoardDao = session.getMapper(IFreeBoardDao.class);
			//3. SqlSession으로부터 mapper파일 열기
			FreeBoardVO freeBoard = freeBoardDao.getBoard(66);
			
			// 4. freeBoardDao.getBoard하는 순간 freeBoard.xml의 쿼리가 실행.(DaoOracle 실행x)
			System.out.println(freeBoard);
			}
		
	}


}
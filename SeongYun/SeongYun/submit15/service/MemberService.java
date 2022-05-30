package SeongYun.submit15.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import SeongYun.submit15.dao.MemberDao;
import SeongYun.submit15.jdbc.ConnectionPool2;
import SeongYun.submit15.model.MemberVO;

public class MemberService {

	private MemberDao dao = MemberDao.getInstance();
	private ConnectionPool2 cp = ConnectionPool2.getInstance();

	private static MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}

	private MemberService() {

	}

	// 로그인(SELECT, WHERE)
	public MemberVO loginMem(String id) {
		Connection conn = cp.getConnection();

		try {
			return dao.loginMem(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("오류");
		} finally {
			cp.releaseConnection(conn);
		}

		return new MemberVO();

	}

	// 회원가입(INSERT)
	public int insertMem(MemberVO mem) {
		Connection conn = cp.getConnection();

		try {
			return dao.insertMem(conn, mem);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.releaseConnection(conn);
		}

		return 0;
	}

}
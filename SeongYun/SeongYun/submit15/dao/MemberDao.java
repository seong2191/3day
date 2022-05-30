package SeongYun.submit15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import SeongYun.submit15.model.MemberVO;

public class MemberDao {

	private static MemberDao instance = new MemberDao();

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		return instance;
	}

	// 로그인 (SELECT, WHERE)
	public MemberVO loginMem(Connection conn, String id) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("SELECT						");
		query.append("	  mem_id					");
		query.append("	, mem_password	 			");
		query.append("FROM							");
		query.append("		members					");
		query.append("WHERE 1=1						");
		query.append("	AND mem_id = ?				");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, id);

		ResultSet rs = ps.executeQuery();

		MemberVO result = new MemberVO();

		while (rs.next()) {

			result.setMemId(rs.getString("mem_id"));
			result.setMemPassword(rs.getString("mem_password"));
		}
		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

		return result;
	}

	// 회원가입(INSERT)
	public int insertMem(Connection conn, MemberVO mem) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO		");
		query.append("	  members		");
		query.append("VALUES	(		");
		query.append("		?			");
		query.append("		, ? 		");
		query.append("		)			");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		int idx = 1;
		ps.setString(idx++, mem.getMemId());
		ps.setString(idx++, mem.getMemPassword());

		int cnt = ps.executeUpdate();
		if (ps != null)
			ps.close();

		return cnt;
	}

}

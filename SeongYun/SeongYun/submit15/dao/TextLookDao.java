package SeongYun.submit15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SeongYun.submit15.model.TextLookVO;

public class TextLookDao {

	private static TextLookDao instance = new TextLookDao();

	private TextLookDao() {

	}

	public static TextLookDao getInstance() {
		return instance;
	}

	// 글 조회
	public ArrayList<TextLookVO> getTextList(Connection conn) throws SQLException {

		StringBuffer query = new StringBuffer();
		query.append("SELECT			");
		query.append("	  *				");
		query.append("FROM				");
		query.append("		TextLook	");
		query.append("ORDER BY			");
		query.append(" 1 				");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		// 4. 쿼리문 실행과 동시에 결과를 ResultSet 객체에 담는다.
		ResultSet rs = ps.executeQuery();

		ArrayList<TextLookVO> result = new ArrayList<>();

		// 5. 실행결과인 rs(ResultSet)를 이용하여 데이터 조회
		while (rs.next()) {
			TextLookVO temp = new TextLookVO();

			temp.setNo(rs.getInt("text_no"));
			temp.setTitle(rs.getString("text_title"));
			temp.setContent(rs.getString("text_content"));
			temp.setAuthor(rs.getString("text_author"));
			temp.setTime(rs.getString("text_time"));

			result.add(temp);
		}
		if (ps != null)
			ps.close();
		if (rs != null)
			rs.close();

		return result;
	}

	// 글 저장
	public int insertText(Connection conn, TextLookVO text) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO		");
		query.append("	  textlook		");
		query.append("VALUES	(		");
		query.append("		?			");
		query.append("		, ? 		");
		query.append("		, ? 		");
		query.append("		, ?	 		");
		query.append("		, ?	 		");
		query.append("		)			");

		PreparedStatement ps = conn.prepareStatement(query.toString());

		ResultSet rs = ps.executeQuery();

		int idx = 1;
		ps.setInt(idx++, text.getNo());
		ps.setString(idx++, text.getTitle());
		ps.setString(idx++, text.getContent());
		ps.setString(idx++, text.getAuthor());
		ps.setString(idx++, text.getTime());

		int cnt = ps.executeUpdate();

		if (ps != null)
			ps.close();

		return cnt;
	}

}

package SeongYun.submit15.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import SeongYun.submit15.dao.TextLookDao;
import SeongYun.submit15.jdbc.ConnectionPool2;
import SeongYun.submit15.model.TextLookVO;

public class TextLookService {

	private TextLookDao dao = TextLookDao.getInstance();
	private ConnectionPool2 cp = ConnectionPool2.getInstance();

	private static TextLookService instance = new TextLookService();

	public static TextLookService getInstance() {
		return instance;
	}

	private TextLookService() {

	}

	public ArrayList<TextLookVO> getTextList() {
		Connection conn = cp.getConnection();

		try {
			return dao.getTextList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				cp.releaseConnection(conn);
		}

		return new ArrayList<TextLookVO>();

	}

	public int insertText(TextLookVO text) {
		Connection conn = cp.getConnection();

		try {
			return dao.insertText(conn, text);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				cp.releaseConnection(conn);
		}

		return 0;

	}

}

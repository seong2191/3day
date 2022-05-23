package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 등록 실패");
			System.exit(0); // 프로그램 종료
		}

		String url = "jdbc:oracle:thin:@192.168.0.26:1521:xe";
		String id = "jdbc";
		String pw = "jdbc";

		try {
			conn = DriverManager.getConnection(url, id, pw);
			
			StringBuffer query = new StringBuffer();
			query.append("INSERT INTO		");
			query.append("	  students		");
			query.append("VALUES	(		");
			query.append("		?			");
			query.append("		, ? 		");
			query.append("		, ? 		");
			query.append("		, ?	 		");
			query.append("		)			");
			
			ps = conn.prepareStatement(query.toString());
			
			int idx = 1;
			ps.setString(idx++, "nanana");
			ps.setString(idx++, "나나나");
			ps.setString(idx++, "pw1234");
			ps.setInt(idx++, 0);
			
			
			// insert, delete, update문은
			// ps.executeUpdate() 로 실행
			// 결과는 (ex. x행이 삽입되었습니다.)
			// int 타입으로 업데이트된 행의 개수를 리턴
			// 여기서 int가 x에 해당됨
			
			int cnt = ps.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(cnt + "행이 삽입되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {

				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}

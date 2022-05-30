package SeongYun.submit15.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

// ConnectionFactory로 부터 maxConn만큼
// Connection 객체를 생성해서 풀(pool)에 보관하는 클래스
public class ConnectionPool2 {
	// Vector는 동기화(Synchronized)가 적용된 ArrayList다.
	private static Vector<Connection> pool = new Vector<>();
	private static ConnectionPool2 instance = new ConnectionPool2();

	public static ConnectionPool2 getInstance() {
		return instance;
	}

	private ConnectionPool2() {
		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private synchronized void initPool() throws SQLException {
		destroyPool();
		ConnectionFactory2 factory = ConnectionFactory2.getInstance();
		int maxConn = factory.getmaxConn();

		for (int i = 0; i < maxConn; i++) {
			pool.add(factory.getConnection());
		}
	}

	private synchronized void destroyPool() throws SQLException {
		// Connection 객체 다 닫아주기
		for (int i = 0; i < pool.size(); i++) {
			pool.get(i).close();
		}
		// pool 비우기
		pool.clear();
	}

	public synchronized Connection getConnection() {
		if (pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}

	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}

}
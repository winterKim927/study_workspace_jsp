package notice.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//외부 자원을 이름으로 접근하는 JNDI 기술을 이용하여 톰캣의 Connection Pool을 가져오자
public class PoolManager {
	private static PoolManager instance;
	InitialContext context; //JNDI 검색객체
	DataSource ds; //커넥션풀 구현체
	
	private PoolManager() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void release(Connection con) {
		try {
			if(con!=null) {				
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void release(Connection con, PreparedStatement pstmt) {
		if (pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		release(con);
	}
	
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		release(con, pstmt);
	}
	
	public static PoolManager getInstance() {
		if(instance==null) {
			instance = new PoolManager();
		}
		return instance;
	}
}

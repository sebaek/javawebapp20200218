package app.repository;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;

public class DBCP {
	private static PoolDataSource poolDataSource;

	public static void setConnectionPool(PoolDataSource pds) {
		poolDataSource = pds;
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = poolDataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	

}

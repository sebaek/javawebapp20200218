package app.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.repository.DBCP;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public AppListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// set request character encoding to utf-8
		ServletContext application = sce.getServletContext();
		application.setRequestCharacterEncoding("utf-8");

		// real db connection
		createDBCP();
	}

	private void createDBCP() {
//		CREATE USER c##myappdb IDENTIFIED BY admin;
//		GRANT CONNECT, RESOURCE, DBA TO c##myappdb;
		try {
			// Create pool-enabled data source instance.

			PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();

			// set the connection properties on the data source.

			pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
			pds.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
			pds.setUser("c##myappdb");
			pds.setPassword("admin");

			// Override any pool properties.

			pds.setInitialPoolSize(5);

			// Get a database connection from the datasource.

			Connection conn = pds.getConnection();

			System.out.println("\nConnection obtained from " + "UniversalConnectionPool\n");

			// do some work with the connection.
			Statement stmt = conn.createStatement();
			stmt.execute("select * from dual");

			// Close the Connection.

			conn.close();
			conn = null;

			System.out.println("Connection returned to the " + "UniversalConnectionPool\n");

			DBCP.setConnectionPool(pds);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BasicConnectionExample - " + "main()-SQLException occurred : " + e.getMessage());
		}

	}

}

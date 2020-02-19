package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardRepo {

	public boolean addBoard(String title, String body, String memberId) {
		String sql = "INSERT INTO board "
				+ "(title, body, memberid) "
				+ "VALUES (?, ?, ?) ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, title);
			stmt.setString(2, body);
			stmt.setString(3, memberId);
			
			int cnt = stmt.executeUpdate();
			
			if (cnt != 1) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

}

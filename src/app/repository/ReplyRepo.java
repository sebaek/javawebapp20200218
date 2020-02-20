package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.bean.Reply;

public class ReplyRepo {

	public boolean addReply(Reply reply) {
		String sql = "INSERT INTO reply "
				+ "(body, memberid, boardId) "
				+ "VALUES (?, ?, ?) ";
		
		try (
				Connection con = DBCP.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)
		) {
			stmt.setString(1, reply.getBody());
			stmt.setString(2, reply.getMemberId());
			stmt.setLong(3, reply.getBoardId());
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

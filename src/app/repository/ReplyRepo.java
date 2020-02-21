package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public List<Reply> listReply(String id) {
		List<Reply> list = new ArrayList<>();
		
		String sql = "SELECT id, body, memberid, "
				+ "          boardid, inserted "
				+ "   FROM reply"
				+ "   WHERE boardid=?"
				+ "   ORDER BY id DESC";
		
		try (
				Connection con = DBCP.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setLong(1, Long.valueOf(id));
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Reply r = new Reply();
				r.setId(rs.getLong(1));
				r.setBody(rs.getString(2));
				r.setMemberId(rs.getString(3));
				r.setBoardId(rs.getLong(4));
				r.setInserted(rs.getDate(5));
				
				list.add(r);
			}
			
		} catch (Exception e) {
			
		}
		
		
		return list;
	}

	public void deleteReply(String replyId, String memberId) {
		String sql = "DELETE FROM reply "
				+ "WHERE id=? "
				+ "AND memberid=? ";
		try (
				Connection con = DBCP.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql)
		) {
			stmt.setLong(1, Long.valueOf(replyId));
			stmt.setString(2, memberId);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateReply(String replyId, String memberId, String body) {
		String sql = "UPDATE reply "
				+ "SET body=? "
				+ "WHERE id=? "
				+ "  AND memberid=? ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql)
		) {
			stmt.setString(1, body);
			stmt.setLong(2, Long.valueOf(replyId));
			stmt.setString(3, memberId);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}














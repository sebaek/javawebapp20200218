package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.bean.Member;

public class MemberRepo {
	
	public boolean addMember(Member member) {
		String sql = "INSERT INTO member (memberid, password) "
				+ "VALUES (?, ?) ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());
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

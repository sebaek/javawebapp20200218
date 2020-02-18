package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public Member getMember(String id, String pw) {
		Member member = null;
		String sql = "SELECT memberid, password "
				+ "FROM member "
				+ "WHERE memberid=? "
				+ "AND password=? ";

		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareCall(sql)) {
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				member = new Member();
				member.setMemberId(id);
				member.setPassword(pw);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
}











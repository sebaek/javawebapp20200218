package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.bean.Member;

public class MemberRepo {
	
	public boolean addMember(Member member) {
		String sql = "INSERT INTO member "
				+ "(memberid, password, email, nickname) "
				+ "VALUES (?, ?, ?, ?) ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getPassword());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getNickName());
			
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
		String sql = "SELECT "
				+ "memberid, password, email, nickname "
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
				member.setEmail(rs.getString(3));
				member.setNickName(rs.getString(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	public void modifyMember(Member member) {
		String sql = "UPDATE member "
				+ "SET password=? "
				+ "  , email=? "
				+ "  , nickname=? "
				+ "WHERE memberid=? ";
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, member.getPassword());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getNickName());
			stmt.setString(4, member.getMemberId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public boolean deleteMember(String id, String pw) {
		String sql = "DELETE FROM member "
				+ "WHERE memberid=? "
				+ "  AND password=? ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
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











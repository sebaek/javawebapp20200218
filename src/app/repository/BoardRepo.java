package app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.bean.Board;

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

	public List<Board> listBoard() {
		String sql = "SELECT id, title,"
				+ "          body, memberid, inserted "
				+ "   FROM board "
				+ "   ORDER BY id DESC ";
		List<Board> list = new ArrayList<>();
		
		try (
				Connection con = DBCP.getConnection();
				Statement stmt = con.createStatement();
		) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getLong(1));
				board.setTitle(rs.getString(2));
				board.setBody(rs.getString(3));
				board.setMemberId(rs.getString(4));
				board.setInserted(rs.getDate(5));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return list;
	}

	public Board getBoardById(String id) {
		Board board = null;
		String sql = "SELECT title, body, memberid, inserted "
				+ "FROM board "
				+ "WHERE id=?";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setLong(1, Long.valueOf(id));
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				board = new Board();
				board.setId(Long.valueOf(id));
				board.setTitle(rs.getString(1));
				board.setBody(rs.getString(2));
				board.setMemberId(rs.getString(3));
				board.setInserted(rs.getDate(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return board;
	}

	public boolean deleteBoard(String id, String memberId, String password) {
		String sql = "DELETE FROM board "
				+ "WHERE id=? "
				+ "AND memberid= (SELECT memberid "
				+ "               FROM member "
				+ "               WHERE memberid=? "
				+ "               AND   password=? )";
		
		try (
				Connection con = DBCP.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setLong(1, Long.valueOf(id));
			stmt.setString(2, memberId);
			stmt.setString(3, password);
			
			int cnt = stmt.executeUpdate();
			
			if (cnt < 1) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

}










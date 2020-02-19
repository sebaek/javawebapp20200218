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

}










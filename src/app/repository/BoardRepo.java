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
		String sql = "SELECT "
				+ "title, body, memberid, inserted, fileName "
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
				board.setFileName(rs.getString(5));
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

	public boolean updateBoard(Board board) {
		String sql = "UPDATE board "
				+ "SET title=?, "
				+ "    body=? "
				+ "WHERE id=?"
				+ "  AND memberid=? ";

		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getBody());
			stmt.setLong(3, board.getId());
			stmt.setString(4, board.getMemberId());
			
			int cnt = stmt.executeUpdate();
			
			if (cnt < 1) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public void addBoard(Board board) {
		String sql = "INSERT INTO board "
				+ "(title, body, memberId, fileName) "
				+ "VALUES (?, ?, ?, ?) ";
		
		try (
			Connection con = DBCP.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql, new String[] {"ID", "INSERTED"})
		) {
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getBody());
			stmt.setString(3, board.getMemberId());
			stmt.setString(4, board.getFileName());
			int cnt = stmt.executeUpdate();
			
			if (cnt == 1) {
				ResultSet gen = stmt.getGeneratedKeys();
				gen.next();
				board.setId(gen.getLong(1));
				board.setInserted(gen.getDate(2));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Board> listBoard(String page) {
		List<Board> list = new ArrayList<>();
		
		String sql = "SELECT id, title, body, inserted, "
				+ "          memberId, fileName "
				+ "   FROM ("
				+ "          SELECT row_number() OVER "
				+ "                  (ORDER BY id DESC) rn, "
				+ "                 id, title, body, inserted, "
				+ "                 memberId, fileName "
				+ "          FROM board "
				+ "         ) "
				+ "   WHERE rn BETWEEN ? AND ? ";
		
		try (
				Connection con = DBCP.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
		) {
			stmt.setInt(1, (Integer.valueOf(page) - 1) * 5 + 1);
			stmt.setInt(2, (Integer.valueOf(page)) * 5);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				b.setId(rs.getLong(1));
				b.setTitle(rs.getString(2));
				b.setBody(rs.getString(3));
				b.setInserted(rs.getDate(4));
				b.setMemberId(rs.getString(5));
				b.setFileName(rs.getString(6));
				
				list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
















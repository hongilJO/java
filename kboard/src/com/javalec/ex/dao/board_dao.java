package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.javalec.ex.dto.board;

public class board_dao {
	public static final int UPDATE_BOARD = 1;
	public static final int NOT_UPDATE_BOARD = 0;

	public board_dao() {
		try {
			Class.forName(config.getConfig().getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<board> get_boardlist() {
		ArrayList<board> list = new ArrayList<board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mvc_board order by bGroup desc, bStep asc";
			conn = DriverManager.getConnection(config.getConfig().getProperty("url"));
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				board b = new board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(b);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public board get_board(int bid) {
		board b = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from mvc_board where bId=?";
			conn = DriverManager.getConnection(config.getConfig().getProperty("url"));
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				b = new board(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	public int insert_board(String btitle, String bname, String bcontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String sql = "insert into mvc_board (bName,bTitle,bContent,bGroup,bStep,bIndent) values (?,?,?,?,?,?)";
			conn = DriverManager.getConnection(config.getConfig().getProperty("url"));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);

			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i == UPDATE_BOARD) {
			System.out.println("업데이트가 완료되었습니다.");
		}
		return i;
	}

	public void update_board(int bid, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String sql = "update mvc_board set bTitle=?,bContent=? where bId=?";
			conn = DriverManager.getConnection(config.getConfig().getProperty("url"));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, btitle);
			pstmt.setString(2, bcontent);
			pstmt.setInt(3, bid);
			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i == UPDATE_BOARD) {
			System.out.println("업데이트가 완료되었습니다.");
		}
	}

	public void delete_board(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			String sql = "delete from mvc_board where bId=?";
			conn = DriverManager.getConnection(config.getConfig().getProperty("url"));
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (i == UPDATE_BOARD) {
			System.out.println("업데이트가 완료되었습니다.");
		}
	
	}
}

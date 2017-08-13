package com.springbook.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


//@Repository("boardDao")
public class BoardDAO {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String board_insert = "insert into board (seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String board_update = "update board set title=?, content=? where seq=?";
	private final String board_delete = "delete board where seq=?";
	private final String board_get = "select * from board where seq=?";
	private final String board_list = "select * from board order by seq desc";

	public void insertBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_insert);
			stmt.setString(1, dto.getTitle());
			stmt.setString(2, dto.getWriter());
			stmt.setString(3, dto.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
	}

	public void updateBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 updateBoard() 기능 처리");

		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_update);
			stmt.setString(1, dto.getTitle());
			stmt.setString(2, dto.getContent());
			stmt.setInt(3, dto.getSeq());
			stmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			JDBCUtill.close(stmt, conn);
		}
	}

	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_delete);
			stmt.setInt(1,dto.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(stmt, conn);
		}
	}

	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 getBoard() 기능 처리");
		BoardDTO board = null;
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_get);
			stmt.setInt(1, dto.getSeq());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				board = new BoardDTO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtill.close(rs, stmt, conn);
		}
		return board;
	}
	public List<BoardDTO> getBoardList(BoardDTO dto){
		System.out.println("==> jdbc로 getBoardList() 기능 처리");
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		try{
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_list);
			rs = stmt.executeQuery();
			while(rs.next()){
				BoardDTO board = new BoardDTO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardlist.add(board);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtill.close(rs, stmt, conn);
		}
		return boardlist;
	}

}

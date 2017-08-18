package com.springbook.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository("boardDao")
public class BoardDAO_JdbcTemplate extends JdbcDaoSupport {
	/*
	@Autowired
    private JdbcTemplate jt;
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
    */
	
	//JdbcTemplate를 이용하여 JdbcDaoSupport 클래스 상속하여 dao 클래스 구현 
	
	//JdbcTemplate를 직접 xml 파일에 설정 후 autowired하여 변수에 할당하고 dao 클래스 구현 
	
	private final String board_insert = "insert into board (seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	//private final String board_insert = "insert into board (seq, title, writer, content) values(?,?,?,?)";
	private final String board_update = "update board set title=?, content=?, where seq=?";
	private final String board_delete = "delete board where seq=?";
	private final String board_get = "select * from board where seq=?";
	//private final String board_list = "select * from board order by seq desc";
	private final String board_list_t = "select * from board where title like '%'||?||'%' order by seq desc";
	private final String board_list_c = "select * from board where content like '%'||?||'%' order by seq desc";
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}
	
	public void insertBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 insertBoard() 기능 처리");
		/*
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
		*/
		getJdbcTemplate().update(board_insert, dto.getTitle(), dto.getWriter(), dto.getContent());
		//getJdbcTemplate().update(board_insert, dto.getSeq(), dto.getTitle(), dto.getWriter(), dto.getContent());
	}

	public void updateBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 updateBoard() 기능 처리");
		/*
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
		*/
		getJdbcTemplate().update(board_update,dto.getTitle(),dto.getContent(),dto.getSeq());
	}

	public void deleteBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 deleteBoard() 기능 처리");
		/*
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
		*/
		getJdbcTemplate().update(board_delete,dto.getSeq());
	}

	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("==> jdbc로 getBoard() 기능 처리");
		/*
		BoardDTO board = null;
		try {
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_get);
			stmt.setInt(1, dto.getSeq());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				board = new BoardDTO();
				board.setCnt(rs.getInt("seq"));
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
		*/
		Object[] args = {dto.getSeq()};
		return getJdbcTemplate().queryForObject(board_get, args, new BoardRowMapper());
	}
	public List<BoardDTO> getBoardList(BoardDTO dto){
		System.out.println("==> jdbc로 getBoardList() 기능 처리");
	
		/*
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		
		try{
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement(board_list);
			rs = stmt.executeQuery();
			while(rs.next()){
				BoardDTO board = new BoardDTO();
				board.setCnt(rs.getInt("seq"));
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
		*/
		Object[] args = {dto.getSearchKeyword()};
		if( dto.getSearchCondition().equals("TITLE")) {
			return getJdbcTemplate().query(board_list_t, args, new BoardRowMapper());
		}else {
			return getJdbcTemplate().query(board_list_c, args, new BoardRowMapper());
		}
	}

}

class BoardRowMapper implements RowMapper<BoardDTO>{
	
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardDTO board = new BoardDTO();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString("title"));
		board.setWriter(rs.getString("writer"));
		board.setContent(rs.getString("content"));
		board.setRegDate(rs.getDate("regdate"));
		board.setCnt(rs.getInt("cnt"));
		
		return board;
	}
}


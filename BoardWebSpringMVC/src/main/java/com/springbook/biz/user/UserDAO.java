package com.springbook.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.JDBCUtill;

@Repository("dao")
public class UserDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	private final String USER_GET = "select * from users where id=? and password=?";

	public UserDTO getUser(UserDTO dto){
		
		UserDTO user = null;
		
		System.out.println("==> JDBC로 getUser 유저를 찾아요");
		try{
		conn = JDBCUtill.getConnection();
		stmt = conn.prepareStatement(USER_GET);
		stmt.setString(1, dto.getId());
		stmt.setString(2, dto.getPassword());
		rs = stmt.executeQuery();
		
		while(rs.next()){
			user = new UserDTO();
			user.setId(rs.getString("ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setName(rs.getString("NAME"));
			user.setRole(rs.getString("ROLE"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtill.close(rs, stmt, conn);
		}
		return user;
	}
}

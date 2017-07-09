package auth_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dao {

	ArrayList<dto> li = new ArrayList<dto>();
	config conf = new config();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	static private dao obj = new dao();
	private dao() {
		try {
			Class.forName(conf.get_property("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static dao getInstance(){
		return obj;
	}

	public int member_apply(dto member) {

		try {
			conn = DriverManager.getConnection(conf.get_property("url"), conf.get_property("mysql_id"),
					conf.get_property("mysql_pwd"));
			String sql = "insert into login (id,pwd,username,address) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getUsername());
			pstmt.setString(4, member.getAddress());
		
			int i = pstmt.executeUpdate();

			if (i == 1) {
				return i;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public boolean member_update(dto member) {
		try {
			conn = DriverManager.getConnection(conf.get_property("url"), conf.get_property("mysql_id"),
					conf.get_property("mysql_pwd"));

			String sql = "update login set pwd=?, username=?, address=? where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getUsername());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getId());
			int i = pstmt.executeUpdate();

			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean member_check(String id, String pwd) {
		try {

			String sql = "select * from login where id=? and pwd=?";
			conn = DriverManager.getConnection(conf.get_property("url"), conf.get_property("mysql_id"),
					conf.get_property("mysql_pwd"));
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rs.close();
				pstmt.close();
				conn.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public dto member_get(String id, String pwd) {

		dto member = null;
		try {

			String sql = "select * from login where id=? and pwd=?";
			conn = DriverManager.getConnection(conf.get_property("url"), conf.get_property("mysql_id"),
					conf.get_property("mysql_pwd"));
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				member = new dto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}

}

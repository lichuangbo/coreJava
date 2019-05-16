/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月13日
 */
package QQ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类, 封装有关数据库操作的方法
 * @author 李创博
 * @version: 1.0
 */
public class JDBCutil {
	private static String user;
	private static String pwd;
	private static String url;
	private static String driver;
	
	//加载数据库配置文件
	static {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("C:\\EclipseWorkspace\\CoreJava\\src\\QQ\\database.txt");
			br = new BufferedReader(fr);
			driver = br.readLine();
			url = br.readLine();
			user = br.readLine();
			pwd = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}	
	}	
	
	/**
	 * 连接数据库操作
	 * @return 数据库连接对象
	 * @throws SQLException
	 * @return: Connection
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}
	
	/**
	 * 释放打开的资源
	 * @param conn Connection
	 * @param st Statement
	 * @return: void
	 */
	public static void close(Connection conn, Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 释放打开的资源
	 * @param conn Connection
	 * @param st Statement
	 * @param rs ResultSet
	 * @return: void
	 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		close(conn, st);
	}
	
	/**
	 * 输入的用户名和密码是否正确
	 * @param user 用户名
	 * @param pass 密码
	 * @return 正确(true)/错误(false) 
	 * @return: boolean
	 */
	public static boolean isSearched(String user, String pass) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isSearched = false;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM qquser WHERE uname = ? AND passwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				isSearched = true;
			} else {
				isSearched = false;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			close(conn, ps, rs);
		}
		return isSearched;
	}
	
	/**
	 * 用户名是否存在
	 * @param user 用户名
	 * @return 存在(true)/不存在(false)
	 * @return: boolean
	 */
	public static boolean isSearched(String user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isSearched = false;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM qquser WHERE uname = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			if (rs.next()) {
				isSearched = true;
			} else {
				isSearched = false;
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			close(conn, ps, rs);
		}
		return isSearched;
	}
	
	/**
	 * 用户注册
	 * @param user 用户名
	 * @param pass 密码
	 * @return 插入成功(true)/插入失败(false)
	 * @return: boolean
	 */
	public static boolean isInsert(String user, String pass) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean isInsert = false;
		try {
			conn = getConnection();
			String sql2 = "INSERT INTO qquser VALUES('" + user + "', '" + pass + "')";
			st = conn.createStatement();
			int count = st.executeUpdate(sql2);
			if (count == 1) {
				isInsert = true;
			} else {
				isInsert = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, st, rs);
		}
		return isInsert;
	}
}

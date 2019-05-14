/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月13日
 */
package cn.edu.tit.corejava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * JDBC工具类
 * @author 李创博
 * @version: 1.0
 */
public class JDBCutil {
	//定义常量user,password,url,driver
	private static final String USER = "root";
	private static final String PWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	static {
		try {
			Class.forName(DRIVER);
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
		return DriverManager.getConnection(URL, USER, PWD);
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
}

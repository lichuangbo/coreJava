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
import java.util.Scanner;

/**
 * 在数据库中查找数据(DQL),解决SQL注入问题
 * @author 李创博
 * @version: 1.2
 */
public class ExecuteDQL {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);         
		  System.out.println("请输入学生名：");         
		  String name = sc.nextLine();         
		  System.out.println("请输入性别：");         
		  String sex = sc.nextLine();  
		  queryStudentData(name, sex);
	}
	
	//使用PreparedStatement解决SQL注入
	public static void queryStudentData(String name, String sex) {
		/**
		 * PreparedStatement时Statement接口的子接口
		 * 		1.它会先将SQL语句发送给数据库进行预编译，对于相似的操作语句，他只需要预编译一次，减少编译次数
		 * 		2.安全性高，没有SQL注入风险
		 * 		3.没有SQL字符串拼接，可读性好
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			st = conn.createStatement();
			/**
			 * 使用PreparedStatement接口时
			 * 	  1.SQL中未知内容使用?代替
			 * 	  2.在获取PreparedStatement对象时即传入SQL(预编译过程)
			 * 	  3.使用setString( , )给?设置具体的值
			 * 	  4.接着使用ResultSet接收查询结果
			 */
			String sql = "SELECT * FROM student WHERE name = ? and sex = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, sex);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("学生存在");
			}else {
				System.out.println("您查找的学生不存在！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
	}
}

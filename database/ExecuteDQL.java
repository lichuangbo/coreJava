/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月13日
 */
package cn.edu.tit.corejava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

/**
 * 在数据库中查找数据(DQL)
 * @author 李创博
 * @version: 1.1
 */
public class ExecuteDQL {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);         
		  System.out.println("请输入学生名：");         
		  String name = sc.nextLine();         
		  System.out.println("请输入性别：");         
		  String sex = sc.nextLine();  
//		  queryStudentData(name, sex);//正常输入：小华， 女
		  
		  /**
		   * SQL注入: 用户输入的内容改变了原有SQL的用意
		   * 	所以不可以让用户输入的和SQL语句进行简单的字符串拼接**
		   * 解决方案：
		   * 	使用PreParedStatement接口，它采用预编译的方法保证了安全性并且提高了一定的效率
		   */
		  queryStudentData(name, sex);//非法输入：小华, 女' or '1'='1
	}
	
	public static void queryStudentData(String name, String sex) {
		/**
		 * ResultSet接口：
		 * 		封装数据库查询的结果集，对结果集进行遍历，取出每一条记录
		 * 	boolean next();指针每次向下移动一行
		 * 		判断当前指向的记录是否有下一条记录，有返回true,否则false
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, "root", "root");
			st = conn.createStatement();
			String sql = "SELECT * FROM student WHERE name = '" + name
					+ "' AND sex = '" + sex + "'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				//利用ResultSet的get方法(列名/列号)获得表中属性值
				int id = rs.getInt("id");
				String n = rs.getString(2);
				String s = rs.getString("sex");
				Date birthday = rs.getDate("birthday");
				System.out.println(id + n + s + birthday);
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

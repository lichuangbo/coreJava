/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月13日
 */
package cn.edu.tit.corejava.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 在数据库中添加、删除和修改数据(DML操作)
 * @author 李创博
 * @version: 1.1
 */
public class ExecuteDML {
	//往数据库中添加数据
	public static void insertData() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCutil.getConnection();
			st = conn.createStatement();
			String sql = "INSERT INTO student VALUES(104, '小华', '男',  '1992-07-18')";
			int count = st.executeUpdate(sql);
			System.out.println("插入成功：插入" + count + "条记录!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, st);
		}
	}
	
	//删除数据库中数据
	public static void deleteData() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCutil.getConnection();
			st = conn.createStatement();
			String sql = "DELETE FROM student WHERE sex = '女'";
			int count = st.executeUpdate(sql);
			System.out.println("删除成功：删除" + count + "条记录!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, st);
		}
	}
	
	//演示更新数据库中数据
	public static void updateData() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCutil.getConnection();
			st = conn.createStatement();
			String sql = "UPDATE student SET sex = '女' WHERE name = '小华'";
			int count = st.executeUpdate(sql);
			System.out.println("修改成功：修改" + count + "条记录!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(conn, st);
		}
	}
	
	public static void main(String[] args) {
		//DML-insert
//		insertData();
		
		//DML-delete
		deleteData();
		
		//DML-update
//		updateData();
	}
}

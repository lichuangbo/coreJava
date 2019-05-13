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
 * @author 李创博
 * @version: 1.0
 */
public class ConnectDB {
	public static void main(String[] args) {
		/**
		 * JDBC(Java DataBase Connectivity):Java数据库连接
		 * 		是Java访问数据库的标准规范，是官方定义的一套操作所有关系型数据库的接口。
		 * 		各个数据厂商实现此接口(编写自己数据库的驱动)，并将实现类和一些方法打包供程序员使用。
		 * 好处：
		 * 	1.在开发访问数据库程序时，只需调用JDBC接口中的方法，不用关注类怎么实现。
		 * 	2.程序员使用同一套Java代码，少量修改就可以访问其他数据库
		 * CRUD操作：
		 * 	C(Create):创建
		 *	R(Retrive):查询
		 *	U(Update):更新
		 *  D(Delete):删除
		 * DriverManager:驱动管理类
		 *	1.注册驱动
		 *		static void registerDriver(Driver driver)
		 *		Class.forName("com.mysql.jdbc.Driver");-->实际使用这个
		 *		在com.mysql.jdbc.Driver类中使用上边的静态方法注册驱动
		 *	注意：MySQL jar包5之后可以不注册驱动
		 *	2.获取数据库连接
		 *		static Connection getConnection(String url, String  user, String  passworld)
		 *		url：jdbc:mysql://'ip地址':3306/'数据库名称'
		 * Connection:数据库连接接口
		 *	获取执行sql的对象
		 *		1.Statement createStatement() 创建Statement对象，将SQL语句发送到数据库
		 *		2.PreparedStatement preparedStatement(String sql)
		 * Statement:执行SQL的静态接口
		 *		1.执行sql：boolean execute(String sql)
		 *		2.int executeUpdate(String sql):执行DML√，DDL语句
		 *		返回值：影响的记录行数
		 *		3.ResultSet executeQuery(String sql):执行DQL语句,返回结果集
		 */
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			String url = "jdbc:mysql://127.0.0.1:3306/test";
			Connection conn = DriverManager.getConnection(url, "root", "root");
			Statement st = conn.createStatement();
			st.executeUpdate("create table student1 (id int PRIMARY key auto_increment, " +   
			"name varchar(20) not null, gender boolean, birthday date)"); 
			System.out.println("建表成功！");//执行建表语句返回0
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}

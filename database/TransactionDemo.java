/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月14日
 */
package cn.edu.tit.corejava.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 实现从一账户向另一账户转账操作
 * @author 李创博
 * @version: 1.0
 */
public class TransactionDemo {
	public static void main(String[] args) {
		/**
		 * Connection接口拥有事务管理操作：
		 * 	1.开启事务：setAutoCommit(boolean autoCommit):false手动提交，即开启事务
	     * 	2.提交事务：commit()
	     * 	3.回滚事务：rollback()
	     * 注意：
	     * 	Lock wait timeout exceeded; try restarting transaction
	     * 	锁定时间太小
	     * 	使用命令修改：mysql> set innodb_lock_wait_timeout=100
	     * 	查看：show variables like 'innodb_lock_wait_timeout';
		 */
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCutil.getConnection();
			//在可能出现异常的地方开启事务
			conn.setAutoCommit(false);
			//在Jack账户中减去200
			String sql = "UPDATE account SET balance = balance - ? WHERE name = ?";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, 200);
			ps.setString(2, "Jack");
			ps.executeUpdate();
			
//			System.out.println(1 / 0);//设置异常
			
			//在Rose账户中添加200
			String sql2 = "UPDATE account SET balance = balance + ? WHERE name = ?";
			ps = conn.prepareStatement(sql2);
			ps.setDouble(1, 200);
			ps.setString(2, "Rose");
			ps.executeUpdate();
			//提交事务
			conn.commit();
			System.out.println("转账成功！");
		} catch (Exception e) {
			System.out.println(e);
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}          
			System.out.println("转账失败"); 
		} finally {
			JDBCutil.close(conn, ps);
		}
	}
}

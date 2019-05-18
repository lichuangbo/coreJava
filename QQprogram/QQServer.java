/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月18日
 */
package QQ;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 李创博
 * @version: 1.0
 */
public class QQServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8001);
			Socket s = ss.accept();
			NetUtil nu = new NetUtil(s);
			
			String uandp = nu.get();
			//使用try-catch语句处理密码为空情况
			String type = "";
			String uname = "";
			String pass = "";
			try {
				type = uandp.split(",")[0];
				uname = uandp.split(",")[1];
				pass = uandp.split(",")[2];		
			} catch (Exception e) {}
			
			/*
			 * 如果是登录，检查用户名密码是否存在，存在发送ok；
			 * 否则(即注册)，先检查用户名是否存在，存在发送0；不存在且插入数据库成功发送1
			 */
			if (type.equals("登录") && JDBCutil.isSearched(uname, pass)) {
				nu.post("ok");
			} else {
				if (JDBCutil.isSearched(uname)) {
					nu.post("error");
				} else if(JDBCutil.isInsert(uname, pass)){
					nu.post("ok");
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

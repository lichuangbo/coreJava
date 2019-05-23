/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月18日
 */
package QQ;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * 服务器端
 * @author 李创博
 * @version: 1.1
 */
public class QQServer {
	/**
	 * 实现用户之间的通信：
	 * 		每一个用户登录都开启一个线程，对应着一个socket，
	 * 		客户端的消息先转发到服务器端，再由所在线程转发到目标用户的socket上
	 */
	static HashMap<String, Socket> hm = new HashMap<>();
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8001);			
			while(true) {
				Socket s = ss.accept();
				//使用Lambda表达式开启多个线程，满足多人同时登录注册
				new Thread(()-> {
						loginOrRegin(s);
					}
				).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 服务器端检验登录注册
	 * @param s
	 * @return: void
	 */
	public static void loginOrRegin(Socket s){
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
		 * 否则(即注册)，先检查用户名是否存在，存在发送error；不存在且插入数据库成功发送ok
		 */
		if (type.equals("登录")) {
			if(JDBCutil.isSearched(uname, pass)) {
				nu.post("ok");				
				//将本人的名字发送给其他用户
				for (Socket ts : hm.values()) {
					NetUtil nuList = new NetUtil(ts);
					nuList.post("add%" + uname);
				}
				//将其他用户名字发送给自己
				for (String tu : hm.keySet()) {
					nu.post("add%" + tu);
				}
				//一旦用户登录，就将用户名和对应socket存入集合中
				hm.put(uname, s);
				while(true) {
					String mess = nu.get();
					if (mess.equals("{exit}")) {
						hm.remove(uname);
						for (Socket ts : hm.values()) {
							NetUtil nuList = new NetUtil(ts);
							nuList.post("exit%" + uname);
						}
						return;
					} else {
						System.out.println(mess);
					}
				}
			}
		} else {
			if (JDBCutil.isSearched(uname)) {
				nu.post("error");
			} else if(JDBCutil.isInsert(uname, pass)){
				nu.post("ok");
			}
		} 
	}
}

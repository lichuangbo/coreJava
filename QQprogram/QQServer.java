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
 * @version: 1.2
 */
public class QQServer {
	/**
	 * 实现用户之间的通信：
	 * 		每一个用户登录都开启一个线程，对应着一个socket
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
		 * 如果是登录，检查用户名密码是否存在，存在发送ok，否则发送error；
		 * 否则(即注册)，先检查用户名是否存在，存在发送error；不存在且插入数据库成功发送ok
		 */
		if (type.equals("登录")) {
			if(JDBCutil.isSearched(uname, pass)) {
				nu.post("ok");	
				
				//每一个socket都将此用户添加到好友列表中，通知所有用户上线
				for (Socket ts : hm.values()) {
					NetUtil nuList = new NetUtil(ts);
					nuList.post("add%" + uname);
				}
				//当前用户添加所有socket用户
				for (String tu : hm.keySet()) {
					nu.post("add%" + tu);
				}
				
				//一旦当前用户成功登录，就将用户名和对应socket存入集合中
				hm.put(uname, s);
				
				//监听当前QQMain客户端发送的消息(下线通知 / 消息)
				while(true) {
					String mess = nu.get();
					if (mess.equals("{exit}")) {//用户下线，清除集合元素，通知所有用户下线
						hm.remove(uname);
						for (Socket ts : hm.values()) {
							NetUtil nuList = new NetUtil(ts);
							nuList.post("exit%" + uname);
						}
						return;
					} else {//给指定用户发送消息
						String toUser = mess.split("%")[0];
						String message = mess.split("%")[1];
						Socket ts = hm.get(toUser);
						NetUtil nuTo = new NetUtil(ts);
						nuTo.post("mess%" + message);
					}
				}
			} else {
				nu.post("error");
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

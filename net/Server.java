/**
 * CopyRight 2019/4/14
 */
package cn.edu.tit.corejava.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.css.PseudoClass;

/**模拟服务器端向客户端回复请求
 * @author 李创博
 * @version 1.0
 */
public class Server {

	/**TCP通信的服务器端
	 * 使用ServerSocket类
	 * 构造方法：
	 * 		public ServerSocket(int port)
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1.创建服务器对象ServerSocket绑定指定的端口号
		ServerSocket ss = new ServerSocket(8000);
		//2.使用ServerSocket对象中的方法accept(),获取到请求的客户端对象Socket
		System.out.println("服务器正在监听8000端口...");
		Socket socket = ss.accept();
		//3.读入客户端发送的数据
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		//4.向客户端回复数据
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw, true);
		pw.println("嗯，你说...");
		//5.释放资源
		ss.close();
		socket.close();	
	}

}

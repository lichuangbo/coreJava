/**
 * CopyRight: 2019/4/14
 */
package cn.edu.tit.corejava.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**模拟客户端接收服务器端返回的数据
 * @author 李创博
 * @version 1.0
 */
public class Client {

	/**TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回复数据
	 * 使用Socket类
	 * 构造方法：
	 * 		public Socket(String host,int port)
	 * 
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		//1.创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
		Socket socket = new Socket("127.0.0.1", 8000);
		//2.使用Socket对象中的getOutputStream()获取网络字节输出流OutputStream对象
		OutputStream os = socket.getOutputStream();
		//3.向服务器发送请求
		OutputStreamWriter osw = new OutputStreamWriter(os);
		//使用PrintWriter代替BufferedWriter，前者功能更全，在后者的基础上对输出格式做了一定的处理
		//PrintWriter是带有缓冲区的写操作，需要刷新或者关闭，自动刷新true
		PrintWriter pw = new PrintWriter(osw, true);
		pw.println("你好，小爱同学...");
		//4.接受服务器回复
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		//4.释放资源
		socket.close();
	}

}

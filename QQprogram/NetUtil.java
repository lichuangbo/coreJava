/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月18日
 */
package QQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Socket信息交互工具类
 * @author 李创博
 * @version: 1.0
 */
public class NetUtil {
	private PrintWriter pw;
	private BufferedReader br;
	
	/**
	 * 构造方法初始化参数
	 * @param s
	 */
	public NetUtil(Socket s) {
		try {
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向socket连接中发送字符流
	 * @param str 要发送的字符串
	 * @return: void
	 */
	public void post(String str) {
		pw.println(str);
	}
	
	/**
	 * 在socket连接中获取字符流
	 * @return 得到的字符串
	 * @return: String
	 */
	public String get() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

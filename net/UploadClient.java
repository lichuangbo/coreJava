/**
 * CopyRight 2019/4/16
 */
package cn.edu.tit.corejava.socket;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * @author 李创博
 * @version 1.2
 */
public class UploadClient {

	/**文件上传的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
	 * 文件类型是文本类型
	 * @throws IOException  
	 */
	public static void main(String[] args) throws IOException {
		/**流程：
		 * 1.创建FileReader对象，绑定数据源
		 * 2.创建客户端Socket对象，指定IP和端口号
		 * 3.获取OutputStream对象
		 * 4.使用FileReader对象读取本地文件
		 * 5.使用OutputStream对象将读到的文件写入指定服务器
		 * 
		 * 6.获取InputStream对象
		 * 7.使用InputStream对象读取服务器回复的数据
		 * 8.释放资源
		 * 源文件：21199字节
		 * 测试上传文件共用时：22ms
		 * */
		//开始上传文件时间
		long start = System.currentTimeMillis();
		
		FileReader fr = new FileReader("D:\\java11\\Zhang\\src\\java_classes\\FileInputStreamDemo.txt");
		
		Socket socket = new Socket("127.0.0.1", 8000);
		
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		int len = 0;
		char []temp = new char[1024];
		while((len = fr.read(temp)) != -1) {
			osw.write(new String(temp, 0, len));
		}
		
		osw.flush();//关键
		socket.shutdownOutput();// 防止readLine方法阻塞
		
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		while((len = isr.read(temp)) != -1) {
			System.out.println(new String(temp, 0, len));
		}		
		
		//文件上传完毕时间
		long end = System.currentTimeMillis();
		System.out.println("上传文件共耗时：" + (end - start) + "毫秒");
		
		osw.close();
		fr.close();
		socket.close();
	}

}

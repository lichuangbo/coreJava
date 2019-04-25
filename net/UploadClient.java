/**
 * CopyRight 2019/4/25
 */
package cn.edu.tit.corejava.socket;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


/**
 * @author 李创博
 * @version 1.3
 */
public class UploadClient {

	/**文件上传的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
	 * 文件可以是text文件/jpg图片
	 * @throws IOException  
	 */
	public static void main(String[] args) throws IOException {
		/**流程：
		 * 1.创建客户端Socket对象，指定IP和端口号
		 * 2.根据路径信息判断文件类型，将文件类型发送给服务器端
		 * 3.根据不同的文件类型选择不同的上传方式
		 * 4.创建FileReader/FileInputStream对象，绑定数据源
		 * 5.获取OutputStream对象
		 * 6.使用FileReader/FileInputStream对象读取本地文件
		 * 7.使用OutputStream对象将读到的文件写入指定服务器
		 * 8.获取InputStream对象
		 * 9.使用InputStream对象读取服务器回复的数据
		 * 10.释放资源
		 * 测试图片：D:\java11\Zhang\src\java_classes\女.jpg
		 * 测试文件：D:\java11\Zhang\src\java_classes\FileInputStreamDemo.txt
		 * */
		
		Socket socket = new Socket("127.0.0.1", 8000);
		
		String filePath = "D:\\java11\\Zhang\\src\\java_classes\\女.jpg";
//		String filePath = "D:\\java11\\Zhang\\src\\java_classes\\FileInputStreamDemo.txt";

		String type = filePath.split("\\.")[1];
		
		OutputStream os = socket.getOutputStream();
		if(type.equals("jpg")) {
			//规定1表示是二进制类型文件，0表示是文本类型文件
			os.write(1);
			uploadUnTextFile(socket, filePath);
		}else if(type.equals("txt")) {
			os.write(0);
			uploadTextFile(socket, filePath);
		}		
		os.close();
	}
	
	/**
	 * 上传文本类型文件
	 * @param s Socket对象
	 * @param filePath 文件路径名
	 * @throws IOException
	 * @return: void
	 */
	public static void uploadTextFile(Socket s, String filePath) throws IOException {
		FileReader fr = new FileReader(filePath);
		
		OutputStream os = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		int len = 0;
		char []temp = new char[1024];
		while((len = fr.read(temp)) != -1) {
			osw.write(new String(temp, 0, len));
		}
		
		osw.flush();//关键
		s.shutdownOutput();// 防止readLine方法阻塞
		
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		while((len = isr.read(temp)) != -1) {
			System.out.println(new String(temp, 0, len));
		}
		
		fr.close();
		s.close();
	}
	
	/**
	 * 上传非文本类型文件
	 * @param s Socket对象
	 * @param filePath 文件路径名
	 * @return: void
	 * @throws IOException 
	 */
	public static void uploadUnTextFile(Socket s, String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		
		OutputStream os = s.getOutputStream();
		
		byte []temp = new byte[1024];
		int len = 0;
		while((len = fis.read(temp)) != -1) {
			os.write(temp, 0, len);
		}
		
		os.flush();
		s.shutdownOutput();
		
		InputStream is = s.getInputStream();
		while((len = is.read(temp)) != -1) {
			System.out.println(new String(temp, 0, len));
		}
		
		fis.close();
		s.close();
	}
}



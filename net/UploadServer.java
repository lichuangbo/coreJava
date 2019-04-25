/**
 * CopyRight 2019/4/25
 */
package cn.edu.tit.corejava.socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author 李创博
 * @version 1.3
 */
public class UploadServer {

	/**文件上传的服务器端：接受客户端发送的数据，写入服务器硬盘，回复客户端
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/**流程：
		 * 1.创建ServerSocket对象，绑定到指定端口号
		 * 2.获得客户端对象Socket
		 * 3.判断传入的文件类型，根据不同的类型选择对应的接收方式
		 * 4.获得InputStream对象，并读入客户端发送的数据
		 * 5.创建FileWriter/FileOutputStream实例化对象，绑定数据源
		 * 6.使用FileWriter/FileOutputStream将读入数据写入服务器硬盘 
		 * 7.获得OutputStream对象，回复客户端
		 * 8.释放资源
		 * */	
		ServerSocket ss = new ServerSocket(8000);
		
		File f = new File("D:\\upload\\");
		if(!f.exists()) {
			f.mkdirs();
		}
		
		while(true) {
			System.out.println("正在监听8000端口...");
			Socket socket = ss.accept();
			
			new Thread(new Runnable() {
				//完成文件的上传
				@Override
				public void run() {
					// 重写run方法，子类不能破坏父类的结构，而父类run方法不抛出异常，所以子类也不能抛出异常
					try {
						InputStream is = socket.getInputStream();
						int num = is.read();
						if(num == 1) {
							loadUnTextFile(f, socket);			
						}else if(num == 0) {
							loadTextFile(f, socket);
						}
						is.close();
					}catch(IOException e) {
						System.out.println(e);
					}
				}
			}).start();
		}			
	}
	
	/**
	 * 接收文本类型文件
	 * @param f 存放文件的文件夹
	 * @param s Socket对象
	 * @throws IOException
	 * @return: void
	 */
	public static void loadTextFile(File f, Socket s) throws IOException {
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		String fileName = System.currentTimeMillis() + ".txt";
		FileWriter fw = new FileWriter(f + "\\" + fileName);
		
		int len = 0;
		char []temp = new char[1024];
		while((len = isr.read(temp)) != -1) {
			fw.write(new String(temp, 0, len));
		}
		
		OutputStream os = s.getOutputStream();
		os.write("上传成功！".getBytes());	
		
		fw.close();
		s.close();
	}
	
	/**
	 * 接收非文本类型文件
	 * @param f 存放文件的文件夹
	 * @param s Socket对象
	 * @throws IOException
	 * @return: void
	 */
	public static void loadUnTextFile(File f, Socket s) throws IOException {
		InputStream is = s.getInputStream();
		
		String fileName = System.currentTimeMillis() + ".jpg";
		FileOutputStream fos = new FileOutputStream(f + "\\" + fileName);
		
		int len = 0;
		byte []temp = new byte[1024];
		while((len = is.read(temp)) != -1) {
			fos.write(temp, 0, len);
		}
		
		OutputStream os = s.getOutputStream();
		os.write("上传成功！".getBytes());	
		
		fos.close();
		s.close();
	}
}

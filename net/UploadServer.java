/**
 * CopyRight 2019/4/16
 */
package cn.edu.tit.corejava.socket;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author 李创博
 * @version 1.2
 */
public class UploadServer {

	/**文件上传的服务器端：接受客户端发送的数据，写入服务器硬盘，回复客户端
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/**流程：
		 * 1.创建ServerSocket对象，绑定到指定端口号
		 * 2.获得客户端对象Socket
		 * 3.获得InputStream对象，并读入客户端发送的数据
		 * 4.创建FileWriter对象，绑定数据源
		 * 5.使用FileWriter将读入数据写入服务器硬盘
		 *  
		 * 6.获得OutputStream对象，回复客户端
		 * 7.释放资源
		 * 服务器端：21199字节
		 * */	
		ServerSocket ss = new ServerSocket(8000);
		
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
						InputStreamReader isr = new InputStreamReader(is);
						
						String fileName = System.currentTimeMillis() + ".txt";
						FileWriter fw = new FileWriter("D:\\upload\\" + fileName);
						
						int len = 0;
						char []temp = new char[1024];
						while((len = isr.read(temp)) != -1) {
							fw.write(new String(temp, 0, len));
						}
						
						OutputStream os = socket.getOutputStream();
						os.write("上传成功！".getBytes());	
						
						fw.close();
						socket.close();
					}catch(IOException e) {
						System.out.println(e);
					}
				}
			}).start();
		}			
	}
}

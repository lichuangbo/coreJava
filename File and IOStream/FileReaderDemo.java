/**
 * CopyRight 2019/4/12
 */
package cn.edu.tit.corejava.iostream;

import java.io.FileReader;
import java.io.IOException;


/**FileReader的方法使用
 * @author 李创博
 * @version 1.0
 */
public class FileReaderDemo {

	/**
	 * FileReader继承自InputStreamReader继承自Reader
	 * @throws IOException 
	 * 注意：
	 * 		要读取的文件编码类型要和IDE编码类型一致，否则会显示乱码
	 * 字节流和字符流区别：
	 * 	           字符流是以一个字符为单位读写数据的，可解决中文读写乱码问题、处理文本数据，可使用缓冲区；
	 * 		字节流是以字节为单位读写的，处理二进制数据，默认不使用缓冲区(中文gbk占2byte,utf-8占3byte)
	 */
	public static void main(String[] args) throws IOException {
		// 1.使用构造方法创建FileReader对象，绑定数据源
		/* FileReader类构造方法常用的有两种，和FileInputStream做法类似
		 * FileReader(File file)
		 * FileReader(String fileName)
		 * */  
		FileReader fr = new FileReader("D:\\java11\\Zhang\\src\\java_classes\\1.txt");
		// 2. read()读数据
		/* FileReader的read方法继承自InputStreamReader类
		 * 读取一个字符-->public int read()
		 * 读取多个字符-->public int read(char[] cbuf,int offset,int length)
		 * 
		 * */
		// 读取一个字符
//		int len = 0;
//		while((len = fr.read()) != -1) {
//			System.out.print((char)len);
//		}
		// 读取多个字符
//		char [] c = new char[1024];
//		int len = 0;
//		while((len = fr.read(c)) != -1) {
//			System.out.println(new String(c, 0 ,len));
//		}
		// ready()方法：是否准备好被读取
		while(fr.ready()) {
			System.out.print((char)fr.read());
		}
		// 3. 关闭数据源
		fr.close();
	}

}

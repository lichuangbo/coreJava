/**
 * CopyRight 2019/4/13
 */
package cn.edu.tit.corejava.iostream;

import java.io.FileWriter;
import java.io.IOException;

/**熟悉FileWriter的使用
 * @author 李创博
 * @version 1.0
 */
public class FileWriterDemo {

	/**FileWriter-->OutputStreamWriter-->Writer
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 1.创建一个FileWriter对象，绑定数据源
		/*
		 * 构造方法：
		 * 	FileWriter(File file)
		 * 	FileWriter(String filename)
		 *  FileWriter(File file, boolean append) 是否附加写入的数据
		 *  FileWriter(String fileName, boolean append) 
		 * */
		FileWriter fw = new FileWriter("D:\\java11\\Zhang\\src\\java_classes\\1.txt", false);
		// 2.使用FileWriter方法，把数据写入内存缓冲区
		/* write()方法的种类：
		 * 	public void write​(char[] cbuf) 写入字符数组,Writer类
		 * 	public void write​(String str) 写入字符串，Writer类
		 * 	public void write(int c) 写入单个字符，OutputStreamWriter类
		 * 	public void write(char[] cbuf, int off, int len),OutputStreamWriter类
		 * 	public void write(String str, int off, int len)，OutputStreamWriter类
		 * */
		fw.write('1');
		fw.write(97);
		fw.write("ag");
		fw.write("405宿舍", 3, 2);
		char []cs = {'q','w', 'e', 'r', 't'};
		fw.write(cs);
		fw.write(cs, 4, 1);
		// 3.flush(),把内存缓冲区中的数据刷新到文件中,刷新后可以继续使用流对象
		fw.flush();
		// 4.释放资源，close之前先进行flush操作，close之后无法使用流对象
		fw.close();
	}

}

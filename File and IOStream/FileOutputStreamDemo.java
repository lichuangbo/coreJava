/*
 * CopyRight 2019/4/11
 * */
package cn.edu.tit.corejava.iostream;


import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李创博
 * @version 1.0
 */
public class FileOutputStreamDemo {
	/*
	 * OutputStream抽象类，是所有输出字节流类的超类
	 * 拥有一些子类共有的方法：
	 * 	close(),flush(),write()
	 * 子类：
	 * 	FileOutputStream
	 * */
	
	public static void main(String[] args) throws IOException {
		/**
		 * 构造方法：(创建一个FileOutputStream对象，
		 * 根据构造方法中的文件/文件路径创建一个空的文件，
		 * 并把FileOutputStream对象指向创建好的文件)
		 * 	FileOutputStream(String name)
		 * 	FileOutputStream(File file)
		 * 	FileOutputStream(String name, boolean append) append:是否追加
		 * 	FileOutputStream(File file, boolean append)
		 * */
		
		// 1.使用构造方法来创建一个FileOutputStream对象 (抛出FileNotFoundException异常)
		FileOutputStream fos = new FileOutputStream("D:\\java11\\Zhang\\src\\java_classes\\FileOutputStreamDemo.txt", true);
		// 2. 使用write()方法写入数据(抛出IOException)
		//写入单个字节
//		fos.write(65);  
//		fos.write('a');
		/*
		 * 写入多个字符
		 * write(byte[] b)
		 * 		如果写的第一个字节是正数(0-127)，显示的时候会查询ASCII表
		 * 		如果写的第一个字节是负数，那第一个字节会和第二个字节一起组成一个中文显示，查询GBK表
		 * write(byte[] b, int off, int len):把字节数组的一部分写入文件中
		 * 		从off开始写入，写入len个
		 **/
//		byte []a = {68, 69, 70, 71};
//		byte []b = {-68, -69, -70, 71};
//		fos.write(a);
//		fos.write(b);
//		
//		fos.write(b, 2, 1);
		/*
		 * 写入字符：使用String类中的方法把字符串转化为字节数组
		 * 		byte[] getBytes()
		 * */
//		byte[] c = "你好世界".getBytes();
//		System.out.println(Arrays.toString(c));
//		fos.write(c);
		
		/*追加续写，在构造函数中加上append参数
		 * 换行输出
		 * Windows: \r\n
		 * Linux\Unix: /n
		 * Mac: /r
		 * */
		for (int i = 0; i < 10; i++) {
			fos.write("呵呵".getBytes());
			fos.write("\r\n".getBytes());
		}
		// 3. 释放资源(抛出IOException)
		fos.close();
	}
}

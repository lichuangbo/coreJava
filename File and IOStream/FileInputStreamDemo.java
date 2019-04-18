/**
 * CopyRight 2019/4/11
 */
package cn.edu.tit.corejava.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;



/**FileInputStream的使用
 * @author 李创博
 * @version 1.0
 */
public class FileInputStreamDemo {
	/**
	 * 作用：把硬盘中的数据读取到内存中使用
	 * FileInputStream的构造方法：(与FileOutputStream类似)
	 * 	FileInputStream(String name)
	 * 	FileInputStream(File file)
	 * */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\java11\\Zhang\\src\\java_classes\\FileInputStreamDemo.txt");
		/* read():读取一个字节并返回，读取到文件的末尾返回-1
		 * 利用-1可以用循环输出
		 */
//		System.out.println(fis.read());
//		System.out.println(fis.read());

//		int len = 0;// 把读取到的字节赋值给len变量
//		while ((len = fis.read()) != -1) {
//			System.out.println(len);
//		}
	
		/*
		 * 字节流一次性读取多个字节，并将其存储在数组中
		 * 		String(byte [] b):将字符数组转化为字符串
		 * 		int read(byte[] b):b[]存储读取到的数据；int返回读入缓冲区的总字节数；
		 * 		int read(byte[] b, int off, int len): off目标数组的其实偏移量， len读取的最大字节数
		 * */
//		byte []a = new byte[2];
//		int length = fis.read(a);
//		System.out.println(length);
//		System.out.println(new String(a));
		
		// 方法一
		// 思路：利用read()方法每次返回的值进行逻辑判断
		byte []bytes = new byte[1024];
		int len = 0;
		while((len = fis.read(bytes)) != -1) {
			System.out.println(URLDecoder.decode(new String(bytes, 0, len), "GBK"));// 仅输出有效的
		}
		
		// 方法二
		// 思路：利用available()返回文件可读字节总数/数组长度得到执行次数，再处理最后剩下的不够一个数组长度的
//		byte []b = new byte[1024];
//		int length = fis.available()/1024;
//		for (int i = 0; i < length; i++) {
//			fis.read(b);
//			System.out.print(new String(b));
//		}
//		int last = fis.read(b);
//		System.out.println(new String(b, 0, last));
	}

}

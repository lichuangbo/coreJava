/**
 * CopyRight 2019/4/14
 * */
package cn.edu.tit.corejava.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**OutputStreanWriter类的使用
 * @author lichuangbo
 * @version 1.0
 * */
public class StreamWriterDemo {
	/**
	 * OutputStreanWriter-->Writer是一个字符流
	 * 		是字符流通向字节流的桥梁，可以使用指定的charset将要写入流中的字符编码成字节。(内存-->硬盘)
	 * 构造方法：
	 * 		OutputStreamWriter(OutputStream out) 
	 * 		OutputStreamWriter(OutputStream out, String charsetName) 
	 * 		  OutputStream out：字节输出流，可以用来将转换后的字节写入文件中；
	 * 		  String charsetName：制定的编码表名称，默认utf-8；
	 * 注意：
	 * 		utf-8：三个字节表示一个汉字
	 * 		GBK：两个字节表示一个汉字
	 * 
	 * InputStreamReader-->Reader是一个字符流
	 * 		是字节流通向字符流的桥梁，使用指定的charset读取字节并将其解码为字符(硬盘-->内存)
	 * 构造方法：
	 * 		InputStreamReader(InputStream in) 
	 * 		InputStreamReader(InputStream in, String charsetName)
	 * 注意：
	 * 		构造方法中的编码表类型要和文件的编码类型一致，否则会出现乱码
	 * @throws IOException 
	 * */
	public static void main(String[] args) throws IOException {
//		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\java11\\Zhang\\src\\java_classes\\1.txt"), "GBK");
//		osw.write("你好");
//		osw.flush();
//		osw.close();
		
//		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\java11\\Zhang\\src\\java_classes\\1.txt"), "GBK");
//		int len = 0;
//		while((len = isr.read()) != -1) {
//			System.out.print((char)len);
//		}
//		isr.close();
		
		//练习：将utf-8编码类型文件转换为GBK编码文件
		InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\java11\\Zhang\\src\\java_classes\\1.txt"), "utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\java11\\Zhang\\src\\java_classes\\2.txt"), "GBK");
		
		int len = 0;
		while((len = isr.read()) != -1) {
			osw.write(len);
		}
		
		isr.close();
		osw.close();
	}

}

/**
 * CopyRight 2019/4/9
 */
package cn.edu.tit.corejava.file;
import java.io.File;
import java.io.IOException;

/**
 * @author 李创博
 * @version 1.0
 */
public class FileMkDel {
	public static void main(String[] args) {
		mkFile();
		
//		mkDir();
		
//		deleteFile();
	}

	private static void deleteFile() {
		//可以删除构造方法路径中的文件夹和文件，从硬盘中直接删除；true:删除成功，false:删除失败
		File file1 = new File("java11\\Zhang\\src\\java_classes\\405\\zhangchunyin");
		System.out.println(file1.delete());		
	}

	private static void mkDir() {
		File file1 = new File("D:\\java11\\Zhang\\src\\java_classes\\zhangchunyin");
		System.out.println(file1.mkdir());
		
		File file2 = new File("java11\\Zhang\\src\\java_classes\\405\\zhangchunyin");
		System.out.println(file2.mkdirs());
		System.out.println(file2.getAbsolutePath());
	}

	private static void mkFile() {
		try {
			File file1 = new File("D:\\java11\\Zhang\\src\\java_classes\\1.txt");
			// createNewFile()要求创建的路径信息必须正确，否则抛出异常
			// 绝对路径和相对路径都可以创建文件
			System.out.println(file1.createNewFile());
			
			File file2 = new File("\\soft\\2.txt");
			System.out.println(file2.createNewFile());
			
			//创建失败，因为路径信息不存在
			File file3 = new File("software\\2.txt");
			System.out.println(file3.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

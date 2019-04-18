/*
 * CopyRight 2019/4/8
 * */
package cn.edu.tit.corejava.file;

import java.io.File;

/**
 * 熟悉File类的分隔符和构造方法
 * @author: lichuangbo
 * @version: 1.0
 * */
public class FileConstructorDemo {
	public static void main(String[] args) {
//		showSeparator();
		
		
//		showFileConstructor();
				
		
		showFileConstructor2();
		
		
//		showFileConstructor3();
		
	}

	private static void showSeparator() {
		// 路径分隔符 Windows ; Linux : 
		String pathSepartor = File.pathSeparator;
		System.out.println(pathSepartor);

		// 与系统相关的默认分隔符 Windows \ Linux /
		String separator = File.separator;
		System.out.println(separator);

		// 由于不同的操作系统平台存在差异，文件路径也要因操作系统平台而异
		String filepath = "C:" + File.separator + "app" + File.separator + "HelloWorld.txt";
		System.out.println(filepath);
	}

	private static void showFileConstructor() {
		/*
		 * File(String pathname) 通过将给定路径名字符串转化为抽象路径名来创建一个新的File实例
		 * 参数：
		 * 	路径可以是以文件结尾，也可以是以文件夹结尾
		 * 	路径可以是相对路径，也可以是绝对路径
		 *  路径可以存在也可以不存在
		 *  创建File对象，只是把字符串路径封装为File对象，不考虑路径的真实情况
		 * */
		File file1 = new File("D:\\java11\\Zhang\\src\\java_classes\\");
		//重写了Object对象的toString()方法
		System.out.println(file1);		
		
		File file2 = new File("hehe\\a.txt");
		System.out.println(file2);
	}
	
	private static void showFileConstructor2() {
		/*
		 * File(String parent, String child) 根据parent路径名字符串和child路径名字符串创建一个File实例
		 *  父路径和子路径，可以单独书写，使用起来方便灵活；而且父路径和子路径可以变化
		 * */
		String parent = "D:\\";
		String child = "a.java"; 
		File file = new File(parent, child);
		System.out.println(file);
	}
	
	private static void showFileConstructor3() {
		/*
		 * File(File parent, String child)
		 * 如果parent是null,等价于File(String pathname),否则以parent为目录，用child表示目录或文件
		 * 父路径是File类型，可以使用File类的方法对路径进行一些操作，再使用路径创建对象
		 * 
		 * */
		File parent = new File("D:\\java11\\Zhang\\src\\java_classes");
		File file = new File(parent, "a.java");
		System.out.println(file);
	}
	
}


/**
 * CopyRight 2019/4/9
 */
package cn.edu.tit.corejava.file;

import java.io.File;
/**
 * 熟悉File类自带的方法
 * @author 李创博
 * @version 1.0
 */
public class FileFunctionDemo {
	public static void main(String[] args) {
//		showGet();
		
//		showIsCan();
		
		showFileList();
	}

	private static void showFileList() {
		File file = new File("C:\\soft");
		/*
		 * public String[] list():返回String数组
		 * public File[] listFiles():返回File数组
		 * 路径指向文件或者路径不存在会抛出异常
		 */
		String []arr = file.list();
		for (String filenameString : arr) {
			System.out.println(filenameString);
		}
		
		// 会返回带路径的File数组
		File []arr2 = file.listFiles();
		for (File filenameFile : arr2) {
			System.out.println(filenameFile);
		}
	}

	private static void showIsCan() {
		File file1 = new File("C:\\soft");
		// 是否为绝对路径
		System.out.println(file1.isAbsolute());	
		// 是否为目录
		//isDirectory()和isFile()互斥，但是文件路径信息一定是真实存在的
		System.out.println(file1.isDirectory());
		// 是否为文件
		System.out.println(file1.isFile());
		// 是否是隐藏的
		System.out.println(file1.isHidden());
		// 是否可写
		System.out.println(file1.canWrite());
		// 是否可读
		System.out.println(file1.canRead());
		// 是否可执行
		System.out.println(file1.canExecute());
	}

	private static void showGet() {
		File file1 = new File("C:\\soft");
		// 获取完整路径名
		System.out.println(file1.getAbsolutePath());
		// 获取路径名称序列的最后一个名字
		System.out.println(file1.getName());
		// 路径名的前缀和路径名的名称序列中的每个名称组成(除去最后一个)
		System.out.println(file1.getParent());
		// 将抽象路径名转化为路径名字符串
		System.out.println(file1.getPath());
		// 返回的是File类型
		System.out.println(file1.getAbsoluteFile());
		System.out.println(file1.getParentFile());
		System.out.println();
		File file2 = new File("src\\java_classes\\two_number_sort.java");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getPath());
		System.out.println(file2.getAbsoluteFile());
		System.out.println(file2.getParentFile());
	}

}

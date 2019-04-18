/**
 * CopyRight 2019/4/12
 */
package cn.edu.tit.corejava.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 李创博
 * @version 1.2
 */
public class CopyFile {
	/**
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		CopyFile("D:\\java11\\Zhang\\src\\java_classes\\from.JPG", "D:\\java11\\Zhang\\src\\java_classes\\405\\zhangchunyin\\to.jpg");		
	}
	
	private static void CopyFile(String fileFrom, String fileTo) {
		long start = System.currentTimeMillis();
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(fileFrom));
			bos = new BufferedOutputStream(new FileOutputStream(fileTo));
			
			byte []temp = new byte[1024];
			int len = 0;
			while((len = bis.read(temp)) != -1) {
				bos.write(temp, 0, len);
			}
			
			long end = System.currentTimeMillis();
			System.out.println("复制成功，共用时："+(end-start)+"毫秒");	
		}catch(IOException e) {
			System.out.println(e);
		}finally {
			if(bis != null || bos != null) {
				try {
					bis.close();
					bos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}				
		}	
	}
}

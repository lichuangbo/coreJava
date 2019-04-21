/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月21日
 */
package cn.edu.tit.corejava.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 李创博
 * @version: 1.0
 */
public class ListDemo {
	
	public static void main(String[] args) {
//		showList();
		
//		showLinkedList();

		showArrayList();
	}
	
	public static void showList() {
		/**
		 * List接口：
		 * 	1.有序的集合，存储和取出集合中元素时是一致的
		 * 	2.有索引，并且包含了一些有索引的方法
		 * 	3.允许存储重复的元素
		 * 特有的带索引方法：
		 * 	void add(int index, E element) 将指定的元素插入此列表中的指定位置 
		 * 	E get(int index)  返回此列表中指定位置的元素
		 * 	E remove(int index)  删除该列表中指定位置的元素
		 * 	E set(int index, E element)  用指定的元素替换此列表中指定位置的元素
		 * 注意：
		 * 	操作索引时，防止索引越界异常
		 * ArrayList底层是可变长数组，导致查询快，增删慢
		 */
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("e");
		list.add("a");
		System.out.println(list);
		
		list.add(2, "ccc");
		System.out.println(list);
		
		System.out.println("移除的元素：" + list.remove(3));
		
		System.out.println("替换的元素：" + list.set(3, "aaa"));
		System.out.println(list);
		
		System.out.println("使用get方法遍历集合：");
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.print(str + " ");
		}
		System.out.println("\n使用增强for循环遍历集合：");
		for (String str : list) {
			System.out.print(str + " ");
		}
	}

	public static void showLinkedList() {
		/**
		 * LinkedList集合的特点：
		 * 	1.底层是链表结构，导致增删快，查询慢
		 * 	2.包含大量的首尾操作方法
		 *  3.不同步
		 * 注意：
		 * 	使用LinkedList集合特有的方法，不能使用多态
		 * 特有方法：
		 * 	addFirst,addLast,removeFirst,removeLast,getFirst, getLast
		 * 	pop,push
		 */
		LinkedList<String> list = new LinkedList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);
		
		list.addFirst("aaa");// 等效于push
		list.addLast("ccc");
		System.out.println(list);
		
		list.removeFirst();// 等效于pop
		list.removeLast();
		System.out.println(list);
		
		System.out.println("移除的第一个元素" + list.getFirst());
		System.out.println("移除的最后一个元素" + list.getLast());
	}

	public static void showArrayList() {
		/**
		 * ArrayList集合特点：
		 * 	1.底层是'可变长数组'，导致增删慢，查询快
		 *  2.不同步
		 */
		ArrayList<String> list= new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list);
	}
	
	public static void showVector() {
		/**Vector
		 * 1.起始版本JDK1.0，底层是'可变长数组'，与ArrayList一致
		 * 2.与ArrayList不同的是，Vector支持单线程同步，访问速度比ArrayList慢
		 * 3.ArrayList内存不够时默认是扩展50% ，Vector是默认扩展100%
		 * 4.当时遍历使用自己的方法(迭代器在JDK1.2才出现)
		 * 	 boolean hasMoreElements() 
		 * 	 E nextElement()   
		 */
	}
}

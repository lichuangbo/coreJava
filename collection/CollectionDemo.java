/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月21日
 */
package cn.edu.tit.corejava.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 李创博
 * @version: 1.0
 */
public class CollectionDemo {

	/**
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		/**
		 * Collection是集合层次的根接口，其下有常见的set,list,sorkedlist接口；
		 * 它定义了所有单列集合中共性的方法
		 * 它没有带索引的方法，故不能使用普通的for循环。
		 */
		//使用多态创建集合，ArrayList可以改变
		Collection<String> coll = new ArrayList<>();
		
		//public boolean add(E e);往集合添加指定对象
		boolean b1 = coll.add("xiaotian");
		coll.add("xiaowang");
		coll.add("xiaozhang");
		System.out.println(coll);
		/**遍历集合的两种方法：
		 * 1).使用迭代器遍历集合中的对象(通用)
		 * 		boolean hasNext();有元素返回true,没有返回false；
		 * 		E next(); 取出集合中下一个元素；
		 * 注意：
		 * 	1.Inteator迭代器是一个接口，需要使用它的实现类对象来调用
		 * 	2.Inteator<E>接口是有泛型的，遍历时要和集合中的泛型一致。
		 * 2).使用增强for循环(简化迭代器)：
		 * 	for(泛型 变量名  : 集合/数组)
		 */
		Iterator<String> it = coll.iterator();//获取迭代器实现类对象，并且会把指针指向集合的-1索引处
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for (String s : coll) {
			System.out.println(s);
		}
		
		/**
		 * public boolean remove(E e):把指定对象在集合中删除
		 * 指定元素存在，删除成功返回true；
		 * 指定元素不存在，删除失败返回false
		 */
		System.out.println(coll.remove("xiaotian") + "" + coll);
		System.out.println(coll.remove("xiaowan") + "" + coll);
		
		//public boolean contains(E e):判断集合是否包含给定的对象
		System.out.println(coll.contains("xiaozhang"));
		System.out.println(coll.contains("xiaoxian"));
		
		//public boolean isEmpty():判断当前集合是否为空
		System.out.println(coll.isEmpty());
		
		//pubic int size();返回集合中对象个数
		System.out.println(coll.size());
		
		//public Object[] toArray();集合转数组
		Object []arr = coll.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//public void clear();清空集合中所有的元素
		coll.clear();
		System.out.println(coll);
	}

}

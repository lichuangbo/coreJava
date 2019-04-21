/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月21日
 */
package cn.edu.tit.corejava.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author 李创博
 * @version: 1.0
 */
public class SetDemo {
	public static void main(String[] args) {
//		showHashSet();
		
		HashSet<Student> set = new HashSet<>();
		Student s1 = new Student("小明", 22);
		Student s2 = new Student("小张", 22);
		Student s3 = new Student("小张", 22);
		set.add(s1);
		set.add(s2);
		set.add(s3);
		for (Student student : set) {
			System.out.println(student.getName() + student.getAge());
		}
		
		showLinkedHashSet();
	}
	
	public static void showSet() {
		/**
		 * Set接口特点：implements Collection
		 * 	  1.不允许存放重复元素
		 *    2.没有索引，也没有带索引的方法，不能使用普通for循环
		 * Set不存放重复元素的原理：
		 * 	  add方法首先调用元素的hashCode方法得到一哈希值，再遍历集合中判断是否存在此哈希值，
		 * 	     不存在:
		 * 		放入集合;
		 *    发现存在:
		 *    	调用equals和相同元素比较:
		 *    	 	返回true，说明两个元素相同就不再添加
		 *    		返回false，说明是哈希冲突可以添加
		 */
	}
	public static void showHashSet() {
		/**
		 * HashSet类特点：implements Set
		 * 	  1.是一个无序集合，存放和取出元素的顺序可能不一致
		 *    2.底层是一个哈希表结构，导致查询快
		 * 补充：
		 * 	 1.哈希值是一十进制整数，由操作系统随机给出
		 *   2.toString()方法返回的对象地址值就是16进制下哈希值(他是逻辑地址值，并非实际物理地址)
		 *   3.哈希表=数组+链表/红黑树
		 */
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("b");
		set.add("c");
		//存放重复元素不报错，但实际存放的只有一个
		set.add("a");
		System.out.println(set);
		
		System.out.println("增强for循环遍历:");
		for (String str : set) {
			System.out.print(str + " ");
		}
		System.out.println("\n迭代器遍历:");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	public static void showLinkedHashSet() {
		/**
		 * LinkedHashSet extends HashSet集合
		 * 底层是一个哈希表+链表，链表保证存储顺序是有序的
		 */
		LinkedHashSet<String> set = new LinkedHashSet<>();
		set.add("c");
		set.add("a");
		set.add("b");
		set.add("a");
		System.out.println(set);
	}
}
class Student {
	/**
	 * 使用HashSet存储自定义类型
	 * 必须重写HashCode和equals方法
	 */
	private String name;
	private int age;
	public Student() {
		
	}
	/* 
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* 
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}

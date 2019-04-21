/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月21日
 */
package cn.edu.tit.corejava.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 李创博
 * @version: 1.0
 */
public class GenericDemo {
	public static void main(String[] args) {
		/**
		 * 1.泛型是一种特殊的数据类型，当不知道是用什么类型的时候，可以考虑使用泛型
		 * 	      如在集合概念中，并不知道集合中会存储什么类型的对象，就使用泛型
		 * 2.泛型也可以看作是一个变量，接收数据类型，如E e
		 * 3.传递过来的类型，就使用此类型，类似于多态的思想灵活
		 */
		//不使用泛型，默认是Object类型
		GenericClass gc = new GenericClass();
		gc.setName("aaa");
		Object object = gc.getName();
		System.out.println(object);
		
		//创建泛型类对象
		GenericClass<Integer> gc2 = new GenericClass();
		gc2.setName(111);
		Integer integer = gc2.getName();
		System.out.println(integer);
		
		//调用含有泛型的方法
		gc2.say("English");
		gc2.say(123);
		
		//调用含有泛型的静态方法
		GenericClass.speak("Chinese");
		GenericClass.speak(123);
		
		//使用泛型的接口
		System.out.println();
		GenericInterfaceImpl gii = new GenericInterfaceImpl();
		gii.say("Hello");
		
		GenericInterfaceImpl2<Integer> gii2 = new GenericInterfaceImpl2();
		gii2.say(123);
		
		/**
		 * 通配符的使用
		 * 注意：
		 * 		1.通配符不能再定义对象或者类时使用，只能在方法的参数中使用
		 * 		2.泛型不存在继承关系
		 */
		System.out.println();
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<String> arr2 = new ArrayList<>();
		arr1.add(111);
		arr2.add("aaa");
		printArrayList(arr1);
		printArrayList(arr2);
		
		/**
		 * $通配符面试题
		 * 泛型的上限限定： ? extends E 只能是E类型的子类/本身
		 * 泛型的下限限定： ? supper E  只能时E类型的父类/本身
		 */
		Collection<Integer> list1 = new ArrayList<Integer>();
		Collection<String> list2 = new ArrayList<String>();
		Collection<Number> list3 = new ArrayList<Number>();
		Collection<Object> list4 = new ArrayList<Object>();
		
//		getElememt1(list1);
//		getElememt1(list2);//报错
//		getElememt1(list3);
//		getElememt1(list4);//报错
//		
//		getElememt2(list1);//报错
//		getElememt2(list2);//报错
//		getElememt2(list3);
//		getElememt2(list4);
	}
	
	public static void printArrayList(ArrayList<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	public static void getElememt1(Collection<? extends Number> c) {
		
	}
	public static void getElememt2(Collection<? super Number> c) {
		
	}
}

/**
 * 创建泛型类
 * @author 李创博
 * @version: 1.0
 * @param <E> 
 */
class GenericClass<E>{
	private E name;
	
	public E getName() {
		return name;
	}
	
	public void setName(E name) {
		this.name = name;
	}
	
	/**
	 * 泛型方法：
	 * 泛型定义在方法的修饰符和返回制类型之间
	 * 使用泛型方法时，传递什么类型的参数，方法就调用什么类型的参数
	 */
	public <M> void say(M m) {
		System.out.println(m);
	}
	
	public static <N> void speak(N n) {
		System.out.println(n);
	}
}

/**
 * 含有泛型的接口两种使用方式
 * 1.定义接口的实现类，在实现接口的同时指定接口的泛型
 * 		例如：Scanner类实现了Iterator接口,指定接口泛型String，重写next方法
 * 2.定义接口实现类，接口和实现类仍用同一个泛型表示，创建对象的时候再确定泛型的类型
 * 		例如:ArrayList实现List接口
 */
interface GenericInterface<I> {
	/**
	 * 使用带有泛型的接口
	 * @param i
	 * @return: void
	 */
	public abstract void say(I i);
}

class GenericInterfaceImpl implements GenericInterface<String> {

	/* 
	 * @param i
	 * @see cn.edu.tit.corejava.collection.GenericInterface#method(java.lang.Object)
	 */
	
	@Override
	public void say(String i) {
		System.out.println(i);
	}
	
}

class GenericInterfaceImpl2<M> implements GenericInterface<M> {
	
	@Override
	public void say(M m) {
		System.out.println(m);
	}
	

}
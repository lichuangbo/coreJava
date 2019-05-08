/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月8日
 */
package cn.edu.tit.corejava.thread;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式的使用
 * @author 李创博
 * @version: 1.0
 */
public class LambdaDemo {
	public static void main(String[] args) {
		showLambda();
		
		showLambda2();
	}
	
	public static void showLambda2() {
		//使用匿名内部类实现多线程
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName() + "新线程创建");
//			}
//		}).start();
//		
		//使用Lambda无参表达式实现多线程
		new Thread(()-> {
				System.out.println(Thread.currentThread().getName() + "新线程创建");
			}
		).start();
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		list.forEach(n -> System.out.println(n));//使用lambda表达式遍历list
		list.forEach(System.out :: println);//::符将常规方法转化为lambda表达式
	}
	
	public static void showLambda() {
		/**
		 *JDK8中，为了解决内部类的冗余，加入了lambda新特性
		 *http://blog.oneapm.com/apm-tech/226.html
		 * 格式：
		 * 		(参数列表)  -> (一些重写方法的代码);
		 * 	  ():接口中抽象方法的参数列表，没有参数空着；有参数，用逗号分隔；
		 *    ->:把参数传递给方法体
		 *    ():重写接口的抽象方法的方法体
		 * 注意事项：
		 * 	  1.使用lambda必须具有接口，且接口中的有且仅有一个抽象方法(也叫函数式接口)
		 *    2.必须具有上下文推断，方法的参数类型必须是lambda对应的接口类型
		 */
		//示例，对person对象按年龄进行升序排序
		Person []arr = {
				new Person("li", 12),
				new Person("wang", 22),
				new Person("xia", 33)
		};
		
		//使用匿名对象类
//		Arrays.sort(arr, new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.age - o2.age;
//			}
//		});
		
		//使用lambda带参数表达式
//		Arrays.sort(arr, (Person o1, Person o2)->{
//			return o1.age - o2.age;
//		});
		
		/**
		 * lambda省略写法
		 * 	1.参数列表中参数数据类型可以省略
		 * 	2.参数只有一个，类型和()都可以省略
		 * 	3.执行代码只有一行，可以将{}，return，；一起省略
		 */
		Arrays.sort(arr, (o1, o2)-> o1.age - o2.age);
		
		for (Person p : arr) {
			System.out.println(p);
		}
	}
}
class Person {
	String name;
	int age;
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
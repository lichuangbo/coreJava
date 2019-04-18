/**
 * CopyRight 2019/4/17
 */
package cn.edu.tit.corejava.thread;

/**创建并调用多线程的两种方式
 * @author 李创博
 * @version 1.0
 */
public class MkThreads {

	public static void main(String[] args){
		/**方法一：
		 * 1.创建一个Thread类的子类
		 * 2.在Thread类的子类中重写run方法，设置线程任务
		 * 3.创建Thread类的子类对象
		 * 4.调用Thread类的start方法，开启线程，执行run方法
		 * */		
		new MyThread().start();
		/**方法二
		 * 1.创建一个Runnable接口的实现类
		 * 2.重写run方法，设置线程任务
		 * 3.创建Runnable实现类对象
		 * 4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
		 * 5.调用Thread类的start方法，开启线程执行run方法
		 * */
		MyThread2 mt2 = new MyThread2();
		new Thread(mt2).start();

		// 主线程调用
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "-->main thread run:"  + i);
		}	
	}

}
class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "-->MyThread run:"  + i);
//			try {
//				//使当前正在执行的线程以设置毫秒数暂停，要抛出异常
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				System.out.println(e);
//			}
		}
	}
}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "-->Runnable Thread:" + i);
		}
	}
	
}

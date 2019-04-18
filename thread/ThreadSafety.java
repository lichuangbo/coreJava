/**
 * CopyRight 2019/4/17
 */
package cn.edu.tit.corejava.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**线程安全问题描述与解决
 * @author 李创博
 * @version 1.0
 */
public class ThreadSafety {

	/**
	 * 线程安全问题三种解决办法
	 */
	public static void main(String[] args) {
		/**
		   * 问题描述：
		  * 多个线程执行卖票程序(抢占共享资源)，会出现重复的票和不存在的票等线程安全问题
		  * 解决办法：
		  * 一个线程在访问共享资源的时候，无论是否失去了CPU的执行权，都让其他线程等待，直到当前线程结束访问 
		 * */
		RunImpl runImpl = new RunImpl();
		new Thread(runImpl).start();
		new Thread(runImpl).start();
		new Thread(runImpl).start();
	}
}

class RunImpl implements Runnable{
	private int ticket = 100;
	private int sleepTime = 100;
	
	Object obj = new Object();
	Lock l = new ReentrantLock();
	@Override
	public void run() {
		while(true) {
			/**解决方法一：同步代码块
			 * synchronized(锁对象){
			 * 	   可能会出现线程安全问题的代码
			 *	 //获得锁对象的线程才能执行，保证了只能有一个线程在同步中访问共享数据
			 * }
			 * */
//			synchronized (obj) {
//				if(ticket > 0) {
//					try {
//						Thread.sleep(sleepTime);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
//					ticket --;
//				}
//			}
			/**解决方法二：同步方法
			 * 修饰符(public) synchronized 返回值类型(void) 方法名(){
			 * 	写入可能出现线程安全问题的代码
			 * }
			 * 同步方法的对象就是实现类对象(runImpl)，相当于this
			 * 静态同步方法：public staic synchronized void sellTicket(){}
			 * */
//			sellTicket();
			/**解决方法三：lock锁
			 * java.util.conCurrent.locks.Lock接口
			 * void lock(); 如果锁不可用，则当前线程将被禁用以进行线程调度，并处于休眠状态，直到获取锁。
			 * void unclock();
			 * 在成员位置创建一个对象
			 * 在可能出现线程同步问题的代码前调用lock
			 * 在之后调用unlock
			 * */
			l.lock();
			if(ticket > 0) {
				try {
					Thread.sleep(sleepTime);
					System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
				    ticket --;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					//无论程序是否出现异常，都将锁释放掉
					l.unlock();
				}
			}
		}
	}
	
	public synchronized void sellTicket() {
		if(ticket > 0) {
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
			ticket --;
		}
	}
}

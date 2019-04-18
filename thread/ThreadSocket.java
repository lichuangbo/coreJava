/**
 * CopyRight 2019/4/18
 */
package cn.edu.tit.corejava.thread;



/**
 * @author 李创博
 * @version 1.0
 */
public class ThreadSocket{

	/**Object方法：
	 * void wait()：当前线程陷入等待，直到被唤醒
	 * void notify()：唤醒等待中的单个线程，唤醒后会继续执行wait之后的代码
	 * 
	 * 注意：
	 * 	执行等待和唤醒必须是同一个对象
	 */
	public static void main(String[] args) {
		Object object = new Object();
		new Thread() {
			@Override
			public void run() {
				synchronized (object) {
					while(true) {
						try {
							System.out.println("消费者要进行消费。。。");
							object.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						
						System.out.println("消费者消费完毕！");
						System.out.println();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						Thread.sleep(5000);
						System.out.println("生产者正在生产。。。");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					synchronized (object) {
						System.out.println("生产者生产完毕！");
						// 唤醒消费者
						object.notify();
					}
				}
			}
		}.start();
	}
}


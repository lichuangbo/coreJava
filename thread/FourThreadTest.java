/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月20日
 */
package cn.edu.tit.corejava.thread;


/**
 * @author 李创博
 * @version: 1.0
 */
class Resource
{
    private int j=0;
    
    public synchronized void add(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-add-"+"目前j的值为："+j);
 
    }
    
    public synchronized void des(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-des-"+"目前j的值为："+j);
    }
}

public class FourThreadTest {
    public static void main(String []args){
    	/**
    	 * 设计 4 个线程，其中两个线程每次对 j 增加 1 ，另外两个线程对 j 每次减少 1. 写出程序。
    	 */
    	Resource r = new Resource();
    	for(int i = 0; i < 2; i++) {
    		//开启j + 1线程
    		new Thread() {
    			@Override
    			public void run() {
    				while(true) {
    					try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    					r.add();
    				}
    			}
    		}.start();
    		//开启j - 1线程
    		new Thread() {
    			@Override
    			public void run() {
    				while(true) {
    					try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
    					r.des();
    				}
    			}
    		}.start();
    	}
    }
}


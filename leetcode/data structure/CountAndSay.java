/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月6日
 */
package cn.edu.tit.leetcode;

/**
 * 报数(和n没有关系，下一个序列总是从上一个序列中产生)
 * @author 李创博
 * @version: 1.0
 */
public class CountAndSay {
	/**
	1
	11
	21
	1211
	测试耗时：40ms
	*/
	public String countAndSay(int n) {
	    if(n == 1) {
			return "1";
		}
		String pre = "1";
		String res = "";
		//从第二次开始计算，有点类似于斐波那契数列
		for (int i = 1; i < n; i++) {
			//每次计算前将res重置
			res = "";
			//根据上一次序列计算下一次报数序列
			int count = 1;
			int j;
			for (j = 0; j < pre.length() - 1; j++) {
				if (pre.charAt(j) == pre.charAt(j + 1)) {
					count++;
				} else { 
					res += count + "" + pre.charAt(j); 
					count = 1; 
				}
			}
			res += count + "" + pre.charAt(j);//连接最后的一个字符序列
			//将计算好的序列赋值给pre，让它在新的基础上继续下一次的计算
			pre = res;
		}
		return res;
	}

	public static void main(String[] args) {
//		CountAndSay cas = new CountAndSay();
//		System.out.println(cas.countAndSay(6));
//		
//		boolean b = true;
//		b=true?false:(true==true?false:true);
//		System.out.println(b);
		
//		boolean y=true?false:true==true?false:true; //=false
//		boolean z=(true?false:(true==true))?false:true; //左结合Left2Right = true
//		boolean w=true?false:((true==true)?false:true); //右结合Right2Left = false 后面括号根本不会执行
//		System.out.println(y);
//		System.out.println(z);
//		System.out.println(w);
		
	}
}

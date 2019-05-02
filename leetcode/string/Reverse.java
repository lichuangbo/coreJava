/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月2日
 */
package cn.edu.tit.leetcode;

/**
 * 反转字符串/数字
 * @author 李创博
 * @version: 1.0
 */
public class Reverse {
	//4ms
	public void reverseString(char[] s) {
		if (s.length == 0 || s == null) {
			return;
		}
        for (int i = 0; i < s.length / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - i -1];
			s[s.length - i - 1] = temp;
		}
    }
	
	public int reverse(int x) {
		/**
		 * 先全部反转，如果最后一位是负号，挪动位置把负号放在开头；之后处理int溢出问题。
		 * 测试用时9ms
		 */
        char []c = String.valueOf(x).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - i -1];
			c[c.length - i -1] = temp;
		}
        //处理正负
        if (c[c.length - 1] == '-') {
			for (int i = c.length - 1; i >= 1; i--) {
				c[i] = c[i - 1];
			}
			c[0] = '-';
		}
        //处理溢出
        long result = Long.parseLong(String.valueOf(c));
        if (result > -Math.pow(2, 31) && result < Math.pow(2, 31) - 1) {
			return (int)result;
		}
		return 0;
    }
	
	public int reverse2(int x) {
		/**
		 * 数字直接转化：
		 * 	取余思想
		 * 1234
		 * ans = 4	43	432	4321
		 */
		long ans = 0;
        int flag = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        int temp = x;
        while(temp != 0){
            ans = ans * 10 + temp % 10;
            temp /= 10;
        }
        return (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) ? 0 : (int)ans*flag;
	}

	public int reverse3(int x) {
		//使用try-catch语句处理溢出异常
		char []c = String.valueOf(x).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - i -1];
			c[c.length - i -1] = temp;
		}
        if (c[c.length - 1] == '-') {
			for (int i = c.length - 1; i >= 1; i--) {
				c[i] = c[i - 1];
			}
			c[0] = '-';
		}
        try {
        	int result = Integer.parseInt(String.valueOf(c));
        	return result;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		char []s = {};
		Reverse rs = new Reverse();
		rs.reverseString(s);
		for (char c : s) {
			System.out.print(c + " ");
		}
		
		int x = 1234;
		System.out.println(rs.reverse3(x));
	}
}

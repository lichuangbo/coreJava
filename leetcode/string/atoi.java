/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月4日
 */
package cn.edu.tit.leetcode;


/**
 * 字符串转换整数 (atoi)
 * @author 李创博
 * @version: 1.0
 */
public class Atoi {
	public int myAtoi(String str) {
		//6ms
		str = str.trim();
		if (str == null || str.length() == 0) {
			return 0;
		}
        char []temp = str.toCharArray();
		double result = 0;
		int sign = 0;
		//处理首字符为符号位情况
		if (temp[0] == '-' || temp[0] == '+') {
			sign = temp[0] == '-' ? -1 : 1;
			for (int i = 1; i < temp.length; i++) {
				if (temp[i] >= '0' && temp[i] <= '9') {
					result = 10 * result + (temp[i] - '0');
				}else {
					break;
				}
			}
			result = result * sign;
			//处理首字符为数字情况
		} else if (temp[0] >= '0' && temp[0] <= '9') {
			result = temp[0] - '0';
			for (int i = 1; i < temp.length; i++) {
				if (temp[i] >= '0' && temp[i] <= '9') {
					result = 10 * result + (temp[i] - '0');
				}else {
					break;
				}
			}
		} else {
			return 0;
		}
		//处理溢出
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}else if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}else {
			return (int)result;
		}
	}

	public int myAtoi2(String str) {
		if (str.trim().isEmpty()) 
			return 0;    
	    str = str.trim();
	    int sign = 1, base = 0, i = 0;
	   
	    if (str.charAt(i) == '-' || str.charAt(i) == '+')
	        sign = str.charAt(i++) == '-' ? -1 : 1;
	    
	    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	    	/**
	    	 * 如果base > MAX_VALUE/10，那么base*10+new_value一定大于MAX_VALUE，会发生溢出。
	    	 * 若base==INT_MAX/10，而且new_value=str.charAt(i++)-'0大于7，也会发生溢出。
	    	 * 因为`MAX_VALUE = 2147483647
	    	 * 可以看作一种固定的处理溢出的办法
	    	 */
	        if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
	            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	        }
	        base = 10 * base + (str.charAt(i++) - '0');
	    }
	    return base * sign;
	}
	
	public static void main(String[] args) {
		String str = "9";
		Atoi myAtoi = new Atoi();
		System.out.println(myAtoi.myAtoi(str));
	}
}

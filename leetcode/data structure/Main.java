/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月7日
 */
package cn.edu.tit.leetcode;

import java.util.Scanner;

/**
 * @author 李创博
 * @version: 1.0
 */
public class Main{
    public static void main(String []args){   	
    	/** 
    	 * 1,5,4,3,2
    	 * 1,5,2,3,4
    	 * 1,5,2,4,3
    	 */
    	ListNode node = pushNode();
    	ListNode.showNode(node);
    	
    	while(node.next.next != null) {
    		ListNode revNode = reverseNode(node.next);
    		ListNode.showNode(revNode);
    		node = revNode;
    	}
    }
    
    //将从node节点开始之后的节点全部反转
    public static ListNode reverseNode(ListNode node) {
    	ListNode prev = node;
	    ListNode cur = prev.next;
	    ListNode tempNode = cur.next;
	    int count = 0;
	    while(cur != null) {
	    	count++;
	    	tempNode = cur.next;
	    	cur.next = prev;
	    	//第一次将最后的节点next指针置为null
	    	if (count == 1) {
				prev.next = null;
			}
	    	prev = cur;
	    	cur = tempNode;
	    }
	    return prev;
    }
    
    public static ListNode pushNode() {
//    	Scanner sc = new Scanner(System.in);
//    	String str = sc.nextLine();
    	String str = "1,2,3,4,5";
    	String []num = str.split(",");
    	ListNode node0 = new ListNode(num[0]);
    	ListNode node1 = null;
    	ListNode curNode = node0;
    	for (int i = 1; i < num.length; i++) {
			node1 = new ListNode(num[i]);
			curNode.next = node1;
			curNode = node1;
		}
        node1.next = null;
    	
    	return node0;
    }
}

class ListNode {
	String val;
	ListNode next;
	ListNode(String x) { 
		val = x; 
	}
	
	public static void showNode(ListNode node) {
		while(node.next != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println(node.val);
	}
}

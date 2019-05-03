/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月3日
 */
package cn.edu.tit.leetcode;


/**
 * 删除链表中的节点
 * @author 李创博
 * @version: 1.0
 */
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x; 
	}
	
	public static void deleteNode(ListNode node) {
		/**
		 * node1-->node2-->node3-->node4
		 * 不知道被删节点的前节点，只能将后边元素复制过来
		 */
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	public static void showNode(ListNode node) {
		while(node.next != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.print(node.val);
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		showNode(node1);
		
		deleteNode(node2);
		System.out.println();
		showNode(node1);
	}
}

/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月4日
 */
package cn.edu.tit.leetcode;

/**
 * @author 李创博
 * @version: 1.0
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		/**
		 * 三指针，prev cur tempNode,prev左指针,cur右指针,tempNode记录cur的下一节点(确保找到下一节点位置)
		 * cur和tempNode断开去连接prev，然后prev,cur往后走继续操作下一节点
		 * 测试耗时：1ms
		 */
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = head;
	    ListNode cur = head.next;
	    ListNode tempNode = cur.next;
	    while(cur != null) {
	    	tempNode = cur.next;
	    	cur.next = prev;
	    	prev = cur;
	    	cur = tempNode;
	    }
	    head.next = null;
		return prev;
    }

	public ListNode reverseList2(ListNode head) {
		//递归出口
        if(head == null || head.next == null) 
        	return head;
        else {
        	//递归子情况，pre来保存新链表的头指针
        	ListNode pre = reverseList2(head.next);
        	head.next.next = head;
        	head.next = null;//将原链表断开连接
        	return pre;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode.showNode(node1);
		
		System.out.println();
		ReverseList rl = new ReverseList();
		ListNode.showNode(rl.reverseList2(node1));
	}
}

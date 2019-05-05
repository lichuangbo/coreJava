/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月5日
 */
package cn.edu.tit.leetcode;

/**
 * 合并两个有序链表为一个有序链表
 * @author 李创博
 * @version: 1.0
 */
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//2ms
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null && l2 != null) {
        	if (l1.val <= l2.val) {
        		cur.next = l1;
        		cur = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				cur = l2;
				l2 = l2.next;
			}
        }
        //收尾
        cur.next = (l1 == null) ? l2 : l1;
		return res.next;
    }
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		//递归做法
		if(l1 == null) 
			return l2;
        if(l2 == null) 
        	return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        }else{
        	l2.next = mergeTwoLists(l1, l2.next);
        	return l2;
        }
	}
	
	public static void main(String[] args) {
		MergeTwoLists mtl = new MergeTwoLists();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		ListNode.showNode(node1);
		
		ListNode node11 = new ListNode(1);
		ListNode node22 = new ListNode(3);
		ListNode node33 = new ListNode(4);
		node11.next = node22;
		node22.next = node33;
		ListNode.showNode(node11);
		
		ListNode result = mtl.mergeTwoLists2(node1, node11);
		ListNode.showNode(result);
	}
}

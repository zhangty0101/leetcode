package listAndTree.mergeKLists;

/**
  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

  示例:

  输入:
  [
    1->4->5,
    1->3->4,
    2->6
  ]
  输出: 1->1->2->3->4->4->5->6
 */

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    // 分治思想，简化成合并两个链表
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }

        int len = lists.length;
        int mid = len / 2;

        ListNode[] l1 = new ListNode[mid];
        for (int i=0; i<mid; i++) {
            l1[i] = lists[i];
        }

        ListNode[] l2 = new ListNode[len - mid];
        for (int i=mid; i<len; i++) {
            l2[i-mid] = lists[i];
        }

        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead;
        if (l1.val < l2.val) {
            newHead = new ListNode(l1.val);
            newHead.next = mergeTwoLists(l1.next, l2);
        } else {
            newHead = new ListNode(l2.val);
            newHead.next = mergeTwoLists(l1, l2.next);
        }
        return newHead;
    }
}

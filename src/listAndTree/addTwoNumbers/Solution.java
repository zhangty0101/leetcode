package listAndTree.addTwoNumbers;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 逆序存储，与正常计算顺序一致，注意进位和长度不一样的情况
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode l3 = res;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val: 0;
            int y = l2 != null ? l2.val: 0;
            int sum = x + y + carry;
            l3.next = new ListNode(sum % 10);
            carry = sum / 10;
            l3 = l3.next;
            l1 = l1 != null? l1.next: null;
            l2 = l2 != null? l2.next: null;
        }
        if (carry > 0) {
            l3.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
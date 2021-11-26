package listAndTree.sortList;

public class Solution {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找出中点
        ListNode low = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        // 递归排序前半部分和后半部分
        ListNode l1 = sortList(low.next);
        low.next = null;
        ListNode l2 = sortList(head);

        // 合并有序链表
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        ListNode head = solution.sortList(n4);
        System.out.print(head.val);
        head = head.next;
        while(head != null){
            System.out.print("," + head.val);
            head = head.next;
        }
        System.out.println("");
    }
}

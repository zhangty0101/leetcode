package listAndTree.detectCycle;

/**
 *  返回该章节
 *   环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 快慢指针，如果是环形，则快慢指针最终将相等
     * 设从head到环形开始结点的距离是A，慢指针从环形开始结点走到相遇点走过的路程是B，
     * 环的长度是L。于是有：
     *
     * 对慢指针，从head走到meet的距离为A+B
     * 对快指针，从head走到meet的距离为2A+2B（因为快指针的速度是慢指针的两倍，而在相遇时它们走了相同的时间）
     * 相遇时，慢指针被快指针套了一圈，即快指针比慢指针多走一圈
     * 根据以上分析我们可以列一个等式：A+B+L = 2A+2B，可以解得L = A + B。
     * 从这个结果可以看出，meet到begin的距离也是A。这意味着，如果我们分别放两个指针在head和meet，
     * 让它们以相同的速度前进，它们第一次相遇的地方就是我们要找的环形开始结点。
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

package listAndTree.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 分层遍历
     * 用一个queue存储树上每一层的元素
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 1;
        int nextNum = 0;
        boolean isLTR = true;
        while (!queue.isEmpty()) {
            TreeNode now = queue.poll();
            if(now.left != null) {
                queue.add(now.left);
                nextNum++;
            }
            if (now.right != null) {
                queue.add(now.right);
                nextNum++;
            }
            if (isLTR) {
                list.add(now.val);
            } else {
                list.addFirst(now.val);
            }
            curNum--;
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                isLTR = !isLTR;
                res.add(list);
                list = new LinkedList<>();
            }
        }
        return res;
    }
}

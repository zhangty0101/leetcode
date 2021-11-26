package dynamic.minimumTotal;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution {

    /**
     * 从下往上遍历
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()];
        // 用最后一行初始化
        for (int i=0; i<triangle.size(); i++) {
            res[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i=triangle.size() - 2; i>=0; i++) {
            for (int j=0; j<i; j++) {
                res[j] = triangle.get(i).get(j) + Math.max(res[j], res[j+1]);
            }
        }

        return res[0];
    }
}

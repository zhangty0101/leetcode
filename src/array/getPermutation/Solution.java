package array.getPermutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */

public class Solution {
    /**
     * 不要暴力循环，直接根据特征计算出每个位置的值
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        k--;

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i=1; i<n; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        List<Integer> list = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            int index = k / factorial[i];
            sb.append(list.remove(index));
            k %= factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(4, 9));
    }
}

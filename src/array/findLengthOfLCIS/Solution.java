package array.findLengthOfLCIS;

/**
 *给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 */

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int pre = nums[0];
        int maxLen = 1;
        int len = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > pre) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 1;
            }
            pre = nums[i];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1};
        System.out.println(solution.findLengthOfLCIS(nums));
    }
}

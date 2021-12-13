package array.longestConsecutive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution {

    /**
     * 先排序，然后从小到大找, 注意重复的数字, 时间复杂度不满足
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 1;
        int len = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                len++;
                res = Math.max(len, res);
            } else if (nums[i] - nums[i - 1] > 1) {
                len = 1;
            }
        }
        return res;
    }

    /**
     * 数组中出现过元素nums[i]-1或nums[i]+1，意味着当前元素可以归入左或右序列，
     * 那么此时假如左右序列的长度分别为left、right，那么显然加入nums[i]后，
     * 这整段序列的长度为 1+left+right，而由于这一整段序列中，只可能在左右两端扩展，
     * 所以只需要更新左右两端的value值即可。
     * 数组中未出现过元素nums[i]-1或nums[i]+1，意味着当前元素所在的连续序列就是自身（只有自己一个元素）
     * @param nums
     */
    public int longestConsecutive2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num: nums) {
            if (map.getOrDefault(num, 0) == 0) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                map.put(num, right + left + 1);
                //更新边界
                if (left != 0) {
                    map.put(num - left, right + left + 1);
                }
                if (right != 0) {
                    map.put(num + right, left + right + 1);
                }
                res = Math.max(left + right + 1, res);
            }
        }
        return res;
    }

    public int longestConsecutive3(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashSet<Integer> set = new HashSet();
        for (int num: nums) {
            set.add(num);
        }

        int res = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int curLen = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    curLen++;
                }
                res = Math.max(curLen, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{100, 4, 4, 200, 1, 3, 2, -1, -2};
        System.out.println(solution.longestConsecutive2(nums));
    }
}

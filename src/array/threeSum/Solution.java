package array.threeSum;

import java.util.*;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

public class Solution {

    /**
     * 暴力循环
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(nums[i]);
                        subRes.add(nums[j]);
                        subRes.add(nums[k]);
                        Collections.sort(subRes);
                        if (set.add(subRes)) {
                            res.add(subRes);
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 先对原数组排序，确定第一个数（只可能是负数和0），后面的数用两个指针从前往后和从后往前遍历
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    if (left == i + 1 || nums[left] != nums[left - 1]) {
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        res.add(list);
                    }
                    right--;
                    left++;
                } else if (target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 由于已经排序，可以用双指针来解决
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l>i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                if (r<nums.length - 1 && nums[r] == nums[r+1]){
                    r--;
                    continue;
                }
                if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    r--;
                    l++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 0, 0, 0, 0, 1, -1};
        System.out.println(solution.threeSum1(nums));
    }
}

